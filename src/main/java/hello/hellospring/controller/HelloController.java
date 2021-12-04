package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping ( "hello-mvc" )
    // 파라미터 name 을 요구 -> required = false 를하면 필요없다는 뜻
    public String helloMvc(@RequestParam ( name = "name", required = false ) String name, Model model) {
        // "name" key , 문자열 name 이 value
        model.addAttribute( "name", name );
        // hello-template 파일로 이동 -> template 엔진을 통해 변환 과정을 거친 html 파일을 넘겨준다
        return "hello-template";
    }
}
