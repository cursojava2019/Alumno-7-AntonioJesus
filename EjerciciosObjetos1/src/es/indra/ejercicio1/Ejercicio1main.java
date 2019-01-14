/**
 * 
 */
package es.indra.ejercicio1;

import java.util.Scanner;

/**
 * @author Antonio Jesús
 *
 */
public class Ejercicio1main {

	private static Scanner entrada;
	private static Cuenta cuenta;

	/**
	 * @param args
	 */
	public static void inicializar() {
		entrada = new Scanner(System.in);
		cuenta = null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		inicializar();
		int opcion = 0;
		do {
			System.out.println("Introduccir la operación que desea relizar:");
			System.out.println("1.Inicilizar Cuenta.");
			System.out.println("2.Añadir saldo.");
			System.out.println("3.Retirar saldo.");
			System.out.println("0.Finalizar transaccion");
			opcion = entrada.nextInt();
			entrada.nextLine();
			switch (opcion) {
			case 1:
				inicializarcuenta();
				break;
			case 2:
				aniadirSaldo();
				break;
			case 3:
				retirar();
				break;
			case 0:
				System.out.println("Fin del programa");
			default:
				break;
			}

		} while (opcion != 0);

	}

	private static void aniadirSaldo() {
		// TODO Auto-generated method stub
		if (cuenta != null) {
			System.out.println("Introduzca la cantidad que desea aniadir y pulse intro:");
			Double saldo = entrada.nextDouble();
			entrada.nextLine();
			cuenta.ingresar(saldo);
		}
	}

	private static void retirar() {
		// TODO Auto-generated method stub
		if (cuenta != null) {
			System.out.println("Introduzca la cantidad que desea retirar y pulse intro:");
			Double retirar = entrada.nextDouble();
			entrada.nextLine();
			cuenta.ingresar(retirar);
		}
	}

	private static void inicializarcuenta() {
		// TODO Auto-generated method stub
		System.out.println("Introduzca el nombre del titular y pulse intro:");
		String titular = entrada.nextLine();
		System.out.println("Introducir saldo y pulse intro:");
		Double saldo = entrada.nextDouble();
		entrada.nextLine();
		cuenta = new Cuenta(titular, saldo);
		System.out.println("El resultado de la operacion es " + cuenta.toString());
	}

}
