package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.hellospring.domain.*;
import hello.hellospring.repository.*;


@Transactional
public class MemberService {

	private final MemberRepository memberRepository ;
	
	
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	

//	회원가입

	

	public Long join(Member member) {
		validateDuplicateMember(member); // 중복회원 검증
//		result.orElseGet(null) 값이 있으면 꺼내라 ~
		
		memberRepository.save(member);  // 저장

		return member.getId();

	}

	
	
	public List<Member> findMembers() {
		System.out.println("findMembers 실행");
		return memberRepository.findAll();
	}
	
	public Optional<Member> findOne(Long memberId){
//		System.out.println(memberId);
		return memberRepository.findbyId(memberId);
	}

	
	private void validateDuplicateMember(Member member) {
		System.out.println("예외처리 실행");
		memberRepository.findbyName(member.getName()).ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}
	
	
}
