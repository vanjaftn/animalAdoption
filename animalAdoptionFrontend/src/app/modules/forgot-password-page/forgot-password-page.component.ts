import { Component } from '@angular/core';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-forgot-password-page',
  templateUrl: './forgot-password-page.component.html',
  styleUrls: ['./forgot-password-page.component.css']
})
export class ForgotPasswordPageComponent {

  public email: string = ""

  constructor(private userService: UserService) { }
  
  forgotPassword(){
    if(this.email == ""){
      alert("Put in your email");
    }
    else{
      this.userService.forgotPassword(this.email).subscribe((response: any) => {
        alert('Successfully changed');
        window.location.href = '/login-user'
      },(error) => {
        alert("Invalid change");
        console.log(error);
      });
    }
  }
}
