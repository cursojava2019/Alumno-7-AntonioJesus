package es.indra.model.entities;

public class CuentaCC extends Cuenta {

	public CuentaCC() {
		super();
	}

	public CuentaCC(String dnicliente, Double salgo, Integer codigo, Integer ping) {
		super(dnicliente, salgo, codigo, ping);
	}

	public void revisiondecuenta() {
		this.saldo = this.saldo * 1.001 - 0.6;
	}

	public boolean sacarDinero(double dinero) {
		boolean aux = false;
		if (dinero >= this.saldo) {
			this.saldo = this.saldo - dinero;
			aux = true;
		}
		return aux;
	}

	@Override
	public String toString() {
		return "CuentaCV [cliente=" + dnicliente + ", salgo=" + saldo + "]";
	}
}
