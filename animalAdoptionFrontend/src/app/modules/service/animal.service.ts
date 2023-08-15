import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnimalService {

  private apiServerUrl = 'http://localhost:9000';
  private token = localStorage.getItem('token')
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'});
  headers2: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.token}`});
  headers3: HttpHeaders = new HttpHeaders({'Authorization': `Bearer ${this.token}`});

  constructor(private http: HttpClient) { }
  
  allAnimals(): Observable<any> {
    return this.http.get(this.apiServerUrl + '/allAnimals', {headers: this.headers, responseType: 'text'});
  }

  allAdoptedAnimals(): Observable<any> {
    return this.http.get(this.apiServerUrl + '/allAdoptedAnimals', {headers: this.headers, responseType: 'text'});
  }

  allSubscribedAnimals(): Observable<any> {
    return this.http.get(this.apiServerUrl + '/allUsersSubscribedAnimals', {headers: this.headers2, responseType: 'text'});
  }

}