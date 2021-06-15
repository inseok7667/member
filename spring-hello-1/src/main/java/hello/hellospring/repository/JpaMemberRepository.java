package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import hello.hellospring.domain.Member;

public class JpaMemberRepository implements MemberRepository{

	private final EntityManager em;   //jpa는 entity매니저를 통해 모든게 동작한다.
	
	public JpaMemberRepository(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public Member save(Member member) {
		em.persist(member);
		return member;
	}

	@Override
	public Optional<Member> findbyId(Long id) {
		// TODO Auto-generated method stub
		Member member = em.find(Member.class, id);
		return Optional.ofNullable(member);
	}

	@Override
	public Optional<Member> findbyName(String name) {
		List<Member> result = em.createQuery("select m from Member m where m.name = :name" , Member.class)
				.setParameter("name", name)
				.getResultList();
				
		return result.stream().findAny();
	}

	@Override
	public List<Member> findAll() {
		List<Member> result = em.createQuery("select m from Member" , Member.class)
				.getResultList();
		return result;
	}

}
