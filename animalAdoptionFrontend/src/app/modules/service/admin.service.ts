import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Animal } from '../model/animal.model';

@Injectable({
  providedIn: 'root'
})
export class AdminlService {

  private apiServerUrl = 'http://localhost:9000';
  private token = localStorage.getItem('token')
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'});
  headers2: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.token}`});
  headers3: HttpHeaders = new HttpHeaders({'Authorization': `Bearer ${this.token}`});

  constructor(private http: HttpClient) { }
  
  registerAnimal(animal : Animal): Observable<any> {
    return this.http.post(this.apiServerUrl + '/animal', animal, {headers: this.headers2, responseType: 'text'});
  }

  adminExists(): Observable<any> {
    return this.http.get(this.apiServerUrl + '/adminExists', {headers: this.headers2, responseType: 'text'});
  }

}