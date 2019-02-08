package es.indra.academia.controller.alumnos;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.service.AlumnoService;

@Controller
@RequestMapping("/admin/alumnos")
public class AlumnoController {
	@Autowired
	AlumnoService alumnoService;

	@Autowired
	AlumnoFormValidator validador;

	@RequestMapping(value = "/listado.html", method = RequestMethod.GET)
	public String listado(Model model) {

		List<Alumno> listado = this.alumnoService.findAll();
		model.addAttribute("listado", listado);
		return "alumnos/listado";
	}

	@RequestMapping(value = "/listadoestado.html", method = RequestMethod.GET)
	public String listadoestado(@RequestParam("estado") String estado, Model model) {
		if (estado.equals("todos")) {
			List<Alumno> listado = this.alumnoService.findAll();
			model.addAttribute("listado", listado);
			model.addAttribute("estado", estado);
			return "alumnos/listado";
		} else if (estado.equals("baja")) {
			List<Alumno> listado = this.alumnoService.listabaja();
			model.addAttribute("listado", listado);
			model.addAttribute("estado", estado);
			return "alumnos/listado";
		} else {
			List<Alumno> listado = this.alumnoService.listaalta();
			model.addAttribute("listado", listado);
			model.addAttribute("estado", estado);
			return "alumnos/listado";
		}

	}

	@RequestMapping(value = "/listadorepe.html", method = RequestMethod.GET)
	public String listadorepe(@RequestParam("estado") String estado, Model model) {

		List<Alumno> listado = this.alumnoService.listarepe();
		model.addAttribute("listado", listado);
		model.addAttribute("estado", estado);
		return "alumnos/listado";

	}

	@RequestMapping(value = "/listado.html", method = RequestMethod.POST)
	public String listadoPatron(@RequestParam("patron") String patron, @RequestParam("estado") String estado,
			Model model) {
		List<Alumno> listado;

		if (estado.equals("todos")) {
			if (patron == null || patron.equals("")) {
				listado = alumnoService.findAll();

			} else {
				listado = alumnoService.findAlumnosPatron(patron);
			}
		} else if (estado.equals("baja")) {
			if (patron == null || patron.equals("")) {
				listado = alumnoService.listabaja();

			} else {
				listado = alumnoService.findAlumnosPatronbaja(patron);
			}
		} else {
			if (patron == null || patron.equals("")) {
				listado = alumnoService.listaalta();

			} else {
				listado = alumnoService.findAlumnosPatronalta(patron);
			}
		}
		model.addAttribute("estado", estado);
		model.addAttribute("patron", patron);
		model.addAttribute("listado", listado);
		return "alumnos/listado";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.GET)
	public String nuevo(Model model) {
		model.addAttribute("alumno", new AlumnoForm(new Alumno()));
		return "alumnos/nuevo";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.POST)
	public String nuevoPost(@Valid @ModelAttribute("alumno") AlumnoForm form, BindingResult result) {
		this.validador.validate(form, result);
		if (result.hasErrors()) {
			return "alumnos/nuevo";
		} else {
			this.alumnoService.create(form.obtenerAlumno());
			return "redirect:/admin/alumnos/listado.html?mensaje=correcto";
		}

	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.GET)
	public String modificar(@RequestParam("id") Long id, Model model) {
		if (id == null) {
			return "redirect:/admin/alumnos/listado.html?mensaje=errorId";
		} else {
			Alumno alumno = this.alumnoService.find(id);
			if (alumno != null) {
				AlumnoForm form = new AlumnoForm(alumno);
				model.addAttribute("formulario", form);
				return "alumnos/modificar";
			} else {
				return "redirect:/admin/alumnos/listado.html?mensaje=errorId";
			}
		}
	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.POST)
	public String modificarPost(@Valid @ModelAttribute("formulario") AlumnoForm form, BindingResult result) {
		this.validador.validate(form, result);
		if (result.hasErrors()) {
			return "alumnos/modificar";
		} else {

			this.alumnoService.update(form.obtenerAlumno());

			return "redirect:/admin/alumnos/listado.html?mensaje=correcto";
		}

	}

	@RequestMapping(value = "/eliminar.html", method = RequestMethod.GET)
	public String eliminar(@RequestParam("id") Long id, Model model) {

		if (id == null) {
			return "redirect:/admin/alumnos/listado.html?mensaje=errorId";
		} else {
			Alumno alumno = this.alumnoService.find(id);
			if (alumno != null) {
				this.alumnoService.delete(id);
				return "redirect:/admin/alumnos/listado.html?mensaje=correcto";
			} else {
				return "redirect:/admin/alumnos/listado.html?mensaje=errorId";
			}

		}

	}

	@RequestMapping(value = "/baja.html", method = RequestMethod.GET)
	public String baja(@RequestParam("id") Long id, Model model) {
		if (id == null) {
			return "redirect:/admin/alumnos/listadoestado.html?estado=alta";
		} else {
			Alumno alumno = this.alumnoService.find(id);
			if (alumno != null) {
				this.alumnoService.darbaja(alumno);
				return "redirect:/admin/alumnos/listadoestado.html?estado=alta";
			} else {
				return "redirect:/admin/alumnos/listadoestado.html?estado=alta";
			}
		}
	}

	@RequestMapping(value = "/alta.html", method = RequestMethod.GET)
	public String alta(@RequestParam("id") Long id, Model model) {
		if (id == null) {
			return "redirect:/admin/alumnos/listadoestado.html?estado=baja";
		} else {
			Alumno alumno = this.alumnoService.find(id);
			if (alumno != null) {
				this.alumnoService.daralta(alumno);
				return "redirect:/admin/alumnos/listadoestado.html?estado=baja";
			} else {
				return "redirect:/admin/alumnos/listadoestado.html?estado=baja";
			}
		}
	}

}
