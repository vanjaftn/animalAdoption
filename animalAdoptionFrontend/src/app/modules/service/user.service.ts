import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { LoginUser } from '../model/login-user.model';
import { Observable } from 'rxjs';
import { User } from '../model/user.model';
import { CreateUserDTO } from '../model/create-user-DTO.model';

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

  confirm(user: CreateUserDTO): Observable<any> {
    return this.http.post(this.apiServerUrl + '/confirm', user, {headers: this.headers, responseType: 'text'});
  }

  register(confirmationCode: string): Observable<any> {
    return this.http.get(this.apiServerUrl + '/user/' + confirmationCode, {headers: this.headers, responseType: 'text'});
  }

  readAll(): Observable<any> {
    return this.http.get(this.apiServerUrl + '/allUsers', {headers: this.headers2, responseType: 'text'});
  }

  read(userId: string): Observable<any> {
    return this.http.get(this.apiServerUrl + '/user' + userId, {headers: this.headers2, responseType: 'text'});
  }

  readLoggedInUser(): Observable<any> {
    return this.http.get(this.apiServerUrl + '/loggedInUser', {headers: this.headers2, responseType: 'text'});
  }

  readAllAnimalPendingAdopters(animalId: String): Observable<any> {
    return this.http.post(this.apiServerUrl + '/readAllAnimalPendingAdopters',JSON.stringify(animalId), {headers: this.headers2, responseType: 'text'});
  }

  readAllAnimalAdminApprovedAdopters(animalId: String): Observable<any> {
    return this.http.post(this.apiServerUrl + '/readAllAnimalAdminApprovedAdopters', JSON.stringify(animalId), {headers: this.headers2, responseType: 'text'});
  }

  update(user: User): Observable<any> {
    return this.http.post(this.apiServerUrl + '/updateUser', user, {headers: this.headers2, responseType: 'text'});
  }

  passwordExists(password: String): Observable<any> {
    return this.http.post(this.apiServerUrl + '/passwordExists', JSON.stringify(password), {headers: this.headers2, responseType: 'text'});
  }

  forgotPassword(email: String): Observable<any> {
    return this.http.post(this.apiServerUrl + '/forgotPassword', JSON.stringify(email), {headers: this.headers2, responseType: 'text'});
  }
}