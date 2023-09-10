import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Animal } from '../model/animal.model';
import { CreateVet } from '../model/create-vet.model';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class VetService {

  private apiServerUrl = 'http://localhost:9000';
  private token = localStorage.getItem('token')
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'});
  headers2: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.token}`});
  headers3: HttpHeaders = new HttpHeaders({'Authorization': `Bearer ${this.token}`});

  constructor(private http: HttpClient) { }

  vetExists(): Observable<any> {
    return this.http.get(this.apiServerUrl + '/vetExists', {headers: this.headers2, responseType: 'text'});
  }

  read(id: string): Observable<any> {
    return this.http.get(this.apiServerUrl + '/vet/' + id, {headers: this.headers2, responseType: 'text'});
  }

  animalIsSterilized(animal: Animal): Observable<any> {
    return this.http.post(this.apiServerUrl + '/animalIsSterilized', animal,{headers: this.headers2, responseType: 'text'});
  }

}