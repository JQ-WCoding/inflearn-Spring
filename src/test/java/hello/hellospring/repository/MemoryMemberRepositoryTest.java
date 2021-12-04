package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // test 상에서 중복되는 데이터 방지를 위해 매테스트 마다 데이터 클리어 하고 다시 test 진입하기 위해
    @AfterEach
    public void afterEach() {
        // 저장소 비우기
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName( "Spring" );
        repository.save( member );

        Member result = repository.findById( member.getId() ).get();
        // 기대 값이 같은지 확인해보는 경우
        // Assertions.assertEquals( member, result );
        Assertions.assertThat( member ).isEqualTo( result );
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName( "Spring1" );
        repository.save( member1 );

        Member member2 = new Member();
        member2.setName( "Spring2" );
        repository.save( member2 );

        Member result = repository.findByName( "Spring1" ).get();

        Assertions.assertThat( result ).isEqualTo( member1 );
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName( "Spring1" );
        repository.save( member1 );

        Member member2 = new Member();
        member2.setName( "Spring2" );
        repository.save( member2 );

        List<Member> result = repository.findAll();

        Assertions.assertThat( result.size() ).isEqualTo( 2 );
    }
}
