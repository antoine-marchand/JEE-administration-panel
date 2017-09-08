package fr.epf.deadpoules.persistence;

import java.util.List;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epf.deadpoules.model.Member;

@Singleton
public class MemberDao {
	
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
	
	public void delete (Member deleteMember) {
	    em.remove(em.merge(deleteMember));
	}
}
