package es.indra.ejercicio3;

public class Password {
	int longitud;
	String contrasenia;

	public Password() {
		super();
		this.longitud = 10;
		contrasenia = "";
		String mayus = "ABCDEFGHIJKLMNÑOPQRSTUVWXZ";
		String minus = "abcdefghijklmnñopqrstuvwxz";
		String num = "1234567890";
		int aux1 = 0, aux2 = 0, aux3 = 0;
		for (int i = 0; i < longitud; i++) {
			aux1 = (int) (Math.random() * 3);
			if (aux1 == 0) {
				aux2 = (int) (Math.random() * 25);
				contrasenia = contrasenia + minus.substring(aux2);
			} else {
				if (aux1 == 1) {
					aux2 = (int) (Math.random() * 25);
					contrasenia = contrasenia + mayus.substring(aux2);
				} else {
					aux3 = (int) (Math.random() * 9);
					contrasenia = contrasenia + num.substring(aux3);
				}

			}

		}
	}

	public Password(int longitud) {
		super();
		this.longitud = longitud;
		contrasenia = "";
		String mayus = "ABCDEFGHIJKLMNÑOPQRSTUVWXZ";
		String minus = "abcdefghijklmnñopqrstuvwxz";
		String num = "1234567890";
		int aux1 = 0, aux2 = 0, aux3 = 0;
		for (int i = 0; i < longitud; i++) {
			aux1 = (int) (Math.random() * 3);
			if (aux1 == 0) {
				aux2 = (int) (Math.random() * 25);
				contrasenia = contrasenia + minus.substring(aux2, aux2 + 1);
			} else {
				if (aux1 == 1) {
					aux2 = (int) (Math.random() * 25);
					contrasenia = contrasenia + mayus.substring(aux2, aux2 + 1);
				} else {
					aux3 = (int) (Math.random() * 9);
					contrasenia = contrasenia + num.substring(aux3, aux3 + 1);
				}

			}

		}
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public String getContraseña() {
		return contrasenia;
	}

	public boolean esFuerte() {
		boolean fuerte = false, encontrado = false;
		int tamanio = contrasenia.length();
		String mayus = "ABCDEFGHIJKLMNÑOPQRSTUVWXZ";
		String minus = "abcdefghijklmnñopqrstuvwxz";
		String num = "1234567890";
		String aux = "";
		int min = 0, may = 0, nume = 0, j = 0;
		for (int i = 0; i < tamanio; i++) {
			aux = contrasenia.substring(i, i + 1);
			while (j < 10 && encontrado == false) {
				if (aux.equals(num.substring(j, j + 1))) {
					nume++;
					encontrado = true;
				}
				j++;
			}
			j = 0;
			while (j < 26 && encontrado == false) {
				if (aux.equals(minus.substring(j, j + 1))) {
					min++;
					encontrado = true;
				}
				j++;
			}
			j = 0;
			while (j < 26 && encontrado == false) {
				if (aux.equals(mayus.substring(j, j + 1))) {
					may++;
					encontrado = true;
				}
				j++;
			}
			j = 0;
			encontrado = false;
		}
		if (min > 1 && may > 2 && nume > 5) {
			fuerte = true;
		}

		return fuerte;
	}

}
