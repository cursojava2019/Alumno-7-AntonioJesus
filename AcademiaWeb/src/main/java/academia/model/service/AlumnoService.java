package academia.model.service;

import java.util.ArrayList;
import java.util.List;

import academia.model.dao.AlumnoDao;
import academia.model.entities.Alumno;
import academia.model.support.Dao;
import academia.model.support.DaoException;
import academia.model.support.Service;

public class AlumnoService extends Service<Long, Alumno> {

	private static AlumnoService singleton = null;
	private AlumnoDao dao;

	public static AlumnoService getInstance() {
		if (singleton == null) {
			singleton = new AlumnoService();
		}
		return singleton;

	}

	private AlumnoService() {
		super();
		this.dao = new AlumnoDao();
	}

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

}
