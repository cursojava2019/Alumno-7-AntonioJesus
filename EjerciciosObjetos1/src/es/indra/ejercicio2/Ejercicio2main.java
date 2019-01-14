/**
 * 
 */
package es.indra.ejercicio2;

import java.util.Scanner;

/**
 * @author Antonio Jesus
 *
 */
public class Ejercicio2main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduccir el nombre: ");
		String nombre = entrada.next();
		System.out.println("Introducir la edad: ");
		int edad = entrada.nextInt();
		System.out.println("Introducir el peso:");
		double peso = entrada.nextDouble();
		System.out.println("Introducir la altura: ");
		double altura = entrada.nextDouble();
		System.out.println("Introducir el sexo: ");
		char sexo = entrada.next().charAt(0);
		Persona persona1 = new Persona(nombre, edad, peso, altura, sexo);
		Persona persona2 = new Persona(nombre, edad, sexo);
		Persona persona3 = new Persona();

		persona3.setPeso(68.0);
		persona3.setAltura(1.63);

		int aux = 0;
		aux = persona1.calcularIMC();
		if (aux == 1) {
			System.out.println("La persona 1 sufre obesidad.");
		} else {
			if (aux == 0) {
				System.out.println("La persona 1 dispone de un peso ideal.");
			} else {
				System.out.println("La persona 1 esta demasiado delgada");
			}
		}

		aux = persona2.calcularIMC();
		if (aux == 1) {
			System.out.println("La persona 2 sufre obesidad.");
		} else {
			if (aux == 0) {
				System.out.println("La persona 2 dispone de un peso ideal.");
			} else {
				System.out.println("La persona 2 esta demasiado delgada");
			}
		}

		aux = persona3.calcularIMC();
		if (aux == 1) {
			System.out.println("La persona 3 sufre obesidad.");
		} else {
			if (aux == 0) {
				System.out.println("La persona 3 dispone de un peso ideal.");
			} else {
				System.out.println("La persona 3 esta demasiado delgada");
			}
		}

		boolean esMayor = true;
		esMayor = persona1.esMayorDeEdad();
		if (esMayor == true) {
			System.out.println("La persona 1 es mayor de edad.");
		} else {
			System.out.println("La persona 1 no es mayor de edad.");
		}

		esMayor = persona2.esMayorDeEdad();
		if (esMayor == true) {
			System.out.println("La persona 2 es mayor de edad.");
		} else {
			System.out.println("La persona 2 no es mayor de edad.");
		}

		esMayor = persona3.esMayorDeEdad();
		if (esMayor == true) {
			System.out.println("La persona 3 es mayor de edad.");
		} else {
			System.out.println("La persona 3 no es mayor de edad.");
		}

		System.out.println("La persona 1 se llama " + persona1.getNombre() + ".");
		System.out.println("La persona 1 tiene " + persona1.getEdad() + " anios.");
		System.out.println("La persona 1 pesa " + persona1.getPeso() + "Kg.");
		System.out.println("La persona 1 mide " + persona1.getAltura() + "m.");
		if (persona1.getSexo() == 'H') {
			System.out.println("El sexo de la persona 1 es Hombre");
		} else {
			System.out.println("El sexo de la persona 1 es mujer");
		}

		System.out.println("La persona 2 se llama " + persona2.getNombre() + ".");
		System.out.println("La persona 2 tiene " + persona2.getEdad() + " anios.");
		System.out.println("La persona 2 pesa " + persona2.getPeso() + "Kg.");
		System.out.println("La persona 2 mide " + persona2.getAltura() + "m.");
		System.out.println("El sexo de la persona 2 es Hombre");

		System.out.println("La persona 3 se llama " + persona3.getNombre() + ".");
		System.out.println("La persona 3 tiene " + persona3.getEdad() + " anios.");
		System.out.println("La persona 3 pesa " + persona3.getPeso() + "Kg.");
		System.out.println("La persona 3 mide " + persona3.getAltura() + "m.");
		System.out.println("El sexo de la persona 3 es Hombre");
	}

}
