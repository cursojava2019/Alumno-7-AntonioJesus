package academia.controller.alumnos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academia.model.service.AlumnoService;

/**
 * Servlet implementation class CrearAlumnoServlet
 */
@WebServlet("/admin/alumnos/nuevo.html")
public class CrearAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearAlumnoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/alumnos/nuevo.jsp");
		dispacher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<String> errores = new ArrayList<String>();

		String nif = request.getParameter("nif");
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String telefono = request.getParameter("telefono");
		String correo = request.getParameter("email");
		String repetidor = request.getParameter("repetidor");
		String observaciones = request.getParameter("observaciones");

		AlumnoForm alumno = new AlumnoForm();
		alumno.setCorreo(correo);
		alumno.setApellido2(apellido2);
		alumno.setApellido1(apellido1);
		alumno.setNif(nif);
		alumno.setNombre(nombre);
		alumno.setTlf(telefono);
		alumno.setObservaciones(observaciones);

		if (repetidor != null && !repetidor.equals("")) {
			Boolean repetidorB = Boolean.parseBoolean(repetidor);
			alumno.setRepetidor(repetidorB);
		} else {
			alumno.setRepetidor(false);
		}
		alumno.setObservaciones(observaciones);
		alumno.setFechaAlta(new Date());
		alumno.setFechaBaja(new Date());
		alumno.validar(errores);
		if (errores.size() > 0) {
			request.setAttribute("formulario", alumno);
			request.setAttribute("errores", errores);

			RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/alumnos/nuevo.jsp");
			dispacher.forward(request, response);
		} else {
			AlumnoService alumnoService = AlumnoService.getInstance();
			alumnoService.create(alumno);

			response.sendRedirect("./listado.html?mensaje=correcto");
		}
	}

}
