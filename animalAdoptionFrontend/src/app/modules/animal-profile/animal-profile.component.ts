import { Component } from '@angular/core';
import { AnimalService } from '../service/animal.service';
import { SubscriptionService } from '../service/subscription.service';
import { AnimalWithSubscription } from '../model/animalWithSubscription.model';
import { NewSubscription } from '../model/newSubscription.model';
import { AdoptionService } from '../service/adoption.service';
import { Adoption } from '../model/adoption.model';

@Component({
  selector: 'app-animal-profile',
  templateUrl: './animal-profile.component.html',
  styleUrls: ['./animal-profile.component.css']
})
export class AnimalProfileComponent {

  public selectedAnimalProfileId = localStorage.getItem('selectedAnimalProfileId')
  public selectedAnimalProfile : AnimalWithSubscription = new AnimalWithSubscription
  public userIsAdmin = localStorage.getItem('userIsAdmin')
  public adoption : Adoption = new Adoption
  public animalAdopted !: String
  constructor(private animalService: AnimalService, private subscriptionService: SubscriptionService,private adoptionService: AdoptionService) { }

  ngOnInit(): void {

    this.read()
  }

  read(){
    this.animalService.read(this.selectedAnimalProfileId!).subscribe((response: any) => {
      console.log(JSON.parse(response))
      this.selectedAnimalProfile = JSON.parse(response)

      this.addSubscriptionStatus()
      this.setAdoptionStatus()
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
  
  delete(animalId : string){

    this.animalService.delete(animalId).subscribe((response: any) => {
      console.log(response)
      
      window.location.href = '/adopted-animals'
    });
  }

  setAdoptionStatus(){
    this.adoptionService.animalAdopted(this.selectedAnimalProfile.animalId).subscribe((response: any) => {
      this.animalAdopted = response
      console.log(this.animalAdopted)
    });
  }

  adopt(animalId : string){
    console.log(animalId)

    this.adoption.adoptionDate = new Date
    this.adoption.adoptionStatus = ""
    this.adoption.animalId = animalId
    this.adoption.userId = ""

    this.adoptionService.create(this.adoption).subscribe((response: any) => {
      console.log(response)

      alert('You will be contacted by our admin as soon as possible via email');

      // window.location.href = '/login-user'
    },
    (error) => {
      alert("Your request filed");
      console.log(error);
    }
   );
  }
  
}
