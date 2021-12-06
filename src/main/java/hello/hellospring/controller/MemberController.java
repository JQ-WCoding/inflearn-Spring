package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
