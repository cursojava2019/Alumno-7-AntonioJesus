/**Ejercicio 4.Crea un programa básico  que pidapor teclado un número entero positivo (debemos controlarlo) y muestra  el número de cifras que tiene. Por ejemplo: si introducimos 1250, nos muestre que tiene 4 cifras. Tendremos que controlar sitiene una o más cifras, al mostrar el mensaje.
 * 
 */
package es.indra.curso.Ejercicio4;

import java.util.Scanner;

/**
 * @author Antonio Jesús
 *
 */
public class Ejercicio4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada=new Scanner(System.in);
		System.out.print("Introduzca un número: "); 
		double num=0;
		boolean aux=false;
		while(aux==false) {
			 num=entrada.nextInt();
			if(num>0) {
				aux=true;
			}else {
				System.out.print("Introduzca un número positivo: ");	
			}
		}
		 double salida= Math.floor(Math.log10(num))+1;
		System.out.print("La el número tiene "+salida+" digitos.");
	}
	
}

