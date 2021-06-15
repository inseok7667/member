package hello.hellospring.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.*;
import hello.hellospring.repository.MemberRepository; 
import hello.hellospring.repository.MemoryMemberRepository;

class MemoryMemberRepositoryTest {

	MemberRepository repository = new MemoryMemberRepository();
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		
		Member result = repository.findbyId(member.getId()).get();
		System.out.println("result = " + (result==member));
//				Assertions.assertEquals(member , result);
	}
}
