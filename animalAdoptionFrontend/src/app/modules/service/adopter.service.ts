import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user.model';
import { AnimalWithPhotosDTO } from '../model/animal-with-photos-DTO.model';

@Injectable({
  providedIn: 'root'
})
export class AdopterService {

  private apiServerUrl = 'http://localhost:9000';
  private token = localStorage.getItem('token')
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'});
  headers2: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.token}`});
  headers3: HttpHeaders = new HttpHeaders({'Authorization': `Bearer ${this.token}`});

  constructor(private http: HttpClient) { }

  adopterExist(): Observable<any> {
    return this.http.get(this.apiServerUrl + '/adopterExist', {headers: this.headers2, responseType: 'text'});
  }

}