package fr.epf.deadpoules.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epf.deadpoules.model.CodeReview;
import fr.epf.deadpoules.model.Promotion;

@Singleton
public class CodeReviewDao {

	@Inject
	private PromotionDao promotionDao;

	@PersistenceContext
	private EntityManager em;

	public void save(CodeReview u) {
		em.persist(u);
	}

	public CodeReview findOne(Long id) {
		return em.find(CodeReview.class, id);
	}
	
	public long count() {
		 return (long)em.createQuery("SELECT COUNT(*) FROM CodeReview").getSingleResult();
		}

	public List<CodeReview> findAll() {
		return em.createQuery("FROM CodeReview").getResultList();
	}

}
