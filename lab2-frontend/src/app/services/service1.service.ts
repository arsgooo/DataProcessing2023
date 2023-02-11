import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Car } from '../interfaces/car';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Service1Service {
  url: string = 'http://localhost:8080/lab2/cars';

  constructor(private http: HttpClient) {}

  //asking data from backend part
  getEntities(): Observable<Car[]> {
    return this.http.get<Car[]>(this.url);
  }

  doPut(img: Object, name: Object, price: Object): void {
    this.http
      .put(
        this.url + '?img=' + img + '&name=' + name + '&price=' + price,
        price
      )
      .subscribe((data) => {
        console.log(data);
      });
  }
}
