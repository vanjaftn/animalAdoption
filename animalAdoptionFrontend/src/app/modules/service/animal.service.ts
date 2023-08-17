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

  read(id : string) : Observable<any> {
    console.log((this.apiServerUrl + '/animal/' + id , {headers: this.headers2, responseType: 'text'}))
    return this.http.get(this.apiServerUrl + '/animal/' + id , {headers: this.headers2, responseType: 'text'});
  }

  delete(id : string) : Observable<any> {
    return this.http.post(this.apiServerUrl + '/deleteAnimal/' + id , {headers: this.headers2, responseType: 'text'});
  }

}