package project.diabetes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OriginalController {

    @GetMapping("/original_dept") // 원본1
    public String original_dept(){
        return "original/original_dept";
    }

    @GetMapping("/original_index") // 원본2
    public String original_index(){
        return "original/original_index";
    }


}
