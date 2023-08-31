package project.diabetes.controller;


import project.diabetes.domain.RecordsEntity;

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
        return new RecordsEntity(amount, glucose);
    }

}
