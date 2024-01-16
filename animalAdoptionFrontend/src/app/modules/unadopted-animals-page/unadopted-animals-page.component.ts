import { Component } from '@angular/core';
import { AnimalService } from '../service/animal.service';
import { Animal } from '../model/animal.model';
import { SubscriptionService } from '../service/subscription.service';
import { Subscription } from 'rxjs';
import { NewSubscription } from '../model/new-subscription.model';
import { AnimalWithSubscription } from '../model/animal-with-subscription.model';
import { PhotoService } from '../service/photo.service';
import { LostAndFoundService } from '../service/lostAndFound.service';
import { SearchRequestDTO } from '../model/search-request-DTO.model';

@Component({
  selector: 'app-unadopted-animals-page',
  templateUrl: './unadopted-animals-page.component.html',
  styleUrls: ['./unadopted-animals-page.component.css']
})
export class UnadoptedAnimalsPageComponent {

  unadoptedAnimals : Array<Animal> = new Array()
  unadoptedAnimalsWithSubscription : Array<AnimalWithSubscription> = new Array()
  public searchInput: string = ""
  public loggedUserJwt = localStorage.getItem('token');

  constructor(private animalService: AnimalService, private subscriptionService : SubscriptionService,
     private photoService: PhotoService, private lostAndFoundService: LostAndFoundService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('token'))

    if(this.loggedUserJwt !== null){
      this.allUnadoptedAnimalsWithSubscription()
    }
    else{
      this.allUnadoptedAnimals()
    }
  }

  public getDOB(date : Date): string {
    let day = date.getDate();
    let month = date.getMonth() + 1;
    let year = date.getFullYear();
    let dob = day + '.' + month + '.' + year + '.'
    return dob
  }

  allUnadoptedAnimalsWithSubscription(){
    this.animalService.allUnadoptedAnimals().subscribe((response: any) => {
      console.log(response)
      this.unadoptedAnimals = JSON.parse(response)
      this.addSubscriptionStatus()
    }
   );
  }

  allUnadoptedAnimals(){
    this.animalService.allUnadoptedAnimals().subscribe((response: any) => {
      this.unadoptedAnimals = JSON.parse(response)

      this.unadoptedAnimals.forEach(animal => {
          // this.lostAndFoundService.lostAndFoundExists(animal.animalId).subscribe((responseLAF: any) => {

            this.unadoptedAnimals = this.unadoptedAnimals.sort((a, b) => new Date(a.dateOfBirth).getTime() - new Date(b.dateOfBirth).getTime())
          // });
          this.photoService.allAnimalPhotos(animal.animalId).subscribe((response: any) => {
            const allPhotos = JSON.parse(response)
            animal.photoURL = "\\assets\\images\\" + allPhotos[0].photoURL
            // @ts-ignore
              photoURL ="\\assets\\images\\" + allPhotos[0]
          });      
        })    
      });
   console.log(this.unadoptedAnimals)
  }
  
  addSubscriptionStatus() {
    let unadoptedAnimalsList : Array<AnimalWithSubscription> = new Array()
    this.unadoptedAnimals.forEach(animal => {
      let animalWithSubscription : AnimalWithSubscription = new AnimalWithSubscription
      this.subscriptionService.subscriptionExists(animal.animalId).subscribe((response: any) => {
        this.lostAndFoundService.lostAndFoundExists(animal.animalId).subscribe((responseLAF: any) => {
          if(responseLAF === "false") {
          animalWithSubscription.animalId = animal.animalId
          animalWithSubscription.dateOfBirth = animal.dateOfBirth
          animalWithSubscription.name = animal.name
          animalWithSubscription.gender = animal.gender
          animalWithSubscription.location = animal.location
          animalWithSubscription.description = animal.description
          animalWithSubscription.chipNumber = animal.chipNumber
          animalWithSubscription.animalType = animal.animalType
          animalWithSubscription.size = animal.size
          animalWithSubscription.sterilized = animal.sterilized
          animalWithSubscription.dob = this.getDOB(new Date(animal.dateOfBirth))

            if(response == "false"){
              animalWithSubscription.subscription = false
            }
            if(response == "true"){
              animalWithSubscription.subscription = true
            }
          unadoptedAnimalsList.push(animalWithSubscription)
          this.unadoptedAnimalsWithSubscription = unadoptedAnimalsList.sort((a, b) => new Date(a.dateOfBirth).getTime() - new Date(b.dateOfBirth).getTime())
          } 
        });
        this.photoService.allAnimalPhotos(animal.animalId).subscribe((response: any) => {
          const allPhotos = JSON.parse(response)
          animalWithSubscription.photoURL = "\\assets\\images\\" + allPhotos[0].photoURL
          // @ts-ignore
            photoURL ="\\assets\\images\\" + allPhotos[0]
        });      
      })    
    });
  }

  subscribe(animalId : string){
    let subscription = new NewSubscription
    subscription.animalId = animalId
    this.subscriptionService.subscribe(subscription).subscribe((response: any) => {
      window.location.reload()
    }
    );
  }

  unsubscribe(animalId : string){
    this.subscriptionService.readByAnimalId(animalId).subscribe((response: any) => {
      let subscriptionId = JSON.parse(response).subscriptionId
      this.subscriptionService.unsubscribe(subscriptionId).subscribe((response: any) => {
        window.location.reload()
      }
      );
    });
  }

  read(animalId : string){
    this.animalService.read(animalId).subscribe((response: any) => {
      let animalId = JSON.parse(response).animalId
      localStorage.setItem('selectedAnimalProfileId', animalId)
      const animalURL = `animal-profile/${animalId}`;
      window.location.href = animalURL;
    });
  }

  search() {
    if(this.searchInput != ""){
      let searchRequest : SearchRequestDTO = new SearchRequestDTO
      searchRequest.searchInput = this.searchInput
      searchRequest.animals = this.unadoptedAnimals
      this.animalService.search(searchRequest).subscribe((response: any) => {
        this.unadoptedAnimals = JSON.parse(response)
        this.unadoptedAnimalsWithSubscription = JSON.parse(response)
        this.addSubscriptionStatus()
      });
    }
  }
}
