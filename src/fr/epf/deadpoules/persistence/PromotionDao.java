package fr.epf.deadpoules.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epf.deadpoules.model.Member;
import fr.epf.deadpoules.model.Promotion;

@Singleton
public class PromotionDao {

	@PersistenceContext
	private EntityManager em;

	public void save(Promotion u) {
		em.persist(u);
	}
	
	public Promotion update (Promotion updatePromotion) {
	    return em.merge(updatePromotion);
	}

	public Promotion findOne(Long id) {
		return em.find(Promotion.class, id);
	}

	public Promotion findByName(String name) {
		return (Promotion)em.createQuery("FROM Promotion WHERE name='" + name + "'").getResultList().get(0);
	}
	
	public boolean promotionExist(String name) {
		List<Promotion> promotionList = em.createQuery("FROM Member WHERE name='" + name + "'").getResultList();
		boolean exist;
		if (promotionList.isEmpty()) {
			exist = true;
		}else {
			exist = false;
		}
		return exist;
	}

	public long count() {
	 return (long)em.createQuery("SELECT COUNT(*) FROM Promotion").getSingleResult();
	}

	public List<Promotion> findAll() {
		return em.createQuery("FROM Promotion").getResultList();
	}

}
