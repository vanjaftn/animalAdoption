import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { LoginUser } from '../model/login-user.model';
import { Observable } from 'rxjs';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiServerUrl = 'http://localhost:9000';
  private token = localStorage.getItem('token')
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'});
  headers2: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.token}`});
  headers3: HttpHeaders = new HttpHeaders({'Authorization': `Bearer ${this.token}`});

  constructor(private http: HttpClient) { }
  
  login(loginUser: LoginUser): Observable<any> {
    console.log(loginUser);
    return this.http.post(this.apiServerUrl + '/login', loginUser, {headers: this.headers, responseType: 'text'});
  }

  register(user: User): Observable<any> {
    console.log(user);
    return this.http.post(this.apiServerUrl + '/user', user, {headers: this.headers, responseType: 'text'});
  }
}