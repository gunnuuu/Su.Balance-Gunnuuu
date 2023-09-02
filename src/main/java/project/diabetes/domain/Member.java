package project.diabetes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private long id;
    private String name;
    private int age;
    private char sex;
    private Integer icr;
    private float height;
    private float weight;
    private float goal;

    private String userId;

}
