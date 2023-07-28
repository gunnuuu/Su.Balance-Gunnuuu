package project.diabetes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @GetMapping("/first")
    public String about(){
        return "first";
    }

    @GetMapping("/news")
    public String shop(){
        return "news";
    }

}
