package ru.alexey.example.Controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.alexey.example.DAOs.EventDAO;
import ru.alexey.example.Models.Event;

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
    public String newEvent(@ModelAttribute("event") Event event){
        return "new";
    }
    @PostMapping("/")
    public String create(@ModelAttribute("event") @Valid Event event, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "new";
        eventDAO.create(event);
        return "redirect:/";
    }

}