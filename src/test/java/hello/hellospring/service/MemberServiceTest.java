package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    // MemberService memberService = new MemberService();
    MemberService memberService;
    // 현재 memberRepository 는 memberService 의 repository 랑 달라질 수 있다
    // MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        // di -> dependency injection 외부에서 주입
        memberService = new MemberService( memberRepository );
    }

    @AfterEach
    public void afterEach() {
        // 저장소 비우기
        memberRepository.clearStore();
    }

    // 한글로 작성해도 괜찮다 대신 헷갈릴 순 있다...
    @Test
    void 회원가입() {
        // given when then -> 3단으로 생성하는 것이 test 를 보기 쉽다
        // given
        Member member = new Member();
        member.setName( "spring" );

        // when
        Long saveId = memberService.join( member );
        Member findMember = memberService.findOne( saveId ).get();

        // then
        Assertions.assertThat( member.getName() ).isEqualTo( findMember.getName() );
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName( "spring" );

        Member member2 = new Member();
        member2.setName( "spring" );

        // when
        memberService.join( member1 );
        // memberService.join( member2 );
        // 해당 오류가 발생한다고 가정하에
        IllegalStateException e = assertThrows( IllegalStateException.class, () -> memberService.join( member2 ) );

        Assertions.assertThat( e.getMessage() ).isEqualTo( "이미 존재하는 회원" );

        // try catch 문을 사용한것
        // try {
        //     memberService.join( member2 );
        //     fail();
        // } catch ( IllegalStateException e ) {
        //     Assertions.assertThat( e.getMessage() ).isEqualTo( "이미 존재하는 회원" );
        // }

        // then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}