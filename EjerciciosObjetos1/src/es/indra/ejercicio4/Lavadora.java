package es.indra.ejercicio4;

public class Lavadora extends Electrodomestico {
	static final Float CARGA_DEFECTO = new Float(5);
	protected Float carga;

	public Lavadora() {
		super();
		carga = CARGA_DEFECTO;
	}

	public Lavadora(Float preciobase, Color color, char clasificacion, Float peso, Float carga) {
		super(preciobase, color, clasificacion, peso);
		this.carga = carga;
	}

	public Lavadora(Float preciobase, Float peso) {
		super(preciobase, peso);
		carga = CARGA_DEFECTO;
	}

	public Float getCarga() {
		return carga;
	}

	public void setCarga(Float carga) {
		this.carga = carga;
	}

	@Override
	public Float precioFinal() {
		Float preciofinal = super.precioFinal();
		if (this.carga > 30) {
			preciofinal += 50;
		}
		return preciofinal;
	}

}
