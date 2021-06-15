package hello.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions.*;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

@SpringBootTest
@Transactional
public class MemberServiceTestintgrationTest {
	
	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	
	

	@Test
	void 회원가입()  {
//		given
		Member member = new Member();
		member.setName("spring555");
//		when
		Long saveId = memberService.join(member);
//		System.out.println(saveId);
		
//		then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
		
	}

	@Test
	public void testFindMembers(){
		
	}

	@Test
	public void testFindOne() {
		
	}

}
