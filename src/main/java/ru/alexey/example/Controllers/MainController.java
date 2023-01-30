package ru.alexey.example.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.alexey.example.DAOs.EventDAO;

@Controller
public class MainController {

    private final EventDAO eventDAO;
    @Autowired
    public MainController(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("events", eventDAO.index());
        return "index";
    }
    @GetMapping("/new")
    public String newEvent(){
        return "new";
    }

}