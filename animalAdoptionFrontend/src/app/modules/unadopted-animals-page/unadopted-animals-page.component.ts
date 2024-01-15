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

  constructor(private animalService: AnimalService, private subscriptionService : SubscriptionService,
     private photoService: PhotoService, private lostAndFoundService: LostAndFoundService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('token'))

    this.allUnadoptedAnimals()
  }

  public getDOB(date : Date): string {
    let day = date.getDate();
    let month = date.getMonth() + 1;
    let year = date.getFullYear();
    let dob = day + '.' + month + '.' + year + '.'
    return dob
  }

  allUnadoptedAnimals(){
    this.animalService.allUnadoptedAnimals().subscribe((response: any) => {
      console.log(response)

      this.unadoptedAnimals = JSON.parse(response)

      this.addSubscriptionStatus()

    }
   );
  }
  addSubscriptionStatus() {
    
    let unadoptedAnimalsList : Array<AnimalWithSubscription> = new Array()

    this.unadoptedAnimals.forEach(animal => {
      let animalWithSubscription : AnimalWithSubscription = new AnimalWithSubscription

      this.subscriptionService.subscriptionExists(animal.animalId).subscribe((response: any) => {
        
      this.lostAndFoundService.lostAndFoundExists(animal.animalId).subscribe((responseLAF: any) => {

        if(responseLAF === "false") {
        console.log(animal)
        // console.log(animalWithSubscription)

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
        // console.log(animalWithSubscription)
        // console.log(adoptedAnimalsList)
console.log(response)
        if(response == "false"){
          animalWithSubscription.subscription = false
        }
        if(response == "true"){
          animalWithSubscription.subscription = true
        }
  //       let addAnimal = animalWithSubscription
        unadoptedAnimalsList.push(animalWithSubscription)
        // console.log(animalWithSubscription)
        console.log(unadoptedAnimalsList)
        this.unadoptedAnimalsWithSubscription = unadoptedAnimalsList.sort((a, b) => new Date(a.dateOfBirth).getTime() - new Date(b.dateOfBirth).getTime())

        console.log(this.unadoptedAnimalsWithSubscription)

        }
      });
    })    
      

      this.photoService.allAnimalPhotos(animal.animalId).subscribe((response: any) => {
        const allPhotos = JSON.parse(response)
  
        animalWithSubscription.photoURL = "\\assets\\images\\"+allPhotos[0].photoURL
        // @ts-ignore
          let photoURL : string
          photoURL ="\\assets\\images\\"+allPhotos[0]
  
        console.log(allPhotos[0].photoURL)
      });
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
      console.log(subscriptionId)

      this.subscriptionService.unsubscribe(subscriptionId).subscribe((response: any) => {
        console.log(response)
  
        // alert('Successfully registered');
  
        window.location.reload()
      }
      );
    });
  }

  read(animalId : string){

    this.animalService.read(animalId).subscribe((response: any) => {
      let animalId = JSON.parse(response).animalId
      let animalIdString = JSON.stringify(animalId)
      
      localStorage.setItem('selectedAnimalProfileId', animalId)
      console.log(localStorage.getItem('selectedAnimalProfileId'))
      console.log(animalIdString)

      // alert('Successfully registered');

      const animalURL = `animal-profile/${animalId}`;
      window.location.href = animalURL;

      // window.location.href = '/unadopted-animals'
    });
  }

  search() {
    if(this.searchInput == ""){
      console.log("nista nije upisano")
    }
    else{
      let searchRequest : SearchRequestDTO = new SearchRequestDTO
      searchRequest.searchInput = this.searchInput
      searchRequest.animals = this.unadoptedAnimals

      this.animalService.search(searchRequest).subscribe((response: any) => {
        console.log(response)
        this.unadoptedAnimals = JSON.parse(response)
        this.unadoptedAnimalsWithSubscription = JSON.parse(response)

        this.addSubscriptionStatus()
       
      });
    }
  }
  }
