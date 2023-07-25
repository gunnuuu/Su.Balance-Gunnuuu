package project.diabetes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main") //임시1
    public String main1(){
        return "main";
    }
}
