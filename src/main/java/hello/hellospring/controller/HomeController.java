package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // 먼저 controller 내에서 해당 파일이 있는지 확인하고 없으면 static 폴더로 이동 -> 존재하기 때문에 해당 컨트롤러가 호출되고 반환하는걸 넘겨준다.
    @GetMapping ( "/" )
    public String home() {
        // home.jsp 이동
        return "home";
    }
}
