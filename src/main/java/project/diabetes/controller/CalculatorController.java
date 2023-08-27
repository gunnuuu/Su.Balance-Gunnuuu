package project.diabetes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.diabetes.domain.Food;
import project.diabetes.domain.FoodRecord;
import project.diabetes.service.CalculatorService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("/calculator")  //인슐린 계산 페이지
    public String calculator(Model model){

        // 게이지값 동시에 갱신 !! (inputDate 를 기준으로 같은날 뽑아오기)
        List<Integer> progressList= calculatorService.getProgress();
        model.addAttribute("progressList",progressList);

        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculate(Model model, @ModelAttribute(value = "FoodFormListDto") FoodFormListDto foodlist) {
        //사이트에서 name 이랑 g 가져오기 (여러개임)

        List<String> namelist = new ArrayList<>();
        List<Integer> gramlist = new ArrayList<>();
        // 경고문을 위한 list
        List<String> catelist = new ArrayList<>();
        // 걍고문을 위한 수치
        int fatSum = 0;


        for (int i=0;i<foodlist.getFoodlist().size();i++){
            namelist.add(foodlist.getFoodlist().get(i).getName());
            gramlist.add(foodlist.getFoodlist().get(i).getGram());
        }
        // namelist, gramlist 분리 성공!!


        for (int i = 0;i<namelist.size();i++) {
            // food_db 에서 name 별 carbohydrate, protein, fat, category 추출
            Food food = calculatorService.findByName(namelist.get(i));

            float food_carbohydrate = food.getCarbohydrate(); //100 그램당 탄수화물
            float food_protein = food.getProtein(); //100 그램당 단백질
            float food_fat = food.getFat(); //100 그랜당 지방
            String food_category = food.getCategory();
            catelist.add(food_category);

            String food_name = food.getName();
            int food_gram = gramlist.get(i);

            // gram 에 맞춰서 탄단지 계산
            float real_carbohydrate = (food_carbohydrate / 100) * food_gram;
            float real_protein = (food_protein / 100) * food_gram;
            float real_fat = (food_fat / 100) * food_gram;

            fatSum += real_fat;

            // food_record_db 에 다 넣기
            // (id, name, gram, carbohydrate, protein, fat, inputDate, category, memberId(미정))
            FoodRecord foodRecord = new FoodRecord(food_name, food_gram, real_carbohydrate, real_protein, real_fat, food_category);
            calculatorService.saveFoodRecord(foodRecord);
        }

        // 게이지값 동시에 갱신 !! (inputDate 를 기준으로 같은날 뽑아오기)
        List<Integer> progressList= calculatorService.getProgress();
        model.addAttribute("progressList",progressList);

        // 경고문 갱신!! (category 로?)
        // catelist 에 채소가 없으면 경고문 + fatSum 의 값이 40 넘으면 경고문
        String warning = calculatorService.warning(catelist, fatSum);
        model.addAttribute("warning",warning);

        // api 값 보내주기



        return "/calculator";
    }


    @GetMapping("/test") //연관 검색어 테스트
    public String test(){
        return "test";
    }

}
