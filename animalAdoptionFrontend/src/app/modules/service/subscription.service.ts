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

  unsubscribe(id: string): Observable<any> {
    return this.http.post(this.apiServerUrl + '/deleteSubscription/' + id , null, {headers: this.headers2, responseType: 'text'});
  }

  readByAnimalId(id: string): Observable<any> {
    return this.http.post(this.apiServerUrl + '/subscriptionByAnimalId', JSON.stringify(id) , {headers: this.headers2, responseType: 'text'});
  }

  read(id : string) : Observable<any> {
    return this.http.get(this.apiServerUrl + '/subscription/' + id , {headers: this.headers2, responseType: 'text'});
  }

  subscriptionExists(animalId : string):  Observable<any> {
    console.log(animalId)
    return this.http.post(this.apiServerUrl + '/subscriptionExists', JSON.stringify(animalId), {headers: this.headers2, responseType: 'text'});
  }

}