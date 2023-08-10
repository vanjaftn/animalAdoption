import { Component } from '@angular/core';

@Component({
  selector: 'app-unadopted-animals-page',
  templateUrl: './unadopted-animals-page.component.html',
  styleUrls: ['./unadopted-animals-page.component.css']
})
export class UnadoptedAnimalsPageComponent {

  ngOnInit(): void {
    console.log(localStorage.getItem('token'))
  }
}
