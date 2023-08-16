import { Component } from '@angular/core';
import { AnimalService } from '../service/animal.service';
import { SubscriptionService } from '../service/subscription.service';
import { AnimalWithSubscription } from '../model/animalWithSubscription.model';
import { NewSubscription } from '../model/newSubscription.model';
import { Animal } from '../model/animal.model';

@Component({
  selector: 'app-animal-profile',
  templateUrl: './animal-profile.component.html',
  styleUrls: ['./animal-profile.component.css']
})
export class AnimalProfileComponent {

  public selectedAnimalProfileId = localStorage.getItem('selectedAnimalProfileId')
  public selectedAnimalProfile : AnimalWithSubscription = new AnimalWithSubscription
  
  constructor(private animalService: AnimalService, private subscriptionService : SubscriptionService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('token'))
    console.log(this.selectedAnimalProfileId)

    this.read()
  }

  read(){
    this.animalService.read(this.selectedAnimalProfileId!).subscribe((response: any) => {
      console.log(JSON.parse(response))
      this.selectedAnimalProfile = JSON.parse(response)

      this.addSubscriptionStatus()
    }
   );
  }

  addSubscriptionStatus() {
    
      let animalWithSubscription : AnimalWithSubscription = new AnimalWithSubscription

      this.subscriptionService.subscriptionExists(this.selectedAnimalProfile.animalId).subscribe((response: any) => {

        console.log(this.selectedAnimalProfile)
        // console.log(animalWithSubscription)

        animalWithSubscription.animalId = this.selectedAnimalProfile.animalId
        animalWithSubscription.dateOfBirth = this.selectedAnimalProfile.dateOfBirth
        animalWithSubscription.name = this.selectedAnimalProfile.name
        animalWithSubscription.location = this.selectedAnimalProfile.location
        animalWithSubscription.description = this.selectedAnimalProfile.description
        animalWithSubscription.chipNumber = this.selectedAnimalProfile.chipNumber
        animalWithSubscription.animalTypeId = this.selectedAnimalProfile.animalTypeId
        animalWithSubscription.photoURLs = this.selectedAnimalProfile.photoURLs
        animalWithSubscription.size = this.selectedAnimalProfile.size
        animalWithSubscription.sterilized = this.selectedAnimalProfile.sterilized
        // console.log(animalWithSubscription)
        // console.log(adoptedAnimalsList)
        console.log(response)
        if(response == "false"){
          animalWithSubscription.subscription = false
        }
        if(response == "true"){
          animalWithSubscription.subscription = true
        }
        console.log(animalWithSubscription)
        this.selectedAnimalProfile = animalWithSubscription
      })    
  }

  subscribe(animalId : string){

    let subscription = new NewSubscription

    subscription.animalId = animalId
    // subscription.userId = localStorage.getItem('loggedUserEmail')
    this.subscriptionService.subscribe(subscription).subscribe((response: any) => {
      console.log(response)

      // alert('Successfully registered');

        // window.location.href = '/adopted-animals'
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
  
        // window.location.href = '/adopted-animals'
      }
      );
    });
  }
  
}
