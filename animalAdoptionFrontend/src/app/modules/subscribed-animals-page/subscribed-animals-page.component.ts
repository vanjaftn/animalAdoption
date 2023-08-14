import { Component } from '@angular/core';
import { NewSubscription } from '../model/newSubscription.model';
import { AnimalService } from '../service/animal.service';
import { SubscriptionService } from '../service/subscription.service';
import { Animal } from '../model/animal.model';

@Component({
  selector: 'app-subscribed-animals-page',
  templateUrl: './subscribed-animals-page.component.html',
  styleUrls: ['./subscribed-animals-page.component.css']
})
export class SubscribedAnimalsPageComponent {
  subscribedAnimals : Array<Animal> = new Array()

  constructor(private animalService: AnimalService, private subscriptionService : SubscriptionService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('token'))

    this.allUsersSubscribedAnimals()
  }

  allUsersSubscribedAnimals(){
    this.animalService.allSubscribedAnimals().subscribe((response: any) => {
      console.log(response)

      this.subscribedAnimals = JSON.parse(response)

    }
   );
  }

  subscribe(animalId : string){

    let subscription = new NewSubscription

    subscription.animalId = animalId
    // subscription.userId = localStorage.getItem('loggedUserEmail')
    this.subscriptionService.subscribe(subscription).subscribe((response: any) => {
      console.log(response)

      // alert('Successfully registered');

      // window.location.href = '/login-user'
    }
    );
  }
}
