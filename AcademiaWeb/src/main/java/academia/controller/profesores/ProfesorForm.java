package academia.controller.profesores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import academia.model.entities.Profesor;

public class ProfesorForm extends Profesor {

	public ProfesorForm() {
		super();
		setNif("");
		setNombre("");
		setApellido1("");
		setApellido2("");
		setTlf("");
		setCorreo("");
		setTitulacion("");

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

	public static ProfesorForm obtenerAlumnoForm(HttpServletRequest request) {
		String id = request.getParameter("id");
		String nif = request.getParameter("nif");
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String telefono = request.getParameter("telefono");
		String correo = request.getParameter("email");
		String titulacion = request.getParameter("titulacion");

		ProfesorForm profesor = new ProfesorForm();
		Long idLong = null;
		try {
			idLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			idLong = null;
		}
		profesor.setId(idLong);
		profesor.setCorreo(correo);
		profesor.setApellido2(apellido2);
		profesor.setApellido1(apellido1);
		profesor.setNif(nif);
		profesor.setNombre(nombre);
		profesor.setTlf(telefono);
		profesor.setTitulacion(titulacion);

		return profesor;
	}
}
