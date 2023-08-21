import { Component } from '@angular/core';
import { User } from '../model/user.model';
import { UserService } from '../service/user.service';
import { AdoptionService } from '../service/adoption.service';
import { ApproveAdoptionDTO } from '../model/approveAdoptionDTO.model';
import { Vaccine } from '../model/vaccine.model';
import { VaccineService } from '../service/vaccine.service';

@Component({
  selector: 'app-animal-vaccines',
  templateUrl: './animal-vaccines.component.html',
  styleUrls: ['./animal-vaccines.component.css']
})
export class AnimalVaccinesComponent {
  public animalVaccines: Array<Vaccine> = new Array()
  public selectedAnimalProfileId = localStorage.getItem('selectedAnimalProfileId')
  public userIsVet = localStorage.getItem('userIsVet')

  constructor(private vaccineService: VaccineService) { }

  ngOnInit(): void {
    this.readAllAnimalPendingAdopters()
  }

  readAllAnimalPendingAdopters() {
    this.vaccineService.readAllAnimalVaccines(this.selectedAnimalProfileId!).subscribe((response: any) => {
      console.log(JSON.parse(response))

      this.animalVaccines = JSON.parse(response)
    });
  }

  createVaccinePage(){
    window.location.href = `create-vaccine-page`;  
  }

}
