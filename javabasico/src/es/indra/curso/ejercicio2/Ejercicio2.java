/**Ejercicio 2.  Crea un programa b�sico en javaque sea capaz de leer dos numeros por consola y sea capaz de imprimir todos los n�meros que se encuentran entre ambos.
 * 
 */
package es.indra.curso.ejercicio2;

import java.util.Scanner;

/**
 * @author Antonio Jes�s
 *
 */
public class Ejercicio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduzca el primer n�mero: ");  
		int num1=entrada.nextInt();
		System.out.println("Introduzca el segundo n�mero: ");  
		int num2=entrada.nextInt();
		if(num2==num1) {
			System.out.println(" No hay nada que mostrar los n�meros son iguales.");
			
		}else {
		for(int i=num1;i<num2;i++) {
			System.out.println(i);
		}
		}
		}
	}

