/**
 * 
 */
package es.indra.ejercicio6;

/**
 * @author cursojava
 *
 */
public class Ejercicio6main {

	public static void main(String[] args) {
		Libro[] libros = new Libro[2];

		libros[0] = new Libro("986-546-846", "Python para idiotas.", "Jose Carlos ", new Integer(560));
		libros[1] = new Libro("786-568-125", "Java para listos", "Juan Jose ", Integer.valueOf(250));

		if (libros[0].getNump() < libros[1].getNump()) {
			System.out.println("El primer libro tiene más paginas.");
		} else {
			System.out.println("El segundo libro tiene más paginas.");
		}

		System.out.println(libros[0].toString());
		System.out.println(libros[1].toString());

	}

}
