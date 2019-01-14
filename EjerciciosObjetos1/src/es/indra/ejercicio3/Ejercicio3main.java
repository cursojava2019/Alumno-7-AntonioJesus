/**
 * 
 */
package es.indra.ejercicio3;

import java.util.Scanner;

/**
 * @author Antonio Jesus
 *
 */
public class Ejercicio3main {

	private static Scanner teclado;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Indique el n�mero de contrase�as que quiere generar: ");
		int numero = teclado.nextInt();
		System.out.println("Indique la longitud de las contrasenias que quiere generar: ");
		int longi = teclado.nextInt();
		Password[] contra = new Password[numero];
		boolean[] fuerte = new boolean[numero];
		for (int i = 0; i < numero; i++) {
			contra[i] = new Password(longi);
			fuerte[i] = contra[i].esFuerte();
		}
		for (int i = 0; i < numero; i++) {
			if (fuerte[i] == true) {
				System.out.println("La contrase�a es fuerte y es " + contra[i].getContrase�a());
			} else {
				System.out.println("La contrase�a NO es fuerte y es " + contra[i].getContrase�a());
			}
		}
	}

}
