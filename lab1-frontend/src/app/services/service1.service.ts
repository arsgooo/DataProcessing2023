import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Entity } from '../interfaces/entity';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Service1Service {
  url: string = 'http://localhost:8080/lab1/Servlet';

  constructor(private http: HttpClient) {}

  //asking data from backend part
  getEntities(): Observable<Entity[]> {
    return this.http.get<Entity[]>(this.url);
  }
}
