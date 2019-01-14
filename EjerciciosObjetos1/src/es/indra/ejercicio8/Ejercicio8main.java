/**
 * 
 */
package es.indra.ejercicio8;

import java.util.Scanner;

/**
 * @author Antonio Jesus
 *
 */
public class Ejercicio8main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		// Vamos lo primero a construir al profesor.
		Integer edad = 0;
		String nombre = "";
		Character sexo = 'N';
		String asignatura = "", asignatura2 = "";
		Double nota = Double.valueOf(0);
		int alums = 0;
		int maxalum = 0;
		Alumno[] alumnos;
		Aula clase;

		System.out.println("Introducir nombre del profesor: ");
		nombre = teclado.nextLine();

		do {
			System.out.println("Introducir edad del profesor: ");
			edad = teclado.nextInt();
			teclado.nextLine();

		} while (edad < 21 || edad > 65);

		do {
			System.out.println("Introducir asignatura que imparte el profesor: ");
			asignatura = teclado.nextLine();

		} while (!asignatura.equals("filosofia") && !asignatura.equals("fisica") && !asignatura.equals("matematicas"));

		do {
			System.out.println("Introducir sexo del profesor: ");
			sexo = teclado.next().charAt(0);

		} while (sexo != 'H' && sexo != 'M');

		Profesor profesor = new Profesor(nombre, edad, sexo, asignatura);

		do {
			System.out.println("Introducir la capacidad del aula: ");
			maxalum = teclado.nextInt();
			teclado.nextLine();
		} while (maxalum <= 0);

		do {
			System.out.println("Introducir asignatura del aula: ");
			asignatura2 = teclado.next();

		} while (!asignatura2.equals("filosofia") && !asignatura2.equals("fisica")
				&& !asignatura2.equals("matematicas"));

		do {
			System.out.println("Introducir numero de alumnos de la clase: ");
			alums = teclado.nextInt();
			teclado.nextLine();
		} while (alums <= 0 && alums <= maxalum);

		alumnos = new Alumno[alums];

		for (int i = 0; i < alums; i++) {
			System.out.println("Introducir nombre del alumno: ");
			nombre = teclado.next();

			do {
				System.out.println("Introducir edad del alumno: ");
				edad = teclado.nextInt();
				teclado.nextLine();

			} while (edad > 21 || edad <= 0);

			do {
				System.out.println("Introducir nota del alumno: ");
				nota = teclado.nextDouble();
				teclado.nextLine();

			} while (nota < 0 || nota > 10);

			do {
				System.out.println("Introducir sexo del alumno: ");
				sexo = teclado.next().charAt(0);

			} while (sexo != 'H' && sexo != 'M');
			alumnos[i] = new Alumno(nombre, edad, sexo, nota);
		}

		clase = new Aula(true, maxalum, asignatura2, profesor, alums, alumnos);

		if (clase.darclase()) {
			System.out.println("Se han impartido las clases.");
			System.out.println("Hubo " + clase.chicasaprobadas() + " chicas aprobadas");
			System.out.println("Hubo " + clase.chicosaprobados() + " chicos aprobados");
		} else {
			System.out.println("No se han impartido las clases.");
		}

	}

}
