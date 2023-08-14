import { Component } from '@angular/core';
import { AnimalService } from '../service/animal.service';
import { Animal } from '../model/animal.model';
import { SubscriptionService } from '../service/subscription.service';
import { Subscription } from 'rxjs';
import { NewSubscription } from '../model/newSubscription.model';

@Component({
  selector: 'app-unadopted-animals-page',
  templateUrl: './unadopted-animals-page.component.html',
  styleUrls: ['./unadopted-animals-page.component.css']
})
export class UnadoptedAnimalsPageComponent {

  adoptedAnimals : Array<Animal> = new Array()

  constructor(private animalService: AnimalService, private subscriptionService : SubscriptionService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('token'))

    this.allAdoptedAnimals()
  }

  allAdoptedAnimals(){
    this.animalService.allAdoptedAnimals().subscribe((response: any) => {
      console.log(response)

      this.adoptedAnimals = JSON.parse(response)

    }
   );
  }

  subscribe(animalId : string){

    console.log("uslo")
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
