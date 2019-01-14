package es.indra.ejercicio4;

public class Television extends Electrodomestico {

	public static final Integer RESOLUCION_DEFECTO = new Integer(20);
	public static final boolean SINTONIZADOR_DEFECTO = new Boolean(false);

	protected Integer resolucion;
	protected Boolean sintonizador;

	public Television() {
		this.resolucion = RESOLUCION_DEFECTO;
		this.sintonizador = SINTONIZADOR_DEFECTO;
	}

	public Television(Float preciobase, Color color, char clasificacion, Float peso, int resolucion,
			boolean sintonizador) {
		super(preciobase, color, clasificacion, peso);
		this.resolucion = resolucion;
		this.sintonizador = sintonizador;
	}

	public Television(Float preciobase, Float peso, int resolucion, boolean sintonizador) {
		super(preciobase, peso);
		this.resolucion = resolucion;
		this.sintonizador = sintonizador;
	}

	@Override
	public Float precioFinal() {
		Float preciofinal = super.precioFinal();
		if (this.resolucion >= 40) {
			preciofinal = preciofinal * Float.valueOf("1.3");
		}
		if (sintonizador) {
			preciofinal = preciofinal * Float.valueOf("0.5");
		}
		return preciofinal;
	}

}
