package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProjectApplication {

    public static void main(String[] args) {
        // tomcat 서버 내장 -> 자체적으로 띄우면서 스프링부트를 실행
        SpringApplication.run( SpringProjectApplication.class, args );
    }

}
