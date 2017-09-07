package fr.epf.deadpoules.persistence;

//import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epf.deadpoules.model.Promotion;

@Singleton
public class PromotionDao {
	
	@PersistenceContext
	private EntityManager em;

	public void save(Promotion u) {
		em.persist(u);
	}

	public Promotion findOne(Long id) {
		return em.find(Promotion.class, id);
	}

	public Promotion findByName(String name) {
		return em.find(Promotion.class, name);
	}
	
//	public List<Class> findAll() {
//		return em.createQuery("SELECT * FROM class").getResultList();
//	}
	
}
