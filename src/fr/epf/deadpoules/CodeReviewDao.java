package fr.epf.deadpoules;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class CodeReviewDao {
	
	@PersistenceContext
	private EntityManager em;

	public void save(CodeReview u) {
		em.persist(u);
	}

	public CodeReview findOne(Long id) {
		return em.find(CodeReview.class, id);
	}

	public List<CodeReview> findAll() {
		return em.createQuery("SELECT * FROM codeReview").getResultList();
	}

}
