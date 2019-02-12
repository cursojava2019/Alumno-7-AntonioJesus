package es.indra.academia.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.indra.academia.model.dao.AlumnoJpaDao;
import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.support.jpa.JpaDao;
import es.indra.academia.model.support.jpa.ServiceJpa;

@Service
public class AlumnoJpaService extends ServiceJpa<Long, Alumno> {
	@Autowired
	private AlumnoJpaDao dao;

	@Override
	public JpaDao<Long, Alumno> getDao() {
		return this.dao;
	}

}