package com.example.Buoi03_trenlop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/text")
    public String HomeText(Model model){
        System.err.println("PhucTv");
        String name = "<h1>Phucs ok</h1>";
        model.addAttribute("namehtml", name);
        return "index.html";
    }
}