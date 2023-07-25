package project.diabetes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Board {

    @Id @GeneratedValue
    private long id;

    private String title;
    private String content; //나중에 String값 변경 요망
}
