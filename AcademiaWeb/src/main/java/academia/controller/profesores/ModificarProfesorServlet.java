package academia.controller.profesores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academia.model.entities.Profesor;
import academia.model.service.ProfesorService;

/**
 * Servlet implementation class ModificarAlumnoServlet
 */
@WebServlet("/admin/profesor/modificar.html")
public class ModificarProfesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarProfesorServlet() {
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
		ProfesorService profesorService = ProfesorService.getInstance();
		try {
			idLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			idLong = null;
		}
		if (idLong == null) {
			response.sendRedirect("./listado.html?mensaje=errorId");
		} else {
			Profesor profesor = profesorService.find(idLong);
			if (profesor != null) {
				request.setAttribute("formulario", profesor);
				RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/profesor/modificar.jsp");
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

		ProfesorForm profesor = ProfesorForm.obtenerAlumnoForm(request);

		profesor.validar(errores);
		if (errores.size() > 0) {
			request.setAttribute("formulario", profesor);
			request.setAttribute("errores", errores);

			RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/profesor/modificar.jsp");
			dispacher.forward(request, response);
		} else {
			ProfesorService profesorService = ProfesorService.getInstance();
			profesorService.update(profesor);

			response.sendRedirect("./listado.html?mensaje=correcto");
		}

	}

}
