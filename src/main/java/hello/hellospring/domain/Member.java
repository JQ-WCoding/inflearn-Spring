package hello.hellospring.domain;

import javax.persistence.*;

@Entity // jpa 가 관리하는 entity
// DAO 같은 행동
public class Member {
    // id 는 임의의 값 (시스템이 가지고 있는 데이터 구분용 아이디)
    @Id
    // DB의 IDENTITY 이용 -> 기본키 생성을 DB에 위임
    // DB가 알아서 AUTO INCREMENT 해준다
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    @Column ( name = "ID" )
    private Long id;

    // 기본적으로 @Column 을 지정해주지 않으면 대소문자 구분하지 않고 같은 컬럼을 바라본다 -> 하지만, 대소문자 구분을 하는 sql 의 경우에는 대소문자의 구분도 확실하게 해주어야 한다.
    private String name;

    // Getter Setter
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
