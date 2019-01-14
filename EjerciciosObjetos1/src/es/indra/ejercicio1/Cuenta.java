package es.indra.ejercicio1;

/**1) Crea una clase llamada Cuenta que tendra los siguientes atributos: titular y cantidad
 *  (puede tener decimales).El titular será obligatorio y la cantidad es opcional. Crea dos 
 *  constructores que cumpla lo anterior.Crea sus metodos get, set y toString.Tendrá dos 
 *  metodos especiales:ingresar(double cantidad): se ingresa una cantidad a la cuenta, si la 
 *  cantidad introducida es negativa, no se hara nada.oretirar(double cantidad): se retira una 
 *  cantidad a la cuenta, si restando la cantidad actual a la que nos pasan es negativa, la 
 *  cantidad de la cuenta pasa a ser 0.
 */

/** Construimos el objeto como queremos */
public class Cuenta {
	protected String titular;
	protected Double cantidad;

	// Lo siguiente es construir el constructor de objetos.
	public Cuenta(String titular, Double cantidad) {
		super();
		this.titular = titular;
		this.cantidad = cantidad;
	}

	public Cuenta(String titular) {
		super();
		this.titular = titular;
		this.cantidad = Double.valueOf(0);
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "cuenta [titular=" + titular + ", cantidad=" + cantidad + "]";
	}

	public void ingresar(Double cantidadsuma) {
		if (cantidadsuma > 0) {
			this.cantidad = cantidad + cantidadsuma;
		}
	}

	public void retirar(Double retira) {
		this.cantidad -= retira;
		if (cantidad < 0) {
			this.cantidad = Double.valueOf(0);
		}
	}

}
