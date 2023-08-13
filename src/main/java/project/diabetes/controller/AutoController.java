package project.diabetes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import project.diabetes.service.AutoService;

import java.util.List;
import java.util.Map;

@Controller
public class AutoController {

    @Autowired
    AutoService autoService;

    @RequestMapping(value = "/ajax/autocomplete.do")
    public @ResponseBody Map<String, Object> autocomplete
            (@RequestParam Map<String, Object> paramMap) throws Exception{

        List<Map<String, Object>> resultList = autoService.autocomplete(paramMap);
        paramMap.put("resultList", resultList);

        return paramMap;
    }

}
