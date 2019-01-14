/**
 * 
 */
package es.indra.ejercicio7;

import java.util.Scanner;

/**
 * @author Antonio Jesus
 *
 */
public class Ejercicio7main {

	private static Scanner teclado;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Introducir el término cuadrático de la ecuación: ");
		double a = teclado.nextInt();
		System.out.println("Introducir el término lineal de la ecuación: ");
		double b = teclado.nextInt();
		System.out.println("Introducir el término independiente de la ecuación: ");
		double c = teclado.nextInt();
		Raices ecuacion = new Raices(a, b, c);
		ecuacion.calcular();

	}

}
