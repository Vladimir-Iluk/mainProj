package com.iluk.git.mainProj.controller;


import com.iluk.git.mainProj.data.AgreementRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgreementController {
    private final AgreementRepository agreementRepository;

    public AgreementController(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }
    @GetMapping("/agreement")
    public String showAgreement(Model model) {
        var agreements = agreementRepository.findAll();
        model.addAttribute("agreements", agreements);
        return "/agreement";
    }
}