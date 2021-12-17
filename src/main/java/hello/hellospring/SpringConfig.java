package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

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
    // @Bean
    // public MemberRepository memberRepository() {
    //     // return new MemoryMemberRepository();
    //     // return new JdbcMemberRepository( dataSource );
    //     // return new JdbcTemplateMemberRepository( dataSource );
    //     // return new JpaMemberRepository( em );
    //
    // }
    //
    // @Bean
    // public TimeTraceAop timeTraceAop() {
    //     return new TimeTraceAop();
    // }

}
