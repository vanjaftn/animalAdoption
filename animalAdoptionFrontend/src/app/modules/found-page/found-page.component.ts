import { Component } from '@angular/core';
import { Animal } from '../model/animal.model';
import { AnimalService } from '../service/animal.service';
import { PhotoService } from '../service/photo.service';
import { LostAndFoundService } from '../service/lostAndFound.service';

@Component({
  selector: 'app-found-page',
  templateUrl: './found-page.component.html',
  styleUrls: ['./found-page.component.css']
})
export class FoundPageComponent {
  animals : Array<Animal> = new Array()
  LostAndFounds : Array<Animal> = new Array()
  public dob: string =""

  constructor(private animalService: AnimalService, private photoService: PhotoService, private lostAndFoundService: LostAndFoundService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('token'))

    this.allAnimals()
  }

  public getDOB(date : Date): string {
    let day = date.getDate();
    let month = date.getMonth() + 1;
    let year = date.getFullYear();
    let dob = day + '.' + month + '.' + year + '.'
    return dob
  }

  allAnimals(){
  
    this.lostAndFoundService.readAllFoundApproved().subscribe((response: any) => {
      
      // @ts-ignore
      JSON.parse(response).forEach(lostAndFound => {

      this.animalService.read(lostAndFound.animalId).subscribe((response: any) => {
        let animal = JSON.parse(response)

        animal.dob = this.getDOB(new Date(animal.dateOfBirth))

        this.animals.push(animal)
        
        this.photoService.allAnimalPhotos(animal.animalId).subscribe((response: any) => {
          const allPhotos = JSON.parse(response)
    
          animal.photoURL = "\\assets\\images\\"+allPhotos[0].photoURL
          // @ts-ignore
            let photoURL : string
            photoURL ="\\assets\\images\\"+allPhotos[0]
    
          console.log(allPhotos[0].photoURL)

        });
      });

      });
      
    });
    console.log(this.animals)
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
