import { Component } from '@angular/core';
import { LoginUser } from '../model/login-user.model';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent {
  public loginUser : LoginUser = new LoginUser();
  public token : string = "";
  public role : string = "";
  public loggedUserId : string = "";

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('token'));

  }

  login(){
    this.userService.login(this.loginUser).subscribe((response: any) => {
      this.token = response;
      localStorage.setItem('token',this.token);
      console.log(this.token)

      let decodedJWT = JSON.parse(window.atob(this.token.split('.')[1]));

      alert('Successfully logged in');

      // this.loggedUserId = decodedJWT.id.authority;
      // localStorage.setItem('loggedUserId', this.loggedUserId);
      console.log(decodedJWT);

      window.location.href = '/unadopted-animals'
    },
    (error) => {
      alert("Invalid email/password");
      console.log(error);
    }
   );
  }
}
