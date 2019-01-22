package es.indra.model.entities;

public class Cliente {
	String nombre;
	String dni;
	String apellidos;
	String direccion;
	String tln;

	public Cliente() {
		super();

	}

	public Cliente(String nombre, String dni, String apellidos, String direccion, String tln) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.tln = tln;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTln() {
		return tln;
	}

	public void setTln(String tln) {
		this.tln = tln;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", dni=" + dni + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", tln=" + tln + "]";
	}

}
