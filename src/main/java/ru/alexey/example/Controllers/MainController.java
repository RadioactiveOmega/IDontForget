package ru.alexey.example.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/new")
    public String newEvent(){
        return "new";
    }

}