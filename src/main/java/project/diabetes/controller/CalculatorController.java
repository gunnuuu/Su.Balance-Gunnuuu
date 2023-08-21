package project.diabetes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")  //인슐린 계산 페이지
    public String calculator(){
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculate(Model model) {
        //사이트에서 name 이랑 g 가져오기 (여러개임)



        // ** 아마 food 를 list 에 넣고 반복문으로? **
        // food_db 에서 name 별 carbohydrate, protein, fat, category 추출

        // food_for_api_db 에 다 넣기
        // (id, name, g, carbohydrate, protein, fat, inputDate, category, memberId(미정))






        // 게이지값 동시에 갱신 !!

        // 경고문 갱신!!
        return "calculator";
    }


    @GetMapping("/test") //연관 검색어 테스트
    public String test(){
        return "test";
    }

}
