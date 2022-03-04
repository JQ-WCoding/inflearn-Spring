package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// Spring Container 에 MemberController 를 생성해서 넣어두고 관리한다
@Controller
public class MemberController {

    private final MemberService memberService;

    // 연결과정
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 스프링 빈을 등록하는 2가지 방법
    // 1. 컴포넌트 스캔 방법 (@Component) -> HelloSpringApplication 를 포함한 하위의 패키지들만 -> Spring 이 찾아서 등록시킨다
    // 2. 자바 코드로 직접 주입


    // xml 로 설정도 했었지만 최근에는 잘 사용하지 않음

    // DI 에는 생성자, setter, 필드 주입(@Autowired) 3가지 방법이 있다.
    // 필드 주입의 경우 바꿔치기가 힘들다.
    // setter 주입의 경우 바꿔치기에서 오류가 생길 경향이 크다. -> 아무 개발자나 setter 를 통해 변경해버릴 수 있다.
    // 생성자를 통해 주입을 하면 처음에 세팅될 때, 만들어진다.

    @GetMapping ( "/members/new" )
    public String createForm() {
        return "members/createMemberForm";
    }

    // 같은 url을 사용하지만, post와 get을 구분지어 url 다양한 활용을 줄인다.
    @PostMapping ( "/members/new" )
    public String create(MemberForm memberForm) {
        Member member = new Member();
        member.setName( memberForm.getName() );

        memberService.join( member );

        return "redirect:/";
    }

    @GetMapping ( "/members" )
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute( "members", members );
        return "members/memberList";
    }
}
