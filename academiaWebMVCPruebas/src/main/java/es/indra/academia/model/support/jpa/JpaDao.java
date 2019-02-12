package es.indra.academia.model.support.jpa;

import java.io.Serializable;
import java.util.List;

public interface JpaDao<K extends Serializable, T extends Serializable> {

	public T findOne(K id);

	public List<T> findAll();

	public void save(T entity);

	public void update(T entity);

	public void delete(T entity);

	public void deleteById(K entityId);
}