package es.indra.academia.model.support.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public abstract class AbstracJpaDao<K extends Serializable, T extends Serializable> implements JpaDao<K, T> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected abstract Class<T> getClase();

	@Override
	@Transactional
	public T findOne(K id) {
		return this.entityManager.find(getClase(), id);
	}

	@Override
	@Transactional
	public List<T> findAll() {

		return this.entityManager.createQuery("from " + getClase().getName()).getResultList();
	}

	@Override
	@Transactional
	public void save(T entity) {
		this.entityManager.persist(entity);
	}

	@Override
	@Transactional
	public void update(T entity) {
		this.entityManager.merge(entity);
	}

	@Override
	@Transactional
	public void delete(T entity) {
		this.entityManager.remove(entity);
	}

	@Override
	@Transactional
	public void deleteById(K entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}
}