/**Ejercicio 3.Crea un programa b�sico en java que pida un d�a de la semanaen textoy que nos diga si es un dia laboral o no. Usa un switch para ello.
 * 
 */
package es.indra.curso.ejercicio3;

import java.util.Scanner;

/**
 * @author Antonio Jes�s
 *
 */
public class Ejercicio3 {

	/**
	 * @param args
	 */
	public static int diasemana(String dia) {
		String aux=dia.toLowerCase();
		int num=-1;
		if ("lunes".equals(aux)) {
			num=0;
		}else { if ("martes".equals(aux)) {
					num=1;
		}else { if ("miercoles".equals(aux)) {
						num=2;
		}else { if ("jueves".equals(aux)) {
						num=3;
		}else { if ("viernes".equals(aux)) {
						num=4;
		}else {if ("sabado".equals(aux)) {
						num=5;
		}else {if ("domingo".equals(aux)) {
					num=6;
		}
	}
	}
	}		
	}
	}
	}
		return num;
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada=new Scanner(System.in);
		String dia="";
		
		
		
		System.out.println("Introduzca un d�a: ");  
		dia=entrada.next();
		
		switch (diasemana(dia)) {
        case 0:
        	System.out.println("D�a laborable."); 
        break;
        case 1:
        	System.out.println("D�a laborable."); 
        break;
        case 3:
        	System.out.println("D�a laborable."); 
        break;
        case 4:
        	System.out.println("D�a laborable."); 
        break;
        case 5:
        	System.out.println("D�a NO laborable."); 
        break;
        case 6:
        	System.out.println("D�a NO laborable."); 
        break;
        default:
        	System.out.println("La entrada no es correcta.");
        break;
		}
	}

}
