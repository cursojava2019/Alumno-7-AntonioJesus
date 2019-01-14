package es.indra.ejercicio8;

public class Alumno extends Persona {
	Double Nota;

	public Alumno(String nombre, Integer Edad, Character sexo, Double nota) {
		super(nombre, Edad, sexo);
		this.Nota = nota;
		this.ausencia = estadist();
	}

	public Double getNota() {
		return Nota;
	}

	public void setNota(Double nota) {
		Nota = nota;
	}

	@Override
	public boolean estadist() {
		double aux = Math.random();
		boolean ausencia = false;
		if (aux < 0.2) {
			ausencia = true;
		}
		return ausencia;
	}

}
