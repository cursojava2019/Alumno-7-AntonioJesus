/**Ejercicio 1. Crea un programa básico en java que sea capaz de leer 
 * de consola un número y devolver si el número es divisible por 2 o no.
 * 
 */
package es.indra.curso;

import java.util.Scanner;

/**
 * @author Antonio Jesús
 *
 */
public class Ejercicio1 {

	/**
	 * @param num
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduzca un número para ver si es divisible por dos.");  
		int leido=entrada.nextInt();
		if(leido%2==0) {
			System.out.println("El número "+leido+" es divisible de 2.");
		}else {
			System.out.println("El número "+leido+" no es divisible de 2.");
		}
		}
		
	}

