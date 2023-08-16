import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './modules/model/user.model';
import { UserService } from './modules/service/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'animalAdoptionFrontend';

  public loggedInUser : User = new User
  loggedUserJwt = localStorage.getItem('token');

  constructor(private router: Router, private userService: UserService) {
  }

  ngOnInit(): void {

    this.read()
  }
  
  logout() {
    localStorage.removeItem('token');
    window.location.href = '/login'

    location.reload()
  }

  read(){
    this.userService.readLoggedInUser().subscribe((response: any) => {
      console.log(JSON.parse(response))

      this.loggedInUser = JSON.parse(response)
    }
   );
  }
}
