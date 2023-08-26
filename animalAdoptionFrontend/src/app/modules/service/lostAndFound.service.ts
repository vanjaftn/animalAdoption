import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Animal } from '../model/animal.model';
import { CreateVet } from '../model/create-vet.model';
import { User } from '../model/user.model';
import { AnimalWithPhotosDTO } from '../model/animal-with-photos-DTO.model';
import { LostAndFoundPageComponent } from '../lost-and-found-page/lost-and-found-page.component';
import { LostAndFound } from '../model/lost-and-found.model';

@Injectable({
  providedIn: 'root'
})
export class LostAndFoundService {

  private apiServerUrl = 'http://localhost:9000';
  private token = localStorage.getItem('token')
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'});
  headers2: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.token}`});
  headers3: HttpHeaders = new HttpHeaders({'Authorization': `Bearer ${this.token}`});

  constructor(private http: HttpClient) { }
  
  registerLost(animal : AnimalWithPhotosDTO): Observable<any> {
    return this.http.post(this.apiServerUrl + '/lost', animal, {headers: this.headers2, responseType: 'text'});
  }

  registerFound(animal : AnimalWithPhotosDTO): Observable<any> {
    return this.http.post(this.apiServerUrl + '/found', animal, {headers: this.headers2, responseType: 'text'});
  }

  readAllLostAndFound(): Observable<any> {
    return this.http.get(this.apiServerUrl + '/allLostAndFound', {headers: this.headers2, responseType: 'text'});
  }

  readAllNotApproved(): Observable<any> {
    return this.http.get(this.apiServerUrl + '/allLostAndFoundNotApproved', {headers: this.headers2, responseType: 'text'});
  }

  readAllApproved(): Observable<any> {
    return this.http.get(this.apiServerUrl + '/allLostAndFoundApproved', {headers: this.headers2, responseType: 'text'});
  }

  lostAndFoundExists(id : string): Observable<any> {
    return this.http.post(this.apiServerUrl + '/lostAndFoundExists', JSON.stringify(id), {headers: this.headers2, responseType: 'text'});
  }

  adminApproveLAF(lostAndFound : LostAndFound): Observable<any> {
    return this.http.post(this.apiServerUrl + '/adminApproveLAF', lostAndFound, {headers: this.headers2, responseType: 'text'});
  }

  readByAnimalId(animalId : string): Observable<any> {
    return this.http.get(this.apiServerUrl + '/lostAndFoundByAnimalId/' + animalId, {headers: this.headers2, responseType: 'text'});
  }
}