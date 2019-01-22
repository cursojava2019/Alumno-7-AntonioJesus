package es.indra.controller;

import java.io.Serializable;

import es.indra.model.ClienteService;
import es.indra.model.CuentaService;
import es.indra.model.entities.Cliente;
import es.indra.model.entities.Cuenta;

public class Banco implements Serializable {

	ClienteService clienteService = new ClienteService();
	CuentaService cuentaservice;

	public Banco() {
		this.clienteService = new ClienteService();
		this.cuentaservice = new CuentaService();
	}

	public boolean aniadirCliente(Cliente c) {
		this.clienteService.create(c);
		return true;
	}

	public boolean aniadirCuenta(Cuenta cuenta) {
		this.cuentaservice.create(cuenta);
		return true;
	}

	public boolean ingresar(Double ingreso, Integer codigo) {
		this.cuentaservice.ingresardinero(ingreso, codigo);
		return true;
	}

	public void consultasaldo(Integer codigo, Integer ping) {
		this.cuentaservice.consultarsaldo(codigo, ping);
	}

	public void consultacuenta(Integer codigo, Integer ping) {
		this.cuentaservice.estadocuenta(codigo, ping);
	}

	public void revisioninteres(Integer codigo) {
		this.cuentaservice.revisarcuenta(codigo);
	}

	public void retiradadinero(Integer codigo, Integer ping, Double dinerito) {
		this.cuentaservice.retiradadedinero(codigo, ping, dinerito);
	}
}
