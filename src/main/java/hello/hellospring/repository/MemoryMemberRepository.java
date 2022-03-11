package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

// @Repository
public class MemoryMemberRepository implements MemberRepository {

    private static final Map<Long, Member> store = new HashMap<>();
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
        // null 인지 value of 를 이용해 값이 있는지 확인하고 반환한다
        return Optional.ofNullable( store.get( id ) );
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 끝까지 하나라도 찾으면 반환하는 방법
        // findAny() 메소드를 통해 하나라도 찾게 되면 반환한다 -> name 으로 찾기 때문에 우선적인 조회가 필요함
        return store.values().stream().filter( member -> member.getName().equals( name ) ).findAny();
    }

    @Override
    public List<Member> findAll() {
        // Member 들을 반환
        return new ArrayList<>( store.values() );
    }

    public void clearStore() {
        store.clear();
    }
}
