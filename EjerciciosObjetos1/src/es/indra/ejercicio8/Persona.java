package es.indra.ejercicio8;

public abstract class Persona {
	String Nombre;
	Integer Edad;
	Character Sexo;
	boolean ausencia = true;

	public Persona(String nombre, Integer Edad, Character sexo) {
		super();
		this.Nombre = nombre;
		this.Edad = Edad;
		this.Sexo = sexo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Integer getEdad() {
		return Edad;
	}

	public void setEdad(Integer edad) {
		Edad = edad;
	}

	public Character getSexo() {
		return Sexo;
	}

	public void setSexo(Character sexo) {
		Sexo = sexo;
	}

	public boolean isAusencia() {
		return ausencia;
	}

	public void setAusencia(boolean ausencia) {
		this.ausencia = ausencia;
	}

	public abstract boolean estadist();

}
