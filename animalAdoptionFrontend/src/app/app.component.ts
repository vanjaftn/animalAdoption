import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'animalAdoptionFrontend';

  loggedUserJwt = localStorage.getItem('token');

  constructor(private router: Router) {
  }

  logout() {
    localStorage.removeItem('token');
    window.location.href = '/login'

    location.reload()
  }
}
