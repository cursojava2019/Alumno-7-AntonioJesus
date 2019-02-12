package es.indra.academia.controller.alumnos;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.indra.academia.authentication.MyUserDetails;
import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.service.AlumnoJpaService;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.ServiceException;

@Controller
@RequestMapping("/admin/alumnos")
public class AlumnoController {
	@Autowired
	AlumnoJpaService alumnoService;

	@Autowired
	AlumnoFormValidator validador;
	private Logger log = LogManager.getLogger(AlumnoController.class);

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		model.addAttribute("error", e.getMessage());
		// logger.error(e);
		return "error";
	}

	@RequestMapping(value = "/listado.html", method = RequestMethod.GET)
	public String listado(Model model) throws ServiceException, DaoException {
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername(); // get logged in username

		this.log.info("listado Alumnos");
		List<Alumno> listado = this.alumnoService.buscarTodos();
		model.addAttribute("listado", listado);
		return "alumnos/listado";

	}

}
