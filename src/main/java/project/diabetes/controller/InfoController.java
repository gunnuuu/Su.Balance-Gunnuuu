package project.diabetes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static project.diabetes.repository.RecordsRepository.glist;

@Controller
public class InfoController {
    @GetMapping("/info")
    public String getInfoPage(Model model) {
        model.addAttribute("glist", glist);
        return "info"; // info.html 템플릿으로 이동
    }
}
