package es.indra.model;

import es.indra.model.entities.Cuenta;
import es.indra.model.entities.CuentaFI;
import es.indra.model.support.Dao;
import es.indra.model.support.Service;

public class CuentaService extends Service<Integer, Cuenta> {

	private CuentaDao dao = null;

	protected Dao<Integer, Cuenta> getDao() {
		if (this.dao == null) {
			this.dao = new CuentaDao();
		}
		return this.dao;
	}

	public void ingresardinero(Double ingreso, Integer codigo) {
		Cuenta c = find(codigo);
		Double dinero = ingreso + c.getSaldo();
		c.setSaldo(dinero);
		update(c);
		if ((c instanceof CuentaFI) && (c.getSaldo() > -500)) {
			desbloqueo(codigo);
		}
	}

	public void consultarsaldo(Integer codigo, Integer ping) {
		Cuenta c = find(codigo);
		if (ping == c.getPing()) {
			System.out.println("Su saldo es: " + c.getSaldo());
		} else {
			System.out.println("El ping introducido es erroneo.");
		}
	}

	public void revisarcuenta(Integer codigo) {
		Cuenta c = find(codigo);
		c.revisiondecuenta();
		System.out.println("Su saldo actual es: " + c.getSaldo());
		if ((c instanceof CuentaFI) && (c.getSaldo() > -500)) {
			desbloqueo(codigo);
		}
	}

	public void retiradadedinero(Integer codigo, Integer ping, Double dinerito) {
		Cuenta c = find(codigo);
		if (c.sacarDinero(dinerito)) {
			System.out.println("Recoja su dinero " + dinerito);
		} else {
			System.out.println("No se ha podido retirar el dinero.");
		}
		if ((c instanceof CuentaFI) && (c.getSaldo() - dinerito < -500)) {
			bloqueo(codigo);
		}
	}

	public void estadocuenta(Integer codigo, Integer ping) {
		Cuenta c = find(codigo);
		if (ping == c.getPing()) {
			if (!c.isBloqueo()) {
				System.out.println("Su cuenta esta bloqueada.");
			} else {
				System.out.println("Su cuenta esta activada.");
			}

		} else {
			System.out.println("El ping introducido es erroneo.");
		}

	}
}
