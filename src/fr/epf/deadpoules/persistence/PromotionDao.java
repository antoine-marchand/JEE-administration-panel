package fr.epf.deadpoules.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
		return (Promotion)em.createQuery("FROM Promotion WHERE name='" + name + "'").getResultList().get(0);
	}

	public long count() {
	 return (long)em.createQuery("SELECT COUNT(*) FROM Promotion").getSingleResult();
	}
	
	public List<Integer> countMembers() {
		
		List<Integer> listCountMembers;
		listCountMembers = em.createQuery("SELECT COUNT(*) FROM Member GROUP BY promotion_id").getResultList();
		return listCountMembers;
		}

	public List<Promotion> findAll() {
		List<Promotion> promotions = new ArrayList<>();
		List<Object> result = (List<Object>) em.createQuery("SELECT id,name FROM Promotion").getResultList();
		Iterator itr = result.iterator();

		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			Long id = Long.parseLong(String.valueOf(obj[0]));
			String name = String.valueOf(obj[1]);
			promotions.add(new Promotion(name));
		}

		return promotions;
	}

}
