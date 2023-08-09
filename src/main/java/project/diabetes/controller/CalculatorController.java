package project.diabetes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")  //인슐린 계산 페이지
    public String calculator(){
        return "calculator";
    }


}
