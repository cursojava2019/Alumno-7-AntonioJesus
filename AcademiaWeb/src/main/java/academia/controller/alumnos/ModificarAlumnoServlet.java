package academia.controller.alumnos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academia.model.entities.Alumno;
import academia.model.service.AlumnoService;

/**
 * Servlet implementation class ModificarAlumnoServlet
 */
@WebServlet("/admin/alumnos/modificar.html")
public class ModificarAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarAlumnoServlet() {
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
		String id = request.getParameter("id");
		Long idLong = null;
		AlumnoService alumnoService = AlumnoService.getInstance();
		try {
			idLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			idLong = null;
		}
		if (idLong == null) {
			response.sendRedirect("./listado.html?mensaje=errorId");
		} else {
			Alumno alumno = alumnoService.find(idLong);
			if (alumno != null) {
				AlumnoForm form = new AlumnoForm(alumno);
				request.setAttribute("formulario", form);
				RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/alumnos/modificar.jsp");
				dispacher.forward(request, response);
			} else {
				response.sendRedirect("./listado.html?mensaje=errorId");
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<String> errores = new ArrayList<String>();

		AlumnoForm alumno = AlumnoForm.obtenerAlumnoForm(request);

		alumno.validar(errores);
		if (errores.size() > 0) {
			request.setAttribute("formulario", alumno);
			request.setAttribute("errores", errores);

			RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/alumnos/modificar.jsp");
			dispacher.forward(request, response);
		} else {
			AlumnoService alumnoService = AlumnoService.getInstance();
			alumnoService.update(alumno);

			response.sendRedirect("./listado.html?mensaje=correcto");
		}

	}

}
