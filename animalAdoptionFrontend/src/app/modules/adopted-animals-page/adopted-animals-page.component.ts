import { Component } from '@angular/core';
import { Animal } from '../model/animal.model';
import { AnimalService } from '../service/animal.service';
import { SubscriptionService } from '../service/subscription.service';
import { NewSubscription } from '../model/newSubscription.model';
import { AnimalWithSubscription } from '../model/animalWithSubscription.model';

@Component({
  selector: 'app-adopted-animals-page',
  templateUrl: './adopted-animals-page.component.html',
  styleUrls: ['./adopted-animals-page.component.css']
})
export class AdoptedAnimalsPageComponent {

  adoptedAnimals : Array<Animal> = new Array()
  adoptedAnimalsWithSubscription : Array<AnimalWithSubscription> = new Array()

  constructor(private animalService: AnimalService, private subscriptionService : SubscriptionService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('token'))

    this.allAdoptedAnimals()
  }

  allAdoptedAnimals(){
    this.animalService.allAdoptedAnimals().subscribe((response: any) => {
      
      this.adoptedAnimals = JSON.parse(response)
      console.log(this.adoptedAnimals)
      
      
      this.addSubscriptionStatus()
    });
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
        // console.log(animalWithSubscription)
        // console.log(adoptedAnimalsList)
console.log(response)
        if(response == "false"){
          animalWithSubscription.subscription = false
          console.log(animalWithSubscription)
          console.log(adoptedAnimalsList)
        }
        if(response == "true"){
          animalWithSubscription.subscription = true
          console.log(animalWithSubscription)
          console.log(adoptedAnimalsList)
        }
        console.log(animalWithSubscription)
        console.log(adoptedAnimalsList)
  //       let addAnimal = animalWithSubscription
        adoptedAnimalsList.push(animalWithSubscription)
        // console.log(animalWithSubscription)
        console.log(adoptedAnimalsList)
        this.adoptedAnimalsWithSubscription = adoptedAnimalsList

        console.log(this.adoptedAnimalsWithSubscription)
      })    
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
}
