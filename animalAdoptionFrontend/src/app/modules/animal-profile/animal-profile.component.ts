import { Component } from '@angular/core';
import { AnimalService } from '../service/animal.service';
import { SubscriptionService } from '../service/subscription.service';
import { AnimalWithSubscription } from '../model/animalWithSubscription.model';
import { NewSubscription } from '../model/newSubscription.model';
import { AdoptionService } from '../service/adoption.service';
import { Adoption } from '../model/adoption.model';
import { VetService } from '../service/vet.service';

@Component({
  selector: 'app-animal-profile',
  templateUrl: './animal-profile.component.html',
  styleUrls: ['./animal-profile.component.css']
})
export class AnimalProfileComponent {

  public selectedAnimalProfileId = localStorage.getItem('selectedAnimalProfileId')
  public selectedAnimalProfile : AnimalWithSubscription = new AnimalWithSubscription
  public userIsAdmin = localStorage.getItem('userIsAdmin')
  public userIsVet = localStorage.getItem('userIsVet')
  public adoption : Adoption = new Adoption
  public animalAdopted !: String
  public animalSterilized !: String
  
  constructor(private animalService: AnimalService, private subscriptionService: SubscriptionService,
    private adoptionService: AdoptionService, private vetService: VetService) { }

  ngOnInit(): void {

    this.read()
    console.log(this.userIsVet)
  }

  read(){
    this.animalService.read(this.selectedAnimalProfileId!).subscribe((response: any) => {
      console.log(JSON.parse(response))
      this.selectedAnimalProfile = JSON.parse(response)

      this.addSubscriptionStatus()
      this.setAdoptionStatus()
      this.setSterilizationStatus()
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

  subscribe(){

    let subscription = new NewSubscription

    subscription.animalId = this.selectedAnimalProfile.animalId
    // subscription.userId = localStorage.getItem('loggedUserEmail')
    this.subscriptionService.subscribe(subscription).subscribe((response: any) => {
      console.log(response)

      // alert('Successfully registered');

        // window.location.href = '/adopted-animals'
    }
    );
  }

  unsubscribe(){

    this.subscriptionService.readByAnimalId(this.selectedAnimalProfile.animalId).subscribe((response: any) => {
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

  setSterilizationStatus(){
    this.animalService.animalSterilized(this.selectedAnimalProfile.animalId).subscribe((response: any) => {
      this.animalSterilized = response
      console.log(this.animalSterilized)
    });
  }

  adopt(){
    console.log(this.selectedAnimalProfile.animalId)

    this.adoption.adoptionDate = new Date
    this.adoption.adoptionStatus = ""
    this.adoption.animalId = this.selectedAnimalProfile.animalId
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

  adoptionRequestPage(){
    const animalId = this.selectedAnimalProfileId
    const adoptionRequsestURL = `adoption-request-page/${animalId}`;
    window.location.href = adoptionRequsestURL;  
  }

  animalVaccinesPage(){
    const animalId = this.selectedAnimalProfileId
    const adoptionRequsestURL = `animal-vaccines-page/${animalId}`;
    window.location.href = adoptionRequsestURL;  
  }

  animalIsSterilized(){
    this.vetService.animalIsSterilized(this.selectedAnimalProfile).subscribe((response: any) => {
      console.log(response)

      alert('You have checked this animal as sterilized');

      // window.location.href = '/login-user'
    },
    (error) => {
      alert("Failed");
      console.log(error);
    }
   );
  }
  
}
