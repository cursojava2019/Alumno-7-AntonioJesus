package es.indra.academia.model.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.support.jpa.AbstracJpaDao;

@Repository
public class AlumnoJpaDao extends AbstracJpaDao<Long, Alumno> {

	@Override
	protected Class<Alumno> getClase() {
		return Alumno.class;
	}

	List<Alumno> findAlumnosPatron(String patron) {
		String queryString = "SELECT o From Alumno o Where WHERE LOWER(o.nif) like LOWER('%" + patron
				+ "%') OR LOWER(o.nombre) like LOWER('%" + patron + "%') OR LOWER(o.apellido1) like LOWER('%" + patron
				+ "%')  OR LOWER(o.apellido2) like LOWER('%" + patron + "%') ;";

		Query query = this.entityManager.createQuery(queryString);
		return query.getResultList();
	}

}