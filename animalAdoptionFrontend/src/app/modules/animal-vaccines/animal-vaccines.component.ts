import { Component } from '@angular/core';
import { Vaccine } from '../model/vaccine.model';
import { VaccineService } from '../service/vaccine.service';
import { VaccineWithDateDTO } from '../model/vaccine-with-date-DTO.model';
import { VetService } from '../service/vet.service';

@Component({
  selector: 'app-animal-vaccines',
  templateUrl: './animal-vaccines.component.html',
  styleUrls: ['./animal-vaccines.component.css']
})
export class AnimalVaccinesComponent {
  public animalVaccines: Array<VaccineWithDateDTO> = new Array()
  public selectedAnimalProfileId = localStorage.getItem('selectedAnimalProfileId')
  public userIsVet = localStorage.getItem('userIsVet')

  constructor(private vaccineService: VaccineService, private vetService: VetService) { }

  ngOnInit(): void {
    this.readAllAnimalPendingAdopters()
  }

  public getDate(date : Date): string{
    let day = date.getDate();
    let month = date.getMonth() + 1;
    let year = date.getFullYear();
    let dob: string = ""
    dob = day + '.' + month + '.' + year + '.'
    return dob
  }

  readAllAnimalPendingAdopters() {
    this.vaccineService.readAllAnimalVaccines(this.selectedAnimalProfileId!).subscribe((response: any) => {
      console.log(JSON.parse(response))
      
      let vaccines: Array<Vaccine> = JSON.parse(response)
      
      vaccines.forEach(vaccine => {
        let newVaccine: VaccineWithDateDTO = new VaccineWithDateDTO
        
        this.vetService.read(vaccine.vetId).subscribe((response: any) => {
          let vetName = JSON.parse(response).firstName + " " +  JSON.parse(response).lastName
          
          newVaccine.vaccineId = vaccine.vaccineId
          newVaccine.vaccineType = vaccine.vaccineType
          newVaccine.animalId = vaccine.animalId
          newVaccine.vaccineDate = vaccine.vaccineDate
          newVaccine.vetId = vaccine.vetId
          newVaccine.vetName = vetName
          newVaccine.date = this.getDate(new Date(vaccine.vaccineDate))
          
          this.animalVaccines.push(newVaccine)
          this.animalVaccines = this.animalVaccines.sort((a, b) => new Date(a.vaccineDate).getTime() - new Date(b.vaccineDate).getTime())
          console.log(this.animalVaccines)
        });
      });
    });
  }

  createVaccinePage(){
    window.location.href = `create-vaccine-page`;  
  }

}
