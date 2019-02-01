package academia.model.service;

import java.util.ArrayList;
import java.util.List;

import academia.model.dao.ProfesorDao;
import academia.model.entities.Profesor;
import academia.model.support.Dao;
import academia.model.support.DaoException;
import academia.model.support.Service;

public class ProfesorService extends Service<Long, Profesor> {

	private static ProfesorService singleton = null;
	private ProfesorDao dao;

	public static ProfesorService getInstance() {
		if (singleton == null) {
			singleton = new ProfesorService();
		}
		return singleton;

	}

	private ProfesorService() {
		super();
		this.dao = new ProfesorDao();
	}

	@Override
	protected Dao<Long, Profesor> getDao() {

		return this.dao;
	}

	public List<Profesor> findProfesorPatron(String patron) {
		try {
			return this.dao.findProfesor(patron);
		} catch (DaoException e) {
			e.printStackTrace();
			return new ArrayList<Profesor>();
		}

	}

}
