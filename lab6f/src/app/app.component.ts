import { Component } from '@angular/core';
import { Car } from './interfaces/car';
import { Service1Service } from './services/service1.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'lab6f';
  carList: Car[] = [];

  constructor(private service: Service1Service) {}

  getCars(): void {
    this.service.getCars().subscribe((cars) => {
      this.carList = cars;
    });
  }
}
