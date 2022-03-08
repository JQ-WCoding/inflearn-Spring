package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // private DataSource dataSource;
    //
    // @Autowired
    // public SpringConfig(DataSource dataSource) {
    //     this.dataSource = dataSource;
    // }


    // private EntityManager em;
    //
    // public SpringConfig(EntityManager em) {
    //     this.em = em;
    // }


    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService( memberRepository );
    }


    /* 의존성 주입을 외부에서 간단하게 붙였다 때는 형식으로 진행하여 해당 @Bean 만으로 간단하게 레포지토리를 변경가능하도록 한다 */
    // 해당 bean 은 사용자들이 객체를 바꾸면서 선언해주어야한다 -> 결국 클라이언트가 계속해서 변경을 해주어야한다
    // 따라서, OCP 개방폐쇄 원칙에 문제가 생긴다 다형성을 이용해 객체지향적으로 만들었지만 결국 해치게 되는 아이러니한 현상이 발생
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    //     // return new JdbcMemberRepository( dataSource );
    //     // return new JdbcTemplateMemberRepository( dataSource );
    //     // return new JpaMemberRepository( em );
    //
    }
    //
    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }

}
