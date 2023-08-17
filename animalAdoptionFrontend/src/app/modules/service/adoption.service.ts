import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Adoption } from '../model/adoption.model';
import { ApproveAdoptionDTO } from '../model/approveAdoptionDTO.model';

@Injectable({
  providedIn: 'root'
})
export class AdoptionService {

  private apiServerUrl = 'http://localhost:9000';
  private token = localStorage.getItem('token')
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'});
  headers2: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.token}`});
  headers3: HttpHeaders = new HttpHeaders({'Authorization': `Bearer ${this.token}`});

  constructor(private http: HttpClient) { }
  
  create(adoption: Adoption): Observable<any> {
    return this.http.post(this.apiServerUrl + '/adoption', adoption, {headers: this.headers2, responseType: 'text'});
  }

  adminApprove(adoptionId: string): Observable<any> {
    return this.http.post(this.apiServerUrl + '/adminApprove', JSON.stringify(adoptionId), {headers: this.headers2, responseType: 'text'});
  }

  readByUserAndAnimalId(approveAdoptionDTO: ApproveAdoptionDTO): Observable<any> {
    return this.http.post(this.apiServerUrl + '/readByUserAndAnimalId', approveAdoptionDTO, {headers: this.headers2, responseType: 'text'});
  }

  animalAdopted(animalId: string): Observable<any> {
    return this.http.post(this.apiServerUrl + '/animalAdopted', JSON.stringify(animalId), {headers: this.headers2, responseType: 'text'});
  }
}