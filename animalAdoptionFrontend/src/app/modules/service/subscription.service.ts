import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NewSubscription } from '../model/newSubscription.model';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService {

  private apiServerUrl = 'http://localhost:9000';
  private token = localStorage.getItem('token')
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'});
  headers2: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.token}`});
  headers3: HttpHeaders = new HttpHeaders({'Authorization': `Bearer ${this.token}`});

  constructor(private http: HttpClient) { }
  
  subscribe(subscribtion : NewSubscription): Observable<any> {
    return this.http.post(this.apiServerUrl + '/subscription', subscribtion, {headers: this.headers2, responseType: 'text'});
  }

}