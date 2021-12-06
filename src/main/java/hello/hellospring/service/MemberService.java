package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    // private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;

    // Spring Container 에 있는 구현체를 주입해서 넣어준다
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 같은 이름의 회원은 안된다면? command + option + v
        // Optional 안의 여러 메서드를 사용가능 (Optional 은 null 인 가능성이 있는 경우 주로 사용한다)
        validateDuplicatedMember( member );

        memberRepository.save( member );
        return member.getId();
    }

    private void validateDuplicatedMember(Member member) {
        // Optional<Member> result = memberRepository.findByName( member.getName() );
        // result.ifPresent( m -> {
        //     throw new IllegalStateException( "이미 존재하는 회원" );
        // } );

        // 위와 동일하지만 더 깔끔하게 사용가능
        memberRepository.findByName( member.getName() )
                .ifPresent( m -> {
                    throw new IllegalStateException( "이미 존재하는 회원" );
                } );
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 한명 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById( memberId );
    }
}
