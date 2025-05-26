package com.iluk.git.mainProj.controller;


import com.iluk.git.mainProj.data.CompanieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanieController {
    private final CompanieRepository companieRepository;

    public CompanieController(CompanieRepository companieRepository) {
        this.companieRepository = companieRepository;
    }
    @GetMapping("/companie")
    public String showCompanie(Model model) {
        var companies = companieRepository.findAll();
        model.addAttribute("comps", companies);
        return "page/companie";
    }
}