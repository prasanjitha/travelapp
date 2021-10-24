package com.example.newproduct.controller;


import com.example.newproduct.entity.AddTravel;
import com.example.newproduct.repository.AddTravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/travels/")
public class TravelController {
    private final AddTravelRepository addTravelRepository;
    @Autowired
    public TravelController(AddTravelRepository addTravelRepository){
        this.addTravelRepository=addTravelRepository;
    }
    @GetMapping("signup")
    public String showSignUpForm(AddTravel addTravel) {
        return "add-travel";
    }
    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("travels", addTravelRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addTravel(@Valid AddTravel addTravel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-Travel";
        }

        addTravelRepository.save(addTravel);
        return "redirect:list";
    }
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        AddTravel addTravel = addTravelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid addTravel Id:" + id));
        model.addAttribute("addTravel", addTravel);
        return "update-addTravel";
    }

    @PostMapping("update/{id}")
    public String updateaddTravel(@PathVariable("id") long id, @Valid AddTravel addTravel, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            addTravel.setId(id);
            return "update-addTravel";
        }

        addTravelRepository.save(addTravel);
        model.addAttribute("travels", addTravelRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteTravel(@PathVariable("id") long id, Model model) {
        AddTravel addTravel = addTravelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid travel Id:" + id));
        addTravelRepository.delete(addTravel);
        model.addAttribute("travels", addTravelRepository.findAll());
        return "index";
    }
}
