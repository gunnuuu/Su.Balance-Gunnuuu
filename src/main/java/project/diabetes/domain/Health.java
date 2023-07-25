package project.diabetes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Health {

    @Id @GeneratedValue
    @Column(name = "health_id")
    private long id;
    private long member_id; //foreign key
    private int height;
    private int weight;
    private int glucose;


}
