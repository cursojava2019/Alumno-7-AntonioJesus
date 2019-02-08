package es.indra.academia.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.indra.academia.model.dao.AlumnoDao;
import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.support.Dao;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.Service;

@org.springframework.stereotype.Service
public class AlumnoService extends Service<Long, Alumno> {

	@Autowired
	private AlumnoDao dao;

	@Override
	protected Dao<Long, Alumno> getDao() {
		return this.dao;
	}

	public List<Alumno> findAlumnosPatron(String patron) {
		try {
			return this.dao.findAlumnos(patron);
		} catch (DaoException e) {
			e.printStackTrace();
			return new ArrayList<Alumno>();
		}

	}

	public List<Alumno> findAlumnosPatronbaja(String patron) {
		try {
			return this.dao.findAlumnosbaja(patron);
		} catch (DaoException e) {
			e.printStackTrace();
			return new ArrayList<Alumno>();
		}

	}

	public List<Alumno> findAlumnosPatronalta(String patron) {
		try {
			return this.dao.findAlumnosalta(patron);
		} catch (DaoException e) {
			e.printStackTrace();
			return new ArrayList<Alumno>();
		}

	}

	public List<Alumno> buscarNif(String nif) {
		try {
			return this.dao.buscarNif(nif);
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void darbaja(Alumno alumno) {
		try {
			this.dao.darbaja(alumno);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	public List<Alumno> listaalta() {
		try {
			return this.dao.findAllalta();
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Alumno> listabaja() {
		try {
			return this.dao.findAllbaja();
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Alumno> listarepe() {
		try {
			return this.dao.findAllrepe();
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void daralta(Alumno alumno) {
		try {
			this.dao.daralta(alumno);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
