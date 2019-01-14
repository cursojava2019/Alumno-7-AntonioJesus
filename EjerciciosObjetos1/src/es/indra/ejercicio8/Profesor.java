package es.indra.ejercicio8;

public class Profesor extends Persona {
	String asignatura;

	public Profesor(String nombre, Integer Edad, Character sexo, String asignatura) {
		super(nombre, Edad, sexo);
		this.asignatura = asignatura;
		this.ausencia = estadist();
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	@Override
	public boolean estadist() {
		double aux = Math.random();
		boolean ausencia = true;
		if (aux < 0.5) {
			ausencia = false;
		}
		return ausencia;
	}

}
