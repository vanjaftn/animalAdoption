import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PhotoService {

  private apiServerUrl = 'http://localhost:9000';
  private token = localStorage.getItem('token')
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'});
  headers2: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.token}`});
  headers3: HttpHeaders = new HttpHeaders({'Authorization': `Bearer ${this.token}`});

  constructor(private http: HttpClient) { }
  
  uploadPhoto(file: FormData): Observable<any> {
    return this.http.post(this.apiServerUrl + '/uploadPhoto', file, {headers: this.headers3, responseType: 'text'});
  }

  allAnimalPhotos(animalId: string): Observable<any> {
    return this.http.post(this.apiServerUrl + '/readAllAnimalPhotos', JSON.stringify(animalId), {headers: this.headers2, responseType: 'text'});
  }
}