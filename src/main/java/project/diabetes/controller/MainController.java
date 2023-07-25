package project.diabetes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main1") //임시1
    public String main1(){
        return "main1";
    }

    @GetMapping("/main2") //임시2
    public String main2(){
        return "index";
    }

    @GetMapping("/main2/services")
    public String services(){
        return "services";
    }

    @GetMapping("/main2/about")
    public String about(){
        return "about";
    }

    @GetMapping("/main2/shop")
    public String shop(){
        return "shop";
    }

    @GetMapping("/main2/contact")
    public String contact(){
        return "contact";
    }


    // https://www.free-css.com/free-css-templates/page284/built-better
}
