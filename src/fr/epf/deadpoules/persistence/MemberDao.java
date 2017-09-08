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
		List<Member> members = new ArrayList<>();
		List<Object> result = (List<Object>) em.createQuery("SELECT id,name,email,birthdate FROM Member")
				.getResultList();
		Iterator itr = result.iterator();

		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			// now you have one array of Object for each row
			Long id = Long.parseLong(String.valueOf(obj[0]));
			String name = String.valueOf(obj[3]); // don't know the type of column CLIENT assuming String
			String email = String.valueOf(obj[2]);
			LocalDate birthdate = LocalDate.parse(String.valueOf(obj[1]));
			Promotion promotion = promotionDao.findOne(Long.valueOf((Long) obj[4]));

			members.add(new Member(name, email, birthdate, promotion));
		}
		return members;
	}
}
