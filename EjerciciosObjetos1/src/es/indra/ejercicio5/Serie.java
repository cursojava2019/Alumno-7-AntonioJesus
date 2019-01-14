package es.indra.ejercicio5;

public class Serie implements Entegable {

	protected String titulo;
	protected Integer numt;
	protected Boolean entregado;
	protected String genero;
	protected String creador;

	public Serie() {
		super();
		this.titulo = "";
		this.genero = "";
		this.creador = "";
		this.numt = 3;
		this.entregado = false;
	}

	public Serie(String titulo, String creador) {
		super();
		this.numt = 3;
		this.entregado = false;
		this.titulo = titulo;
		this.creador = creador;
		this.genero = "";
	}

	public Serie(String titulo, int numt, String creador, String genero) {
		super();
		this.numt = numt;
		this.entregado = false;
		this.titulo = titulo;
		this.creador = creador;
		this.numt = numt;
		this.genero = genero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getNumt() {
		return numt;
	}

	public void setNumt(Integer numt) {
		this.numt = numt;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	@Override
	public String toString() {
		return "Serie [titulo=" + titulo + ", numt=" + numt + ", entregado=" + entregado + ", genero=" + genero
				+ ", creador=" + creador + "]";
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
		if (a instanceof Serie) {
			Serie aux = (Serie) a;
			Integer numtem = aux.getNumt();
			if (this.numt == numtem) {
				num = 0;
			} else if (this.numt < numtem) {
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
