package es.indra.model.entities;

public class CuentaCV extends Cuenta {

	public CuentaCV() {
		super();
	}

	public CuentaCV(String dnicliente, Double salgo, Integer codigo, Integer ping) {
		super(dnicliente, salgo, codigo, ping);
	}

	public void revisiondecuenta() {
		this.saldo = this.saldo * 1.002;
	}

	public boolean sacarDinero(double dinero) {

		return false;
	}

	@Override
	public String toString() {
		return "CuentaCV [cliente=" + dnicliente + ", salgo=" + saldo + "]";
	}

}
