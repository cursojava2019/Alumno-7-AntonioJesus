package es.indra.ejercicio4;

public class Electrodomestico {
	static String COLOR_BASE = "BLANCO";
	static final Float PRECIO_DEFECTO = Float.valueOf(100);
	static final Float PESO_DEFECTO = Float.valueOf(5);
	static Character CLASIFICACION = 'F';

	protected Float preciobase;
	protected String color;
	protected Character clasificacion;
	protected Float peso;

	public Electrodomestico() {
		super();
		this.preciobase = PRECIO_DEFECTO;
		this.color = COLOR_BASE;
		this.clasificacion = CLASIFICACION;
		this.peso = PESO_DEFECTO;
	}

	public Electrodomestico(Float preciobase, String color, char clasificacion, Float peso) {
		this.preciobase = preciobase;
		this.color = color;
		this.comprobarConsumoEnergetico(clasificacion);
		this.peso = peso;
	}

	public Electrodomestico(Float preciobase, Float peso) {
		this(); /**
				 * el this anterior sirve para referenciar llamada y asignar al resto de
				 * variables lo que en el anterior constructor
				 */
		this.preciobase = preciobase;
		this.peso = peso;
	}

	public Float getPreciobase() {
		return preciobase;
	}

	public void setPreciobase(Float preciobase) {
		this.preciobase = preciobase;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Character getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Character clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	private void comprobarConsumoEnergetico(char clasificacion) {
		if (clasificacion == 'A' || clasificacion == 'B' || clasificacion == 'C' || clasificacion == 'D'
				|| clasificacion == 'E' || clasificacion == 'F') {
			this.clasificacion = clasificacion;
		} else {
			this.clasificacion = CLASIFICACION;
		}
	}

	private void comprobarcolor(String color) {
		if (color.equals("ROJO") || color.equals("AZUL") || color.equals("GRIS") || color.equals("NEGRO")
				|| color.equals("BLANCO")) {
			this.color = color;
		} else {
			this.color = COLOR_BASE;
		}
	}

	public Float precioFinal() {
		Float preciofinal = Float.valueOf(0);
		switch (this.clasificacion) {
		case 'A':
			preciofinal += 100;
			break;
		case 'B':
			preciofinal += 80;
			break;
		case 'C':
			preciofinal += 50;
			break;
		case 'D':
			preciofinal += 30;
			break;
		case 'E':
			preciofinal += 20;
			break;
		case 'F':
			preciofinal += 20;
			break;

		}
		if (peso <= 19) {
			preciofinal += 10;
		} else {
			if (peso < 49) {
				preciofinal += 50;
			} else {
				if (peso < 79) {
					preciofinal += 80;
				} else {
					preciofinal += 100;
				}
			}
		}
		return preciofinal;
	}

}
