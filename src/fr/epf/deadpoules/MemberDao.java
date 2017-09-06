package fr.epf.deadpoules;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

	public List<Member> findAll() {
		return em.createQuery("SELECT * FROM member").getResultList();
	}

}
