package es.indra.ejercicio2;

public class Persona {
	protected String nombre;
	protected int edad;
	protected int dni;
	protected Double peso;
	protected Double altura;
	protected char sexo;

	static char HOMBRE = 'H';
	static char MUJER = 'M';

	public Persona() {
		super();
		this.nombre = "";
		this.edad = 0;
		this.peso = Double.valueOf(0);
		this.altura = Double.valueOf(0);
		this.sexo = HOMBRE;
		this.dni = GenerarDni();
	}

	public Persona(String nombre, int edad, char sexo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = Double.valueOf(0);
		this.altura = Double.valueOf(0);
		this.sexo = HOMBRE;
		this.dni = GenerarDni();
	}

	public Persona(String nombre, int edad, Double peso, Double altura, char sexo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;
		if (sexo == 'H') {
			this.sexo = sexo;
		} else {
			this.sexo = 'M';
		}

		this.dni = GenerarDni();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getDni() {
		return dni;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int calcularIMC() {
		Double imc = peso / (altura * altura);
		int aux = 0;
		if (imc > 25) {
			aux = 1;
		} else {
			if (imc < 20) {
				aux = -1;
			} else {
				aux = 0;
			}
		}
		return aux;
	}

	public boolean esMayorDeEdad() {
		boolean MayorEdad = true;
		if (edad < 18) {
			MayorEdad = false;
		}
		return MayorEdad;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + ", peso=" + peso + ", altura=" + altura
				+ ", sexo=" + sexo + "]";
	}

	protected int GenerarDni() {
		int aux = (int) (Math.random() * 99999999);
		return aux;
	}

}
