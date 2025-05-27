package com.iluk.git.mainProj.controller;


import com.iluk.git.mainProj.data.Entitys.EmployerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployerController {
    private final EmployerRepository employerRepository;

    public EmployerController(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }
    @GetMapping("/employer")
    public String showEmplyoer(Model model) {
        var employers = employerRepository.findAll();
        model.addAttribute("employers", employers);
        return "/employer";
    }
}
