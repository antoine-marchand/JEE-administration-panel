package fr.epf.deadpoules.persistence;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class ClassDao {
	
	@PersistenceContext
	private EntityManager em;

	public void save(Class u) {
		em.persist(u);
	}

	public Class findOne(Long id) {
		return em.find(Class.class, id);
	}

	public List<Class> findAll() {
		return em.createQuery("SELECT * FROM class").getResultList();
	}
	
}
