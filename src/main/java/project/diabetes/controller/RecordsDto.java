package project.diabetes.controller;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.diabetes.domain.RecordsEntity;

@Getter
@Setter
@NoArgsConstructor
public class RecordsDto {

    private Integer amount;
    private Integer glucose;


    public RecordsDto(Integer amount, Integer glucose) {
        this.amount = amount;
        this.glucose = glucose;
    }

    @Override
    public String toString() {
        return  amount + "," + glucose;
    }

    public RecordsEntity toEntity() {
        return new RecordsEntity(this.amount, this.glucose);
    }

}
