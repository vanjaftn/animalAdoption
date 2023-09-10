import { Component } from '@angular/core';
import { User } from '../model/user.model';
import { UserService } from '../service/user.service';
import { AdoptionService } from '../service/adoption.service';
import { AdoptionDTO } from '../model/adoption-DTO.model';
import { UserWithDobDTO } from '../model/user-with-dob-DTO.model';

@Component({
  selector: 'app-adoption-requests-page',
  templateUrl: './adoption-requests-page.component.html',
  styleUrls: ['./adoption-requests-page.component.css']
})
export class AdoptionRequestsPageComponent {

  public adoptionRequests: Array<UserWithDobDTO> = new Array()
  public adoptionRequestsApprovedByAdmin: Array<UserWithDobDTO> = new Array()
  public selectedAnimalProfileId = localStorage.getItem('selectedAnimalProfileId')
  public userIsAdmin = localStorage.getItem('userIsAdmin')
  public userIsVet = localStorage.getItem('userIsVet')
  public dob: string = ""

  constructor(private userService : UserService, private adoptionService: AdoptionService) { }

  ngOnInit(): void {
    this.readAllAnimalPendingAdopters()
    this.readAllAnimalAdminApprovedAdopters()
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
    this.userService.readAllAnimalPendingAdopters(this.selectedAnimalProfileId!).subscribe((response: any) => {
      console.log(JSON.parse(response))
      let res: Array<User> = JSON.parse(response)

      res.forEach(request => {
        let newUser: UserWithDobDTO = new UserWithDobDTO

        newUser.userId = request.userId
        newUser.email = request.email
        newUser.firstName = request.firstName
        newUser.lastName = request.lastName
        newUser.password = request.password
        newUser.personalId = request.personalId
        newUser.phoneNumber = request.phoneNumber
        newUser.dob = this.getDate(new Date(request.dateOfBirth))

        this.adoptionRequests.push(newUser)
      });
      
    });
  }

  readAllAnimalAdminApprovedAdopters() {
    this.userService.readAllAnimalAdminApprovedAdopters(this.selectedAnimalProfileId!).subscribe((response: any) => {
      console.log(JSON.parse(response))

      let res: Array<User> = JSON.parse(response)

      res.forEach(request => {
        let newUser: UserWithDobDTO = new UserWithDobDTO

        newUser.userId = request.userId
        newUser.email = request.email
        newUser.firstName = request.firstName
        newUser.lastName = request.lastName
        newUser.password = request.password
        newUser.personalId = request.personalId
        newUser.phoneNumber = request.phoneNumber
        newUser.dob = this.getDate(new Date(request.dateOfBirth))

        this.adoptionRequestsApprovedByAdmin.push(newUser)
      });

    });
  }

  adminApprove(userId: string) {
    if(confirm("Are you sure you want to delete this animal?")) {
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
  }

  vetApprove(userId: string) {
    if(confirm("Are you sure you want to delete this animal?")) {
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
  }

  adminReject(userId: string) {
    if(confirm("Are you sure you want to delete this animal?")) {
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

  }

  vetReject(userId: string) {
    if(confirm("Are you sure you want to delete this animal?")) {
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

}
