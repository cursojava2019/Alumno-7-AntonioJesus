import { Component, OnInit } from '@angular/core';
import { Empleado } from './model/empleado';
@Component({
  selector: 'app-ejercicio2',
  templateUrl: './ejercicio2.component.html',
  styleUrls: ['./ejercicio2.component.css']
})
export class Ejercicio2Component implements OnInit {
empleado1: Empleado;

sueldo = [100, 103203, 12223];
constructor() {
  this.empleado1 = new Empleado('juan', 19 , this.sueldo);
}


  ngOnInit() {
  }

}
