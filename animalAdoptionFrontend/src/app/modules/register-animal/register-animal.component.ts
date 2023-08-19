import { Component } from '@angular/core';
import { Animal } from '../model/animal.model';
import { AnimalService } from '../service/animal.service';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-register-animal',
  templateUrl: './register-animal.component.html',
  styleUrls: ['./register-animal.component.css']
})
export class RegisterAnimalComponent {
  public animal : Animal = new Animal();

  constructor(private adminService: AdminService) { }

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

    if(this.animal.sterilized == null){
      this.animal.sterilized = false
    }
    this.animal.chipNumber = Number(this.animal.chipNumber)
    this.adminService.registerAnimal(this.animal).subscribe((response: any) => {
      console.log(response)

      alert('Successfully registered');

      window.location.href = '/unadopted-animals'
    },
    (error) => {
      alert("Invalid registration");
      console.log(error);
    }
   );
  }
}
