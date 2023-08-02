package project.diabetes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") //로그인 페이지
    public String home(){
        return "logIn";
    }

}
