package academia.controller.alumnos;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import academia.model.entities.Alumno;

public class AlumnoForm extends Alumno {

	public AlumnoForm() {
		super();
		setNif("");
		setNombre("");
		setApellido1("");
		setApellido2("");
		setTlf("");
		setCorreo("");
		setObservaciones("");
		setRepetidor(false);
	}

	public AlumnoForm(Alumno alumno) {
		super();
		setNif(alumno.getNif());
		setNombre(alumno.getNombre());
		setApellido1(alumno.getApellido1());
		setApellido2(alumno.getApellido2());
		setTlf(alumno.getTlf());
		setCorreo(alumno.getCorreo());
		setObservaciones(alumno.getObservaciones());
		setRepetidor(false);
	}

	public void validar(List<String> errores) {
		if (getNif() == null || getNif().equals("")) {
			errores.add("El nif es obligatorio");

		}
		if (getNif().length() != 9) {
			errores.add("El formato de NIF no es correcto");

		}
		if (getNombre() == null || getNombre().equals("")) {
			errores.add("El Nombre es obligatorio");

		}
		if (getApellido1() == null || getApellido1().equals("")) {
			errores.add("El Primero Apellido es obligatorio");

		}

	}

	public static AlumnoForm obtenerAlumnoForm(HttpServletRequest request) {
		String id = request.getParameter("id");
		String nif = request.getParameter("nif");
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String telefono = request.getParameter("telefono");
		String correo = request.getParameter("email");
		String repetidor = request.getParameter("repetidor");
		String observaciones = request.getParameter("observaciones");

		AlumnoForm alumno = new AlumnoForm();
		Long idLong = null;
		try {
			idLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			idLong = null;
		}

		Boolean repetiBool = Boolean.parseBoolean(repetidor);
		alumno.setId(idLong);
		alumno.setCorreo(correo);
		alumno.setApellido2(apellido2);
		alumno.setApellido1(apellido1);
		alumno.setNif(nif);
		alumno.setNombre(nombre);
		alumno.setTlf(telefono);
		alumno.setObservaciones(observaciones);
		alumno.setRepetidor(repetiBool);
		return alumno;
	}
}
