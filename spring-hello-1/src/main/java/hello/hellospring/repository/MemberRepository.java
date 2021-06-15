package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.*;

public interface MemberRepository {
	Member save(Member member);
	
	Optional<Member> findbyId(Long id);
	
	Optional<Member> findbyName(String name);
	
	List<Member> findAll();

}
