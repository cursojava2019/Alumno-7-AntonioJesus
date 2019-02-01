package academia.controller.profesores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academia.model.entities.Profesor;
import academia.model.service.ProfesorService;

/**
 * Servlet implementation class ListarAlumnosServer
 */
@WebServlet("/admin/profesor/listado.html")
public class ListarProfesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListarProfesorServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProfesorService profesorService = ProfesorService.getInstance();

		List<Profesor> profesor = profesorService.findAll();
		request.setAttribute("listado", profesor);

		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/profesor/listado.jsp");
		dispacher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		ProfesorService profesorService = ProfesorService.getInstance();
		String patron = request.getParameter("patron");
		List<Profesor> profesor = null;
		if (patron != null && !patron.equals("")) {
			profesor = profesorService.findProfesorPatron(patron);
		} else {
			profesor = profesorService.findAll();
		}

		request.setAttribute("listado", profesor);

		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/profesor/listado.jsp");
		dispacher.forward(request, response);
	}

}
