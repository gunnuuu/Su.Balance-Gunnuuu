package project.diabetes.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@ToString
public class Food {

    @Id @GeneratedValue
    @Column(name="SEQ")
    private long id;
    private String category;
    @Column(name="SEARCH_WORD")
    private String name;
    private float carbohydrate;
    private float protein;
    private float fat;

}
