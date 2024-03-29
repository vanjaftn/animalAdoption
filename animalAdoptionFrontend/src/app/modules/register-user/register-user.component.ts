import { Component } from '@angular/core';
import { UserService } from '../service/user.service';
import { CreateUserDTO } from '../model/create-user-DTO.model';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent {

  public user : CreateUserDTO = new CreateUserDTO();

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('token'));
    console.log(this.user);

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
      this.userService.confirm(this.user).subscribe((response: any) => {
        console.log(response)
  
        alert('You have recieved an email and a text message.');
  
        window.location.href = '/login-user'
      },
      (error) => {
        alert("Invalid registration");
        console.log(error);
      }
     );
    }
  }

  public isInputValid(): boolean {

    var regexp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;     
    // Converting the email to lowercase
    if(!regexp.test(String(this.user.email).toLowerCase())) {
      alert('email format is not valid')
      return false;
    }

    if (this.user.firstName.trim() == '' || this.user.lastName.trim() == '' || this.user.email.trim() == ''
    || this.user.personalId.trim() == '' || this.user.phoneNumber.trim() == '' || this.user.dateOfBirth == null) {
        alert('Please fill in all fields!');
        return false;
     }

     return true;
  }
}