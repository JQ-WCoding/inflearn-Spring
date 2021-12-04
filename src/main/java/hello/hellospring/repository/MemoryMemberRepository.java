package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId( ++sequence );
        store.put( member.getId(), member );
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // null 일 경우를 대비해 Optional 로 감싸서 보낸다
        return Optional.ofNullable( store.get( id ) );
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 끝까지 하나라도 찾으면 반환하는 방법
        return store.values().stream().filter( member -> member.getName().equals( name ) ).findAny();
    }

    @Override
    public List<Member> findAll() {
        // Member 들을 반환
        return new ArrayList<>( store.values() );
    }
}
