import { Component } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../model/user.model';
import { AdminService } from '../service/admin.service';
import { CreateVet } from '../model/create-vet.model';

@Component({
  selector: 'app-register-vet',
  templateUrl: './register-vet.component.html',
  styleUrls: ['./register-vet.component.css']
})
export class RegisterVetComponent {
  public vet : CreateVet = new CreateVet();

  constructor(private userService: UserService, private adminService: AdminService) { }

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
