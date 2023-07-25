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
public class Insulin {
    @Id @GeneratedValue
    private long id;
    private long member_id; //foreign key
    private LocalDateTime write_date;
    private int amount;
}
