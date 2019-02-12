export class Task {
hecho: boolean;
nombre: string;

constructor(hecho: boolean, nombre: string) {
  this.hecho = hecho;
  this.nombre = nombre;
}

finalizar() {
  this.hecho = true;
}

}
