package es.indra.model.entities;

public abstract class Cuenta {
	Double saldo;
	Integer ping;
	Integer codigo;
	String dnicliente;
	boolean bloqueo = false;

	public Cuenta() {
		super();
	}

	public Cuenta(String dnicliente, Double salgo, Integer codigo, int ping) {
		super();
		this.dnicliente = dnicliente;
		this.codigo = codigo;
		this.saldo = salgo;
		this.ping = ping;
	}

	public String getDniCliente() {
		return dnicliente;
	}

	public void setDniCliente(String dnicliente) {
		this.dnicliente = dnicliente;
	}

	public Integer getPing() {
		return ping;
	}

	public void setPing(Integer ping) {
		this.ping = ping;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Cuenta [cliente=" + dnicliente + ", salgo=" + saldo + "]";
	}

	public void ingresarDinero(Double ingreso) {
		this.saldo = this.saldo + ingreso;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getDnicliente() {
		return dnicliente;
	}

	public void setDnicliente(String dnicliente) {
		this.dnicliente = dnicliente;
	}

	public boolean isBloqueo() {
		return bloqueo;
	}

	public void setBloqueo(boolean bloqueo) {
		this.bloqueo = bloqueo;
	}

	public abstract boolean sacarDinero(double dinero);

	public abstract void revisiondecuenta();

	public double consultarsaldo() {
		return this.saldo;
	}
}
