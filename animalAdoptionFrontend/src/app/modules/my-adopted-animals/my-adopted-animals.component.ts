import { Component } from '@angular/core';
import { Animal } from '../model/animal.model';
import { AnimalService } from '../service/animal.service';
import { SubscriptionService } from '../service/subscription.service';
import { NewSubscription } from '../model/new-subscription.model';
import { AnimalWithSubscription } from '../model/animal-with-subscription.model';
import { PhotoService } from '../service/photo.service';
import { SearchRequestDTO } from '../model/search-request-DTO.model';
import { AdoptionService } from '../service/adoption.service';
import { Adoption } from '../model/adoption.model';

@Component({
  selector: 'app-my-adopted-animals',
  templateUrl: './my-adopted-animals.component.html',
  styleUrls: ['./my-adopted-animals.component.css']
})
export class MyAdoptedAnimalsComponent {
  myAdoptedAnimals : Array<Animal> = new Array()
  public searchInput: string = ""

  constructor(private animalService: AnimalService, private adoptionService: AdoptionService, private photoService: PhotoService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('token'))

    this.readMyAdoptions()
  }

  public getDOB(date : Date): string {
    let day = date.getDate();
    let month = date.getMonth() + 1;
    let year = date.getFullYear();
    let dob = day + '.' + month + '.' + year + '.'
    return dob
  }

  readMyAdoptions(){
    this.adoptionService.readAllUsersAdoptions().subscribe((response: any) => {
      
      console.log(response)
      let myAdoptions: Array<Adoption> = JSON.parse(response)
      myAdoptions.forEach(adoption => {
        
        this.animalService.read(adoption.animalId).subscribe((response: any) => {
          console.log(JSON.parse(response))

          let animal: Animal = JSON.parse(response)

          animal.dob = this.getDOB(new Date(animal.dateOfBirth))

          this.photoService.allAnimalPhotos(animal.animalId).subscribe((response: any) => {
            const allPhotos = JSON.parse(response)
      
            animal.photoURL = "\\assets\\images\\"+allPhotos[0].photoURL
            // @ts-ignore
              let photoURL : string
              photoURL ="\\assets\\images\\"+allPhotos[0]
      
            console.log(allPhotos[0].photoURL)
          });
          this.myAdoptedAnimals.push(animal)
        });
          this.myAdoptedAnimals = this.myAdoptedAnimals.sort((a, b) => new Date(a.dateOfBirth).getTime() - new Date(b.dateOfBirth).getTime())
        
      });
      
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
