import { Component } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../model/user.model';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent {

  public loggedInUser: User = new User
  public loggedUserJwt = localStorage.getItem('token');
  public dob: string = ""
  
  constructor(private userService: UserService) { }

  ngOnInit(): void {

    this.read()
  }

  public getDate(date : Date) {
    let day = date.getDate();
    let month = date.getMonth() + 1;
    let year = date.getFullYear();
    this.dob = day + '.' + month + '.' + year + '.'
  }

  read(){
    this.userService.readLoggedInUser().subscribe((response: any) => {
      console.log(JSON.parse(response))

      this.loggedInUser = JSON.parse(response)
      this.getDate(new Date(this.loggedInUser.dateOfBirth))

    }
   );
  }

  update() {
    window.location.href = '/update-user-page'
  }
}
