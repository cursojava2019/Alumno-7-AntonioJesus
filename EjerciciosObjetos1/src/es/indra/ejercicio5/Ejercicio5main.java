/**
 * 
 */
package es.indra.ejercicio5;

/**
 * @author cursojava
 *
 */
public class Ejercicio5main {

	public static void main(String[] args) {

		Videojuego[] juegos = new Videojuego[5];
		Serie[] series = new Serie[5];

		juegos[0] = new Videojuego("juan1", 8, "perico", "Pixar");
		juegos[1] = new Videojuego("juan2", 5, "perico", "Pixar");
		juegos[2] = new Videojuego("juan3", 6, "perico", "Pixar");
		juegos[3] = new Videojuego("juan4", 9, "perico", "Pixar");
		juegos[4] = new Videojuego("juan5", 17, "perico", "Pixar");

		series[0] = new Serie("pepe1", 9, "joselito", "comedia");
		series[1] = new Serie("pepe2", 5, "joselito", "comedia");
		series[2] = new Serie("pepe3", 6, "joselito", "comedia");
		series[3] = new Serie("pepe4", 2, "joselito", "comedia");
		series[4] = new Serie("pepe5", 3, "joselito", "comedia");

		juegos[0].entregar();
		juegos[3].entregar();

		series[1].entregar();
		series[3].entregar();
		series[4].entregar();

		int cont = 0;
		for (int i = 0; i < 5; i++) {
			if (series[i].isEntregado()) {
				cont++;
			}
		}
		System.out.println("Hay " + cont + " series entregadas.");

		cont = 0;
		for (int i = 0; i < 5; i++) {
			if (juegos[i].isEntregado()) {
				cont++;
			}
		}
		System.out.println("Hay " + cont + " videojuegos entregados.");

		Videojuego aux2 = juegos[0];

		for (int i = 0; i < 5; i++) {
			if (aux2.compareTo(juegos[i]) == 1) {
				aux2 = juegos[i];
			}
		}
		System.out.println("El videojuego con más horas de juego es: ");
		System.out.println(aux2.toString());

		Serie aux3 = series[0];
		for (int i = 0; i < 5; i++) {
			if (aux3.compareTo(series[i]) == 1) {
				aux3 = series[i];
			}
		}
		System.out.println("La serie con más temporadas es: ");
		System.out.println(aux3.toString());

	}
}
