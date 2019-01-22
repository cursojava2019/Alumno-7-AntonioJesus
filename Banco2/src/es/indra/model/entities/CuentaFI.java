package es.indra.model.entities;

public class CuentaFI extends Cuenta {

	public CuentaFI(String dnicliente, Double salgo, Integer codigo, Integer ping) {
		super(dnicliente, salgo, codigo, ping);
	}

	public void revisiondecuenta() {
		this.saldo = this.saldo * 1.0034 - 0.6;
	}

	public boolean sacarDinero(double dinero) {
		boolean aux = false;
		if ((this.saldo - dinero) >= -500) {
			this.saldo = (this.saldo - dinero);
			aux = true;
		}
		return aux;
	}

	@Override
	public String toString() {
		return "CuentaFI [cliente=" + dnicliente + ", salgo=" + saldo + "]";
	}
}
