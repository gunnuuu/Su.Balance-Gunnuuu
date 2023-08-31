package project.diabetes.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Getter
@Setter
@ToString
@Table(name = "records")
public class RecordsEntity {

    @Id @GeneratedValue
    @Column(name = "record_id")
    private Long id;

    private Integer amount;
    private Integer glucose;
    private int carbohydrateSum;
    private Long member_id;


    public RecordsEntity() {
    }

    public RecordsEntity(Integer amount, Integer glucose) {
        this.amount = amount;
        this.glucose = glucose;
    }

    @Override
    public String toString() {
        return  amount + "," + glucose;
    }

    public String split(String s) {
        return Arrays.toString(s.split(","));
    }
}