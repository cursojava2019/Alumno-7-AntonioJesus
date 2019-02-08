package es.indra.academia.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.indra.academia.model.dao.ProfesorDao;
import es.indra.academia.model.entities.Profesor;
import es.indra.academia.model.support.Dao;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.Service;

@org.springframework.stereotype.Service
public class ProfesorService extends Service<Long, Profesor> {

	@Autowired
	private ProfesorDao dao;

	@Override
	protected Dao<Long, Profesor> getDao() {
		return this.dao;
	}

	public List<Profesor> findProfesoresPatron(String patron) {
		try {
			return this.dao.findProfesores(patron);
		} catch (DaoException e) {
			e.printStackTrace();
			return new ArrayList<Profesor>();
		}

	}

	public List<Profesor> buscarNif(String nif) {
		try {
			return this.dao.buscarNif(nif);
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}

}