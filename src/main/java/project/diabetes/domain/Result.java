package project.diabetes.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Result {

    @Id@GeneratedValue
    @Column(name="result_id")
    private Long id;
    private int amount;
    private int glucose;
    private int carbohydrateSum;
    private Integer icr;
    private int goal;
    private Long member_id;

}
