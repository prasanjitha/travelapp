package com.example.newproduct.controller;

import com.example.newproduct.entity.Feedback;
import com.example.newproduct.repository.FeedbackRepository;
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
@RequestMapping("/feedbacks/")
public class FeedbackController {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackController(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Feedback feedback) {
        return "add-feedback";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("feedbacks", feedbackRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addFeedback(@Valid Feedback feedback, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-feedback";
        }

        feedbackRepository.save(feedback);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid feedback Id:" + id));
        model.addAttribute("feedbacks", feedback);
        return "update-feedback";
    }

    @PostMapping("update/{id}")
    public String updateFeedback(@PathVariable("id") long id, @Valid Feedback feedback, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            feedback.setId(id);
            return "update-feedback";
        }

        feedbackRepository.save(feedback);
        model.addAttribute("feedbacks", feedbackRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteFeedback(@PathVariable("id") long id, Model model) {
        Feedback feedback= feedbackRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid feedback Id:" + id));
        feedbackRepository.delete(feedback);
        model.addAttribute("feedbacks", feedbackRepository.findAll());
        return "index";
    }
}
