import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-micomponente',
  templateUrl: './micomponente.component.html',
  styleUrls: ['./micomponente.component.css']
})
export class MicomponenteComponent implements OnInit {
  nombre = 'Paco';
  nombreEntrada = '';
  constructor() { }

  ngOnInit() {
  }

  cambiarNombre(nuevonombre: string) {
    this.nombre = nuevonombre;
  }

 cambiarnombreentrada(nuevonombre: string) {
   this.nombre = nuevonombre;
 }
}
