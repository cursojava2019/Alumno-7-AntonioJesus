package es.indra.academia.controller.profesores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.indra.academia.model.entities.Profesor;
import es.indra.academia.model.service.ProfesorService;

@Component
public class ProfesorFormValidator implements Validator {

	@Autowired
	private ProfesorService profesorService;

	@Override
	public boolean supports(Class<?> clazz) {
		return ProfesorForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProfesorForm form = (ProfesorForm) target;
		if (form.getNif() != null && !form.getNif().equals("")) {
			List<Profesor> listado = this.profesorService.buscarNif(form.getNif());
			if (listado != null && !listado.isEmpty()) {
				Profesor profesor = listado.get(0);
				if (form.getId() == null || (!profesor.getId().equals(form.getId()))) {
					errors.rejectValue("nif", "nif.unico");
				}
			}
		}

	}

}
