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


import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberServiceTest {
	
	MemberService memberService;
	MemoryMemberRepository memberRepository;
	
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
		
	}

	@Test
	void testJoin()  {
//		given
		Member member = new Member();
		member.setName("spring");
//		when
		Long saveId = memberService.join(member);
		System.out.println(saveId);
		
//		System.out.println(memberService.findMembers());
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
