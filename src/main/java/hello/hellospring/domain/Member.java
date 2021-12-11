package hello.hellospring.domain;

import javax.persistence.*;

@Entity // jpa 가 관리하는 entity
public class Member {
    // id 는 임의의 값 (시스템이 가지고 있는 데이터 구분용 아이디)
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
