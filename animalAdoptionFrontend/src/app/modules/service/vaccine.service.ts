import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vaccine } from '../model/vaccine.model';

@Injectable({
  providedIn: 'root'
})
export class VaccineService {

  private apiServerUrl = 'http://localhost:9000';
  private token = localStorage.getItem('token')
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'});
  headers2: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.token}`});
  headers3: HttpHeaders = new HttpHeaders({'Authorization': `Bearer ${this.token}`});

  constructor(private http: HttpClient) { }
  
  create(vaccine: Vaccine): Observable<any> {
    return this.http.post(this.apiServerUrl + '/vaccine', vaccine, {headers: this.headers2, responseType: 'text'});
  }

  readAllAnimalVaccines(animalId: string): Observable<any> {
    return this.http.post(this.apiServerUrl + '/readAllAnimalVaccines', JSON.stringify(animalId), {headers: this.headers2, responseType: 'text'});
  }

}