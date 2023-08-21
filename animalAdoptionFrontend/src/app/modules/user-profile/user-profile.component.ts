import { Component } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../model/user.model';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent {

  public loggedInUser : User = new User
  public loggedUserJwt = localStorage.getItem('token');
  
  constructor(private userService: UserService) { }

  ngOnInit(): void {

    this.read()
  }

  read(){
    this.userService.readLoggedInUser().subscribe((response: any) => {
      console.log(JSON.parse(response))

      this.loggedInUser = JSON.parse(response)
    }
   );
  }

  update() {
    window.location.href = '/update-user-page'
  }
}
