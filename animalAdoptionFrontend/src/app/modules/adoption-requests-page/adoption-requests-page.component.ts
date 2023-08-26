import { Component } from '@angular/core';
import { User } from '../model/user.model';
import { UserService } from '../service/user.service';
import { AdoptionService } from '../service/adoption.service';
import { AdoptionDTO } from '../model/adoption-DTO.model';

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
    let approveAdoptionDTO = new AdoptionDTO
    approveAdoptionDTO.animalId = this.selectedAnimalProfileId!
    approveAdoptionDTO.userId = userId

    this.adoptionService.readByUserAndAnimalId(approveAdoptionDTO).subscribe((response: any) => {
      console.log(JSON.parse(response))

      let adoption = JSON.parse(response)
      this.adoptionService.adminApprove(adoption.adoptionId).subscribe((response: any) => {
        console.log(JSON.parse(response))

      alert('Approved!');

        const animalId = this.selectedAnimalProfileId!
        const animalURL = `animal-profile/${animalId}`;
        window.location.href = animalURL;
  
      });
    });
  }

  vetApprove(userId: string) {
    // this.adoptionService.adminApprove(this.selectedAnimalProfileId!).subscribe((response: any) => {
    //   console.log(JSON.parse(response))

    //   this.adoptionRequests = JSON.parse(response)
    // });
    let approveAdoptionDTO = new AdoptionDTO
    approveAdoptionDTO.animalId = this.selectedAnimalProfileId!
    approveAdoptionDTO.userId = userId

    this.adoptionService.readByUserAndAnimalId(approveAdoptionDTO).subscribe((response: any) => {
      console.log(JSON.parse(response))

      let adoption = JSON.parse(response)
      this.adoptionService.vetApprove(adoption.adoptionId).subscribe((response: any) => {
        console.log(JSON.parse(response))

      alert('Confirmed!');

        
        const animalId = this.selectedAnimalProfileId!
        const animalURL = `animal-profile/${animalId}`;
        window.location.href = animalURL;
  
      });
    });
  }

  adminReject(userId: string) {

      let adoptionDTO = new AdoptionDTO
      adoptionDTO.animalId = this.selectedAnimalProfileId!
      adoptionDTO.userId = userId
  
      this.adoptionService.readByUserAndAnimalId(adoptionDTO).subscribe((response: any) => {
        console.log(JSON.parse(response))
        let adoption = JSON.parse(response)
  
        this.adoptionService.deletePending(adoption.adoptionId).subscribe((response: any) => {
          console.log(JSON.parse(response))

        alert('Adopter rejected');

        const animalId = this.selectedAnimalProfileId
        const adoptionRequsestURL = `adoption-request-page/${animalId}`;
        window.location.href = adoptionRequsestURL;  

        });
        
      });

  }

  vetReject(userId: string) {
    let adoptionDTO = new AdoptionDTO
    adoptionDTO.animalId = this.selectedAnimalProfileId!
    adoptionDTO.userId = userId

    this.adoptionService.readByUserAndAnimalId(adoptionDTO).subscribe((response: any) => {
      console.log(JSON.parse(response))
      let adoption = JSON.parse(response)

      this.adoptionService.deleteApproved(adoption.adoptionId).subscribe((response: any) => {
        console.log(JSON.parse(response))

        alert('Adopter rejected');

        const animalId = this.selectedAnimalProfileId
        const adoptionRequsestURL = `adoption-request-page/${animalId}`;
        window.location.href = adoptionRequsestURL;
      });
      
    });
  }

}
