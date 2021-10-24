package com.example.newproduct.controller;
import javax.validation.Valid;

import com.example.newproduct.entity.Driver;
import com.example.newproduct.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drivers/")
public class DriverController {
    private final DriverRepository driverRepository;

    @Autowired
    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Driver driver) {
        return "add-driver";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("drivers", driverRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addDriver(@Valid Driver driver, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-driver";
        }

        driverRepository.save(driver);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid driver Id:" + id));
        model.addAttribute("driver", driver);
        return "update-driver";
    }

    @PostMapping("update/{id}")
    public String updateDriver(@PathVariable("id") long id, @Valid Driver driver, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            driver.setId(id);
            return "update-driver";
        }

        driverRepository.save(driver);
        model.addAttribute("drivers", driverRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteDriver(@PathVariable("id") long id, Model model) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid driver Id:" + id));
        driverRepository.delete(driver);
        model.addAttribute("drivers", driverRepository.findAll());
        return "index";
    }
}
