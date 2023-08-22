import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Video } from '../model/video.model';

@Injectable({
  providedIn: 'root'
})
export class VideoService {

  private apiServerUrl = 'http://localhost:9000';
  private token = localStorage.getItem('token')
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'});
  headers2: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.token}`});
  headers3: HttpHeaders = new HttpHeaders({'Authorization': `Bearer ${this.token}`});

  constructor(private http: HttpClient) { }


  adopterAddVideos(video: Video): Observable<any> {
    return this.http.post(this.apiServerUrl + '/adopterAddVideos', video, {headers: this.headers2, responseType: 'text'});
  }

  create(video: Video): Observable<any> {
    return this.http.post(this.apiServerUrl + '/video', video, {headers: this.headers3, responseType: 'text'});
  }

  delete(videoId: string): Observable<any> {
    return this.http.post(this.apiServerUrl + '/deleteVideo/' + videoId, null, {headers: this.headers3, responseType: 'text'});
  }

  allAnimalVideos(animalId: string): Observable<any> {
    return this.http.post(this.apiServerUrl + '/allAnimalVideos', JSON.stringify(animalId), {headers: this.headers2, responseType: 'text'});
  }
}