package project.diabetes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecordController {
    @GetMapping("/record") //혈당일지 페이지
    public String main(){
        return "record";
    }
}
