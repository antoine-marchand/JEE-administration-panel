package fr.epf.deadpoules.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epf.deadpoules.model.Member;
import fr.epf.deadpoules.model.Promotion;

@Singleton
public class MemberDao {

	@Inject
	private PromotionDao promotionDao;
	
	@PersistenceContext
	private EntityManager em;

	public void save(Member u) {
		em.persist(u);
	}

	public Member findOne(Long id) {
		return em.find(Member.class, id);
	}
	
	public long count() {
		 return (long)em.createQuery("SELECT COUNT(*) FROM Member").getSingleResult();
		}
	
	
	public List<Member> findAll() {
		return em.createQuery("FROM Member").getResultList();
	}
	public Member update (Member updateMember) {
	    return em.merge(updateMember);
	}
}
