package es.indra.ejercicio5;

public class Videojuego implements Entegable {
	protected String titulo;
	protected Integer horas;
	protected Boolean entregado;
	protected String genero;
	protected String compania;

	public Videojuego() {
		this.horas = 10;
		this.entregado = false;
		this.titulo = "";
		this.genero = "";
		this.compania = "";

	}

	public Videojuego(String titulo, int horas) {
		this.horas = horas;
		this.entregado = false;
		this.titulo = titulo;
		this.genero = "";
		this.compania = "";

	}

	public Videojuego(String titulo, int horas, String genero, String compania) {
		this.horas = horas;
		this.entregado = false;
		this.titulo = titulo;
		this.genero = genero;
		this.compania = compania;

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	@Override
	public String toString() {
		return "Videojuego [titulo=" + titulo + ", horas=" + horas + ", entregado=" + entregado + ", genero=" + genero
				+ ", compania=" + compania + "]";
	}

	public void entregar() {
		this.entregado = true;
	};

	public void devolver() {
		this.entregado = false;
	};

	public boolean isEntregado() {

		return this.entregado;
	};

	public Integer compareTo(Object a) {
		int num = 0;
		if (a instanceof Videojuego) {
			Videojuego aux = (Videojuego) a;
			Integer numtem = aux.getHoras();
			if (this.horas == numtem) {
				num = 0;
			} else if (this.horas < numtem) {
				num = 1;
			} else {
				num = -1;
			}

		} else {
			System.out.println("No es una serie.");
			num = -2;
		}

		return num;
	};
}
