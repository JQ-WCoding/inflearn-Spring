package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    // 사용자 저장, 찾기 등을 위해 미리 구현한 인터페이스로 구현한 메소드 -> 지정만 해두고 나머지 구현은 직접
    // MemoryMemberRepository 에서 구현한다 Optional 의 사용이유
    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
