import { Component } from '@angular/core';
import { UserService } from '../service/user.service';
import { AdminService } from '../service/admin.service';
import { CreateVet } from '../model/create-vet.model';

@Component({
  selector: 'app-register-vet',
  templateUrl: './register-vet.component.html',
  styleUrls: ['./register-vet.component.css']
})
export class RegisterVetComponent {
  public vet : CreateVet = new CreateVet();

  constructor(private adminService: AdminService) { }

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

      this.vet.phoneNumber = Number(this.vet.phoneNumber)
      this.vet.personalId = Number(this.vet.personalId)

      this.adminService.registerVet(this.vet).subscribe((response: any) => {
        console.log(response)
  
        alert('Successfully registered');
        // window.location.href = '/register-vet'
  
      },
      (error) => {
        alert("Invalid registration");
        console.log(error);
      });

    }
  }

  
  public isInputValid(): boolean {

    var regexp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;     
    // Converting the email to lowercase
    if(!regexp.test(String(this.vet.email).toLowerCase())) {
      alert('email format is not valid')
      return false;
    }

    if (this.vet.firstName.trim() == '' || this.vet.lastName.trim() == '' || this.vet.email.trim() == ''
    || this.vet.password.trim() == '' || this.vet.dateOfBirth == null) {
        alert('Please fill in all fields!');
        return false;
     }

     return true;
  }
}
