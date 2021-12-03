package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping ( "hello" )
    public String hello(Model model) {
        // data attribute 에 hello 를 넣어주기
        model.addAttribute( "data", "hello!" );
        // templates 폴더 내의 해당 파일을 찾게 해준다 -> 반환값은 파일명
        // 기본 루트
        // 'resources: templates/ ' + {viewName} + '.html'
        return "hello";

        // springboot dev tool 라이브러리를 통해 쉽게 사용하는 법 찾아보기
    }
}
