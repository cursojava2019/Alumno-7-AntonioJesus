package es.indra.model.support;

import java.util.List;

public interface Dao<K, O> {

	public void create(O entity) throws DaoException;

	public void update(O entity) throws DaoException;

	public void delete(K key) throws DaoException;

	public O find(K key) throws DaoException;

	public List<O> findAll() throws DaoException;

}
