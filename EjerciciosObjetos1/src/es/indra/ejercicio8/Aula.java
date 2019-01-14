package es.indra.ejercicio8;

public class Aula {
	boolean libre;
	Integer alumMax;
	String asignatura;
	Profesor profesor;
	Integer alums;
	Alumno[] alumnos;

	public Aula(boolean libre, Integer num, String asignatura, Profesor profesor, int alums, Alumno alumn[]) {

		this.libre = libre;
		this.alumMax = num;
		this.asignatura = asignatura;
		this.profesor = profesor;
		this.alums = alums;
		this.alumnos = alumn;

	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Integer getAlums() {
		return alums;
	}

	public void setAlums(Integer alums) {
		this.alums = alums;
	}

	public Alumno[] getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumno alumnos[]) {
		this.alumnos = alumnos;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	public Integer getAlumMax() {
		return alumMax;
	}

	public void setAlumMax(Integer alumMax) {
		this.alumMax = alumMax;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public boolean darclase() {
		boolean posible = false;
		double cont = 0;
		if (this.libre) {
			if (!profesor.isAusencia()) {
				if (this.asignatura.equals(profesor.getAsignatura())) {
					for (int i = 0; i < alums; i++) {
						if (!alumnos[i].isAusencia()) {
							cont++;
						}
					}
				}
			}
		}
		if ((cont / alums) > 0.5) {
			posible = true;
		}
		return posible;
	}

	public int chicosaprobados() {
		int cont = 0;
		for (int i = 0; i < alums; i++) {
			if (alumnos[i].getNota() >= 5 && alumnos[i].getSexo() == 'H') {
				cont++;
			}
		}
		return cont;
	}

	public int chicasaprobadas() {
		int cont = 0;
		for (int i = 0; i < alums; i++) {
			if (alumnos[i].getNota() >= 5 && alumnos[i].getSexo() == 'M') {
				cont++;
			}
		}
		return cont;
	}

}
