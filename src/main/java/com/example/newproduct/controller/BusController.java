package com.example.newproduct.controller;

import com.example.newproduct.entity.Bus;
import com.example.newproduct.repository.BusRepository;
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
@RequestMapping("/buses/")
public class BusController {
    private final BusRepository busRepository ;

    @Autowired
    public BusController(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Bus bus) {
        return "add-bus";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("buses", busRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addBus(@Valid Bus bus, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-bus";
        }

        busRepository.save(bus);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid bus Id:" + id));
        model.addAttribute("bus", bus);
        return "update-bus";
    }

    @PostMapping("update/{id}")
    public String updateBus(@PathVariable("id") long id, @Valid Bus bus, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            bus.setId(id);
            return "update-bus";
        }

        busRepository.save(bus);
        model.addAttribute("buses", busRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteBus(@PathVariable("id") long id, Model model) {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid bus Id:" + id));
        busRepository.delete(bus);
        model.addAttribute("buses", busRepository.findAll());
        return "index";
    }

}
