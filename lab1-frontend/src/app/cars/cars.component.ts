import { Component } from '@angular/core';
import { Entity } from '../interfaces/entity';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.scss'],
})
export class CarsComponent {
  title = 'lab1-frontend';
  entityList: Entity[] = [];

  constructor(private service: Service1Service) {}

  getEntities(): void {
    this.service.getEntities().subscribe((entities) => {
      this.entityList = entities;
    });
  }
}
