import { Component } from '@angular/core';
import { Animal } from '../model/animal.model';
import { AnimalService } from '../service/animal.service';
import { SubscriptionService } from '../service/subscription.service';
import { NewSubscription } from '../model/new-subscription.model';
import { AnimalWithSubscription } from '../model/animal-with-subscription.model';
import { PhotoService } from '../service/photo.service';
import { SearchRequestDTO } from '../model/search-request-DTO.model';

@Component({
  selector: 'app-adopted-animals-page',
  templateUrl: './adopted-animals-page.component.html',
  styleUrls: ['./adopted-animals-page.component.css']
})
export class AdoptedAnimalsPageComponent {

  adoptedAnimals : Array<Animal> = new Array()
  adoptedAnimalsWithSubscription : Array<AnimalWithSubscription> = new Array()
  public dob: string = ""
  public searchInput: string = ""
  public loggedUserJwt = localStorage.getItem('token');

  constructor(private animalService: AnimalService, private subscriptionService : SubscriptionService, 
    private photoService: PhotoService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('token'))

    if(this.loggedUserJwt !== null){
      this.allAdoptedAnimalsWithSubscription()
    }
    else{
      this.allAdoptedAnimals()
    }  }

  public getDOB(date : Date): string {
    let day = date.getDate();
    let month = date.getMonth() + 1;
    let year = date.getFullYear();
    let dob = day + '.' + month + '.' + year + '.'
    return dob
  }

  allAdoptedAnimalsWithSubscription(){
    this.animalService.allAdoptedAnimals().subscribe((response: any) => {
      
      this.adoptedAnimals = JSON.parse(response)
      console.log(this.adoptedAnimals)
      
      this.addSubscriptionStatus()
    });
  }

  allAdoptedAnimals(){
    this.animalService.allAdoptedAnimals().subscribe((response: any) => {
      this.adoptedAnimals = JSON.parse(response)

      this.adoptedAnimals.forEach(animal => {
        animal.dob = this.getDOB(new Date(animal.dateOfBirth))
          this.adoptedAnimals = this.adoptedAnimals.sort((a, b) => new Date(a.dateOfBirth).getTime() - new Date(b.dateOfBirth).getTime())
            this.photoService.allAnimalPhotos(animal.animalId).subscribe((response: any) => {
              const allPhotos = JSON.parse(response)
              animal.photoURL = "\\assets\\images\\" + allPhotos[0].photoURL
              // @ts-ignore
                photoURL ="\\assets\\images\\" + allPhotos[0]
            });      
        })    
      });
   console.log(this.adoptedAnimals)
  }

  addSubscriptionStatus() {
    
    let adoptedAnimalsList : Array<AnimalWithSubscription> = new Array()

    this.adoptedAnimals.forEach(animal => {
      let animalWithSubscription : AnimalWithSubscription = new AnimalWithSubscription

      this.subscriptionService.subscriptionExists(animal.animalId).subscribe((response: any) => {

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
        if(response == "false"){
          animalWithSubscription.subscription = false
        }
        if(response == "true"){
          animalWithSubscription.subscription = true
        }
        adoptedAnimalsList.push(animalWithSubscription)
        this.adoptedAnimalsWithSubscription = adoptedAnimalsList.sort((a, b) => new Date(a.dateOfBirth).getTime() - new Date(b.dateOfBirth).getTime())
      })    

      
      this.photoService.allAnimalPhotos(animal.animalId).subscribe((response: any) => {
        const allPhotos = JSON.parse(response)
        
        animalWithSubscription.photoURL = "\\assets\\images\\"+allPhotos[0].photoURL
        // @ts-ignore
        let photoURL : string
        photoURL ="\\assets\\images\\"+allPhotos[0]
        
        console.log(allPhotos[0].photoURL)
      });
      
      console.log("animal list:")
      console.log(this.adoptedAnimalsWithSubscription)
    });
  }

  subscribe(animalId : string){

    let subscription = new NewSubscription

    subscription.animalId = animalId
    // subscription.userId = localStorage.getItem('loggedUserEmail')
    this.subscriptionService.subscribe(subscription).subscribe((response: any) => {
      console.log(response)

      // alert('Successfully registered');

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
      searchRequest.animals = this.adoptedAnimals

      this.animalService.search(searchRequest).subscribe((response: any) => {
        console.log(response)
        this.adoptedAnimals = JSON.parse(response)
        this.adoptedAnimalsWithSubscription = JSON.parse(response)

        this.addSubscriptionStatus()
       
      });
    }
  }
}
