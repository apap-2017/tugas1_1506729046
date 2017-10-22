package com.example.tugas1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController{

    @RequestMapping("/")
    public String index(){
        return "view/index";
    }

}
