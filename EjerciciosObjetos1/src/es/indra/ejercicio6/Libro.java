package es.indra.ejercicio6;

public class Libro {
	String ISBN;
	String Titulo;
	String Autor;
	Integer nump;

	public Libro(String isbn, String titulo, String autor, Integer numpa) {
		this.ISBN = isbn;
		this.Titulo = titulo;
		this.Autor = autor;
		this.nump = numpa;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public Integer getNump() {
		return nump;
	}

	public void setNump(Integer nump) {
		this.nump = nump;
	}

	@Override
	public String toString() {
		return "El libro con ISBN " + ISBN + " con titulo " + Titulo + " creado por el autor " + Autor + " con " + nump
				+ " número de paginas. ";
	}

}
