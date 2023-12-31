import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './modules/model/user.model';
import { UserService } from './modules/service/user.service';
import { AdminService } from './modules/service/admin.service';
import { VetService } from './modules/service/vet.service';
import { AdopterService } from './modules/service/adopter.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'animalAdoptionFrontend';

  public loggedInUser : User = new User
  public loggedUserJwt = localStorage.getItem('token');
  public userIsAdmin : string = "";
  public userIsVet : string = "";
  public userIsAdopter : string = "";


  constructor(private router: Router, private userService: UserService,
     private adminService : AdminService, private vetService: VetService, private adopterService: AdopterService) {
  }

  ngOnInit(): void {

    this.adminExist()
    this.vetExist()
    this.adopterExist()
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

  adminExist(){
    this.adminService.adminExists().subscribe((response: any) => {
      localStorage.setItem('userIsAdmin', JSON.parse(response));
      this.userIsAdmin = localStorage.getItem('userIsAdmin')!
    }
   );
  }

  vetExist(){
    this.vetService.vetExists().subscribe((response: any) => {
      localStorage.setItem('userIsVet', JSON.parse(response));
      this.userIsVet = localStorage.getItem('userIsVet')!
    }
   );
  }

  adopterExist(){
    this.adopterService.adopterExist().subscribe((response: any) => {
      localStorage.setItem('userIsAdopter', JSON.parse(response));
      this.userIsAdopter = localStorage.getItem('userIsAdopter')!
    }
   );
  }
}
