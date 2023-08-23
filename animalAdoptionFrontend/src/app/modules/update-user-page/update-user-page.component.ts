import { Component } from '@angular/core';
import { User } from '../model/user.model';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-update-user-page',
  templateUrl: './update-user-page.component.html',
  styleUrls: ['./update-user-page.component.css']
})
export class UpdateUserPageComponent {
  public userProfile: User = new User
  public dob : String = ""

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('token'));
    this.read()
  }

  public getDate(date : Date) {
    let day = date.getDate();
    let month = date.getMonth() + 1;
    let year = date.getFullYear();
    this.dob = day + '.' + month + '.' + year + '.'
    console.log(this.dob)
  }

  read(){
    this.userService.readLoggedInUser().subscribe((response: any) => {
      console.log(JSON.parse(response))
      this.userProfile = JSON.parse(response)

      this.getDate(new Date(this.userProfile.dateOfBirth))

    }
   );
  }

  update(){

  console.log(this.userProfile)
  
  this.userService.update(this.userProfile).subscribe((response: any) => {
    console.log(response)

    alert('Successfully updated');

    // const animalId = this.selectedAnimalProfileId
    // const animalURL = `animal-profile/${animalId}`;
    // window.location.href = animalURL;  

  },(error) => {
    alert("Invalid update");
    console.log(error);
  }
 );

  }

}
