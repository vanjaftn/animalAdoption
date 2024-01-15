import { Component } from '@angular/core';
import { User } from '../model/user.model';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-change-password-page',
  templateUrl: './change-password-page.component.html',
  styleUrls: ['./change-password-page.component.css']
})
export class ChangePasswordPageComponent {
  public userProfile: User = new User
  public newPassword: string = ""
  public newPasswordRepeat: string = ""
  public oldPassword: string = ""

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('token'));
    this.read()
  }


  read(){
    this.userService.readLoggedInUser().subscribe((response: any) => {
      console.log(JSON.parse(response))
      this.userProfile = JSON.parse(response)

    }
   );
  }

  update(){

    if(this.isInputValid()){

      this.userService.passwordExists(this.oldPassword).subscribe((response: any) => {
        console.log(response)
    
        this.userProfile.password = this.newPassword
          this.userService.update(this.userProfile).subscribe((response: any) => {
            console.log(response)
        
            alert('Successfully changed');        
          },(error) => {
            alert("Invalid change");
            console.log(error);
          });
      },(error) => {
        alert("Wrong old password");
        console.log(error);
      }
    );
    }
  }
  
  public isInputValid(): boolean {

    console.log(this.oldPassword)
    console.log(this.newPassword)

    if (this.oldPassword.trim() == '' || this.newPassword.trim() == '' || this.newPasswordRepeat.trim() == '') {
        alert('Please fill in all fields!');
        return false;
     }
     if(this.newPassword.trim() != this.newPasswordRepeat.trim()) {
        alert('Confirm your new password');
        return false;
     }

     return true;
  }
}
