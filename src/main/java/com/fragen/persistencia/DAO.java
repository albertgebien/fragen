package br.com.brasiliashopping.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class DAO {

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> listar(Class<T> classe) {
		Query query = getEntityManager().createQuery(
				"from " + classe.getSimpleName());

		return (List<T>) query.getResultList();
	}

}
