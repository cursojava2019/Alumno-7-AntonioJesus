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

		System.out.println("Introducir el t�rmino cuadr�tico de la ecuaci�n: ");
		double a = teclado.nextInt();
		System.out.println("Introducir el t�rmino lineal de la ecuaci�n: ");
		double b = teclado.nextInt();
		System.out.println("Introducir el t�rmino independiente de la ecuaci�n: ");
		double c = teclado.nextInt();
		Raices ecuacion = new Raices(a, b, c);
		ecuacion.calcular();

	}

}
