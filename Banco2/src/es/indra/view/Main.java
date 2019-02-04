package es.indra.view;

import java.util.Scanner;

import es.indra.controller.Banco;
import es.indra.model.entities.Cliente;
import es.indra.model.entities.CuentaCC;
import es.indra.model.entities.CuentaCV;
import es.indra.model.entities.CuentaFI;

public class Main {

	private static Scanner teclado = new Scanner(System.in);
	static Banco banco = new Banco();

	public static void main(String[] args) {
		programamain();
	}

	public static void nuevocliente() {
		Character tipo = ' ';
		System.out.print("Introducir nombre del cliente:");
		String nombre = teclado.nextLine();
		System.out.print("Introducir apellidos del cliente:");
		String apellidos = teclado.nextLine();
		System.out.print("Introducir el DNI del cliente:");
		String dni = teclado.nextLine();
		System.out.print("Introducir la direccion del cliente:");
		String direccion = teclado.nextLine();
		System.out.print("Introducir el telefono del cliente:");
		String tlf = teclado.nextLine();

		Cliente cliente = new Cliente(nombre, dni, apellidos, direccion, tlf);
		if (banco.aniadirCliente(cliente)) {
			System.out.println("Cliente aniadido.");
		}

	}

	public static void nuevacuenta() {
		Character tipo = ' ';
		Double saldo;
		do {
			System.out.print("Introducir saldo de la cuenta:");
			saldo = teclado.nextDouble();
		} while (saldo <= 0);
		System.out.print("Introducir codigo de la cuenta:");
		Integer codigo = teclado.nextInt();
		System.out.print("Introducir el DNI del cliente:");
		String dni = teclado.next();
		Integer ping;
		do {
			System.out.print("Introducir el ping secreto:");
			ping = teclado.nextInt();

		} while (((int) Math.log10(ping) + 1) != 4);
		do {
			System.out.println("¿Que tipo de cuenta desea?");
			System.out.println("Elija C para cuenta corriente, V para Vivienda o I para inversion.");
			tipo = teclado.next().charAt(0);
		} while (!(tipo == 'C') && !(tipo == 'V') && !(tipo == 'I'));

		if (tipo == 'C') {
			CuentaCC cuenta = new CuentaCC(dni, saldo, codigo, ping);
			if (banco.aniadirCuenta(cuenta)) {
				System.out.println("Cuenta aniadido.");
			}
		} else if (tipo == 'V') {
			CuentaCV cuenta = new CuentaCV(dni, saldo, codigo, ping);
			if (banco.aniadirCuenta(cuenta)) {
				System.out.println("Cuenta aniadido.");
			}
		} else {
			CuentaFI cuenta = new CuentaFI(dni, saldo, codigo, ping);
			if (banco.aniadirCuenta(cuenta)) {
				System.out.println("Cuenta aniadido.");
			}
		}

	}

	public static void ingresobancario() {
		System.out.print("Introducir codigo de la cuenta:");
		Integer codigo = teclado.nextInt();
		Double ingreso;
		do {
			System.out.print("Introducir ingreso que desea realizar: ");
			ingreso = teclado.nextDouble();
		} while (ingreso <= 0);
		if (banco.ingresar(ingreso, codigo)) {
			System.out.println("Ingreso Realizado.");
		}

	}

	public static void consultadesaldo() {
		System.out.print("Introducir codigo de la cuenta:");
		Integer codigo = teclado.nextInt();
		System.out.print("Introducir ping de la cuenta:");
		Integer ping = teclado.nextInt();
		banco.consultasaldo(codigo, ping);
	}

	public static void consultarcuenta() {
		System.out.print("Introducir codigo de la cuenta:");
		Integer codigo = teclado.nextInt();
		System.out.print("Introducir ping de la cuenta:");
		Integer ping = teclado.nextInt();
		banco.consultacuenta(codigo, ping);
	}

	public static void revisionmensual() {
		System.out.print("Introducir codigo de la cuenta:");
		Integer codigo = teclado.nextInt();
		banco.revisioninteres(codigo);
	}

	public static void consultaestado() {
		System.out.print("Introducir codigo de la cuenta:");
		Integer codigo = teclado.nextInt();
		System.out.print("Introducir ping de la cuenta:");
		Integer ping = teclado.nextInt();
		banco.consultacuenta(codigo, ping);
	}

	public static void retirardinero() {
		System.out.print("Introducir codigo de la cuenta:");
		Integer codigo = teclado.nextInt();
		System.out.print("Introducir ping de la cuenta:");
		Integer ping = teclado.nextInt();
		System.out.print("Introducir dinero que desea retirar:");
		Double dinerito = teclado.nextDouble();
		banco.retiradadinero(codigo, ping, dinerito);
	}

	public static void programamain() {
		System.out.println("BIENVENIDO AL BANCO");
		teclado.nextLine();
		int eleccion = 0;
		do {
			System.out.println("");
			System.out.println("Pulse 1 para nuevo cliente.");
			System.out.println("Pulse 2 para crear una cuenta.");
			System.out.println("Pulse 3 para ingresar dinero en una cuenta.");
			System.out.println("Pulse 4 para la revision mensual.");
			System.out.println("Pulse 5 para ver el estado de su cuenta.");
			System.out.println("Pulse 6 consulta de saldo.");
			System.out.println("Pulse 0 para finalizar.");
			eleccion = teclado.nextInt();
			teclado.nextLine();
			switch (eleccion) {
			case 1:
				nuevocliente();
				break;
			case 2:
				nuevacuenta();
				break;
			case 3:
				ingresobancario();
				break;
			case 4:
				revisionmensual();
				break;
			case 5:
				consultaestado();
				break;
			case 6:
				consultadesaldo();
				break;
			case 7:
				retirardinero();
				break;
			default:
				break;
			}

		} while (eleccion != 0);
		System.out.println("Adiós, cerrando programa.");
	}

}
