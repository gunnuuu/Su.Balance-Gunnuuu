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
import project.diabetes.domain.Member;
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

        Member member = new Member();
        //member.setIcr(10);

        if (member.getIcr() == null){
            return "calculatorTest";
        }

        // 게이지값 동시에 갱신 !! (inputDate 를 기준으로 같은날 뽑아오기)
        List<Integer> progressList= calculatorService.getProgress();
        model.addAttribute("progressList",progressList);

        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculate(Model model, String meal, @ModelAttribute(value = "FoodFormListDto") FoodFormListDto foodlist) {
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

        // api 정리
        int carbohydrateSum=0;
        Long member_id = 0L;

        //test 필요 23.08.29
        for (int i = 0;i<namelist.size();i++) {
            //food가 db에 존재하는지 확인
            if (!(calculatorService.checkFood(namelist.get(i)))){
                System.out.println("음식이 DB에 존재하지 않습니다.");
                continue;
            }

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
            carbohydrateSum += real_carbohydrate;
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
        // 승환이 한테 보내야하는 값: 탄수합(carbohydrateSum), 식사 여부(meal), member_id
        if (meal.equals("식사")){ // 식사면 Y 간식이면 N
            meal = "Y";
        } else {
            meal = "N";
        }
        System.out.println("carbohydrateSum = " + carbohydrateSum); // 수정해야됨
        System.out.println("meal = " + meal);
        System.out.println("member_id = " + member_id);


        return "/calculator";
    }

    @PostMapping("/calculatorTest")
    public String calculateTest(Model model, @ModelAttribute(value = "FoodFormListDto") FoodFormListDto foodlist) {
        //사이트에서 name 이랑 g 가져오기 (여러개임)

        List<String> namelist = new ArrayList<>();
        List<Integer> gramlist = new ArrayList<>();

        for (int i=0;i<foodlist.getFoodlist().size();i++){
            namelist.add(foodlist.getFoodlist().get(i).getName());
            gramlist.add(foodlist.getFoodlist().get(i).getGram());
        }
        // namelist, gramlist 분리 성공!!

        int carbohydrateSum = 0;

        //test 필요 23.08.29
        for (int i = 0;i<namelist.size();i++) {
            //food가 db에 존재하는지 확인
            if (!(calculatorService.checkFood(namelist.get(i)))){
                System.out.println("음식이 DB에 존재하지 않습니다.");
                continue;
            }

            // food_db 에서 name 별 carbohydrate 추출
            Food food = calculatorService.findByName(namelist.get(i));

            float food_carbohydrate = food.getCarbohydrate(); //100 그램당 탄수화물
            int food_gram = gramlist.get(i);

            // gram 에 맞춰서 탄수화물 계산
            float real_carbohydrate = (food_carbohydrate / 100) * food_gram;
            carbohydrateSum += real_carbohydrate;
        }
        System.out.println("carbohydrateSum = " + carbohydrateSum);

        int icr=0;
        model.addAttribute("icr", icr);

        return "/info";
    }


    @GetMapping("/test") //연관 검색어 테스트
    public String test(){
        return "test";
    }

}
