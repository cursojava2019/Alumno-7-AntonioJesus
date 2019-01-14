package es.indra.ejercicio7;

public class Raices {
	Double a, b, c;

	public Raices(Double a, Double b, Double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Double getDiscriminante() {
		return (Double) (b * b - 4 * a * c);
	}

	public boolean tieneRaices() {
		boolean aux = false;
		if (getDiscriminante() > 0) {
			aux = true;
		}
		return aux;
	}

	public boolean tieneRaiz() {
		boolean aux = false;
		if (getDiscriminante() == 0) {
			aux = true;
		}
		return aux;
	}

	public void obtenerRaices() {
		double aux1 = 0, aux2 = 0;
		aux1 = (-b + Math.sqrt(getDiscriminante())) / (2 * a);
		aux2 = (-b - Math.sqrt(getDiscriminante())) / (2 * a);
		System.out.println("X1: " + aux1);
		System.out.println("X2: " + aux2);
	}

	public void obtenerRaiz() {
		System.out.println("La solución es: " + (-b / 2 * a));
	}

	public void calcular() {
		if (a == 0) {
			System.out.println("La ecuación es de primer grado y la solución es " + (-c / b));
		} else {
			if (tieneRaiz()) {
				obtenerRaiz();
			} else {
				if (tieneRaices()) {
					obtenerRaices();
				} else {
					System.out.println("No tiene solución.");
				}
			}
		}

	}
}
