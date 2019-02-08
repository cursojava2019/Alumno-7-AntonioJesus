package es.indra.academia.model.support;

import java.util.List;

public abstract class Service<K, O> {

	protected abstract Dao<K, O> getDao();

	public void create(O entity) {
		try {
			getDao().create(entity);
		} catch (DaoException e) {
			System.out.println("Error al crear en base de datos " + entity.getClass().getName());
		}
	}

	public void update(O entity) {
		try {
			getDao().update(entity);
		} catch (DaoException e) {
			System.out.println("Error al modificar en base de datos " + entity.getClass().getName());
		}
	}

	public void delete(K key) {
		try {
			getDao().delete(key);
		} catch (DaoException e) {
			System.out.println("Error al eliminar en base de datos ");
		}
	}

	public O find(K key) {
		try {
			O entidad = getDao().find(key);
			return entidad;
		} catch (DaoException e) {
			System.out.println("Error Al realizar la busqueda ");
			return null;
		}
	}

	public List<O> findAll() {
		try {

			return getDao().findAll();
		} catch (DaoException e) {
			System.out.println("Error Al realizar la busqueda de todas las filas");
			return null;
		}

	}
}
