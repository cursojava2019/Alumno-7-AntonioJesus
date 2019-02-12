import { Component, OnInit } from '@angular/core';
import { Task } from '../model/task';
@Component({
  selector: 'app-gestortareas',
  templateUrl: './gestortareas.component.html',
  styleUrls: ['./gestortareas.component.css']
})
export class GestortareasComponent implements OnInit {
 listado: Array<Task>;
 tareaentrada: string;
  constructor() {
      this.listado = new Array<Task>();
   }

  ngOnInit() {
  }
  crearTarea() {
    if ( this.tareaentrada !== '') {
      const tarea = new Task(false, this.tareaentrada);
      this.listado.push(tarea);
    }
  }

}
