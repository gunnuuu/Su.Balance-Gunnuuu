package project.diabetes.controller;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class FoodFormListDto {
    private List<FoodForm> foodlist = new ArrayList<>();

}
