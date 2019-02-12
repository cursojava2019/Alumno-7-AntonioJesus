export class Empleado {
  nombre: string;
  edad: number;
  sueldos: Array<number>;
  constructor(nombre: string, edad: number, sueldos: Array<number>) {
      this.nombre = nombre;
      this.edad = edad;
      this.sueldos = sueldos;
  }
}
