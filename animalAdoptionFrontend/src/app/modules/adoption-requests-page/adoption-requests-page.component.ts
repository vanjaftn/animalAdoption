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
  public adoptionRequestsApprovedByAdmin: Array<User> = new Array()
  public selectedAnimalProfileId = localStorage.getItem('selectedAnimalProfileId')
  public userIsAdmin = localStorage.getItem('userIsAdmin')
  public userIsVet = localStorage.getItem('userIsVet')

  constructor(private userService : UserService, private adoptionService: AdoptionService) { }

  ngOnInit(): void {
    this.readAllAnimalPendingAdopters()
    this.readAllAnimalAdminApprovedAdopters()
  }

  readAllAnimalPendingAdopters() {
    this.userService.readAllAnimalPendingAdopters(this.selectedAnimalProfileId!).subscribe((response: any) => {
      console.log(JSON.parse(response))

      this.adoptionRequests = JSON.parse(response)
    });
  }

  readAllAnimalAdminApprovedAdopters() {
    this.userService.readAllAnimalAdminApprovedAdopters(this.selectedAnimalProfileId!).subscribe((response: any) => {
      console.log(JSON.parse(response))

      this.adoptionRequestsApprovedByAdmin = JSON.parse(response)
      console.log(this.adoptionRequestsApprovedByAdmin)

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

      window.location.href = '/adopted-animals'
  
      });
    });
  }

  vetApprove(userId: string) {
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
      this.adoptionService.vetApprove(adoption.adoptionId).subscribe((response: any) => {
        console.log(JSON.parse(response))
        
        window.location.href = '/adopted-animals'
  
      });
    });
  }

}
