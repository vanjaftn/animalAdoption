import { Component } from '@angular/core';
import { UserService } from '../service/user.service';
import { AdminService } from '../service/admin.service';
import { CreateVet } from '../model/create-vet.model';
import { Vaccine } from '../model/vaccine.model';
import { VaccineService } from '../service/vaccine.service';

@Component({
  selector: 'app-create-vaccine',
  templateUrl: './create-vaccine.component.html',
  styleUrls: ['./create-vaccine.component.css']
})
export class CreateVaccineComponent {
  public vaccine : Vaccine = new Vaccine();
  public selectedAnimalProfileId = localStorage.getItem('selectedAnimalProfileId')

  constructor(private vaccineService: VaccineService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('token'));

  }

  public getDate(): string {
    let date = new Date();
    let day = date.getDate();
    let month = date.getMonth() + 1;
    let year = date.getFullYear();
    return `${year}-${month < 9 ? ('0'+month) : month}-${day < 9 ? ('0'+day) : day}`;
  }

  register(){

    if(this.isInputValid()){
      this.vaccine.animalId = this.selectedAnimalProfileId!
      this.vaccineService.create(this.vaccine).subscribe((response: any) => {
        console.log(response)
  
        alert('Successfully created');
  
      const animalId = this.selectedAnimalProfileId
      const adoptionRequsestURL = `animal-vaccines-page/${animalId}`;
      window.location.href = adoptionRequsestURL;  
  
      },
      (error) => {
        alert("Failed");
        console.log(error);
      });
    }
  }

  public isInputValid(): boolean {

    if (this.vaccine.vaccineDate == null || this.vaccine.vaccineType.trim() == '') {
        alert('Please fill in all fields!');
        return false;
     }

     return true;
  }
}
