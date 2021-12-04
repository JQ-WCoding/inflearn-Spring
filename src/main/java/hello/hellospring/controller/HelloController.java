package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping ( "hello-string" )
    // http 에서 header 부분과 body 부분 중 응답 body 부분에 직접 넣겠다는 의미
    @ResponseBody
    public String helloString(@RequestParam ( "name" ) String name) {
        return "hello " + name; // "hello ~~~ " 직접 그대로 데이터만 넘겨주는 형식
    }

    @GetMapping ( "hello-api" )
    // JSON 반환이 기본
    @ResponseBody
    public Hello helloApi(@RequestParam ( "name" ) String name) {
        Hello hello = new Hello();
        hello.setName( name );

        // JSON 방식으로 파싱해서 객체를 값으로 넘겨줌
        // 객체가 오면 JSON 방식을 표준으로 변환하여 값을 넘겨준다
        // name key 와 ?name = abc 와 같이 abc 가 value 로 넘겨짐
        return hello;
        // 이후 http message converter 에서 JsonConverter 혹은 StringConverter 등을 확인하고 알맞게 조정하여 보낸다
        // 기본 객체처리 : MappingJackson2HttpMessageConverter
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
