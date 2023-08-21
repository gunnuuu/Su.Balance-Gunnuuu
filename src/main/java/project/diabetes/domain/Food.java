package project.diabetes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Food { // food_record

    @Id @GeneratedValue
    @Column(name="food_id")
    private Long id;

    // private Long memberId;
    private String name;
    private int g;
    private float carbohydrate;
    private float protein;
    private float fat;
    private LocalDateTime inputDate;
    private String category;

}
