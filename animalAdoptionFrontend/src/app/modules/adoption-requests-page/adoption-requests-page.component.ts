import { Component } from '@angular/core';
import { User } from '../model/user.model';
import { UserService } from '../service/user.service';
import { AdoptionService } from '../service/adoption.service';
import { ApproveAdoptionDTO } from '../model/approveAdoptionDTO.model';

@Component({
  selector: 'app-adoption-requests-page',
  templateUrl: './adoption-requests-page.component.html',
  styleUrls: ['./adoption-requests-page.component.css']
})
export class AdoptionRequestsPageComponent {

  public adoptionRequests: Array<User> = new Array()
  public selectedAnimalProfileId = localStorage.getItem('selectedAnimalProfileId')

  constructor(private userService : UserService, private adoptionService: AdoptionService) { }

  ngOnInit(): void {
    this.readAllAnimalPendingAdopters()
  }

  readAllAnimalPendingAdopters() {
    this.userService.readAllAnimalPendingAdopters(this.selectedAnimalProfileId!).subscribe((response: any) => {
      console.log(JSON.parse(response))

      this.adoptionRequests = JSON.parse(response)
    });
  }

  adminApprove(userId: string) {
    // this.adoptionService.adminApprove(this.selectedAnimalProfileId!).subscribe((response: any) => {
    //   console.log(JSON.parse(response))

    //   this.adoptionRequests = JSON.parse(response)
    // });
    let approveAdoptionDTO = new ApproveAdoptionDTO
    approveAdoptionDTO.animalId = this.selectedAnimalProfileId!
    approveAdoptionDTO.userId = userId

    this.adoptionService.readByUserAndAnimalId(approveAdoptionDTO).subscribe((response: any) => {
      console.log(JSON.parse(response))

      let adoption = JSON.parse(response)
      this.adoptionService.adminApprove(adoption.adoptionId).subscribe((response: any) => {
        console.log(JSON.parse(response))
  
      });
    });
  }

}
