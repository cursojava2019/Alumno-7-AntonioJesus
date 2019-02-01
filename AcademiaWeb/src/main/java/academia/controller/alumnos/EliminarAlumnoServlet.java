package academia.controller.alumnos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academia.model.entities.Alumno;
import academia.model.service.AlumnoService;

/**
 * Servlet implementation class EliminarAlumnoServlet
 */
@WebServlet("/admin/alumnos/eliminar.html")
public class EliminarAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminarAlumnoServlet() {
		super();

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
				alumnoService.delete(idLong);
				response.sendRedirect("./listado.html?mensaje=correcto");
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

		doGet(request, response);
	}

}
