import { Component } from '@angular/core';
import { AnimalService } from '../service/animal.service';
import { Animal } from '../model/animal.model';
import { SubscriptionService } from '../service/subscription.service';
import { Subscription } from 'rxjs';
import { NewSubscription } from '../model/newSubscription.model';
import { AnimalWithSubscription } from '../model/animalWithSubscription.model';

@Component({
  selector: 'app-unadopted-animals-page',
  templateUrl: './unadopted-animals-page.component.html',
  styleUrls: ['./unadopted-animals-page.component.css']
})
export class UnadoptedAnimalsPageComponent {

  unadoptedAnimals : Array<Animal> = new Array()
  unadoptedAnimalsWithSubscription : Array<AnimalWithSubscription> = new Array()

  constructor(private animalService: AnimalService, private subscriptionService : SubscriptionService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('token'))

    this.allUnadoptedAnimals()
  }

  allUnadoptedAnimals(){
    this.animalService.allAnimals().subscribe((response: any) => {
      console.log(response)

      this.unadoptedAnimals = JSON.parse(response)

      this.addSubscriptionStatus()

    }
   );
  }
  addSubscriptionStatus() {
    
    let adoptedAnimalsList : Array<AnimalWithSubscription> = new Array()

    this.unadoptedAnimals.forEach(animal => {
      let animalWithSubscription : AnimalWithSubscription = new AnimalWithSubscription

      this.subscriptionService.subscriptionExists(animal.animalId).subscribe((response: any) => {

        console.log(animal)
        // console.log(animalWithSubscription)

        animalWithSubscription.animalId = animal.animalId
        animalWithSubscription.dateOfBirth = animal.dateOfBirth
        animalWithSubscription.name = animal.name
        animalWithSubscription.location = animal.location
        animalWithSubscription.description = animal.description
        animalWithSubscription.chipNumber = animal.chipNumber
        animalWithSubscription.animalTypeId = animal.animalTypeId
        animalWithSubscription.photoURLs = animal.photoURLs
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
        this.unadoptedAnimalsWithSubscription = adoptedAnimalsList

        console.log(this.unadoptedAnimalsWithSubscription)
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

        window.location.href = '/adopted-animals'
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
  
        window.location.href = '/adopted-animals'
      }
      );
    });
  }
}
