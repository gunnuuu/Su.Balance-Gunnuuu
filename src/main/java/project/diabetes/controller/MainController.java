package project.diabetes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/info")  //메인 페이지
    public String info(){
        return "info";
    }

    @GetMapping("/first") // 처음 로그인 데이터 받기
    public String about(){
        return "first";
    }

    @GetMapping("/calculator")  //인슐린 계산 페이지
    public String calculator(){
        return "calculator";
    }

    @GetMapping("/board")  //게시판 페이지
    public String board(){
        return "board";
    }

    @GetMapping("/record") //혈당일지 페이지
    public String main(){
        return "record";
    }

    @GetMapping("/news") // 뉴스 페이지
    public String shop(){
        return "news";
    }

}
