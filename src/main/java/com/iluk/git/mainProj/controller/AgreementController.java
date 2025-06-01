package com.iluk.git.mainProj.controller;


import com.iluk.git.mainProj.data.Entitys.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class AgreementController {
    private final AgreementRepository agreementRepository;
    private final CompanieRepository companieRepository;
    private final EmployerRepository employerRepository;
    public AgreementController(AgreementRepository agreementRepository, CompanieRepository companieRepository, EmployerRepository employerRepository) {

        this.agreementRepository = agreementRepository;
        this.companieRepository = companieRepository;
        this.employerRepository = employerRepository;
    }
    /*@GetMapping("/agreement")
    public String showAgreement(Model model) {
        var agreements = agreementRepository.findAll();
        model.addAttribute("agreementsList", agreements);
        return "page/agreement";
    }*/
    @GetMapping("/agreement/add")
    public String showAddAgreementForm(Model model) {
        model.addAttribute("empls", employerRepository.findAll());
        model.addAttribute("comps", companieRepository.findAll());
        return "page/agreementAdd";
    }


    @PostMapping("/agreement/add")
    public String addAgreement(
            @RequestParam Long employerId,
            @RequestParam Long companyId,
            @RequestParam String pos,
            @RequestParam BigDecimal commission) {
        try{
            Employer employer = employerRepository.findById(employerId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid employer ID"));

            Companie company = companieRepository.findById(companyId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid company ID"));

            Agreement agreement = new Agreement();
            agreement.setEmpl(employer);
            agreement.setCompany(company);
            agreement.setPos(pos);
            agreement.setCommission(commission);

            agreementRepository.save(agreement);

            return "redirect:/agreement";

        }catch (Exception e) {
            e.printStackTrace();
            return "redirect:/employer";
        }

    }
    @GetMapping("/agreement/edit")
    public String showEditAgreementForm(@RequestParam Long id, Model model) {
        Agreement agreement = agreementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
        model.addAttribute("agreement", agreement);
        model.addAttribute("empls", employerRepository.findAll());
        model.addAttribute("comps", companieRepository.findAll());
        return "page/agreementEdit";
    }

    @PostMapping("/agreement/edit")
    public String editAgreement(
            @RequestParam Long id,
            @RequestParam Long employerId,
            @RequestParam Long companyId,
            @RequestParam String pos,
            @RequestParam BigDecimal commission) {
        try {
            Agreement agreement = agreementRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid ID"));

            Employer employer = employerRepository.findById(employerId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid employer ID"));
            Companie company = companieRepository.findById(companyId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid company ID"));

            agreement.setEmpl(employer);
            agreement.setCompany(company);
            agreement.setPos(pos);
            agreement.setCommission(commission);

            agreementRepository.save(agreement);
            return "redirect:/agreement";
        }catch (Exception e) {
            e.printStackTrace();
            return "redirect:/companie";
        }

    }
    @GetMapping("/agreement/delete")
    public String deleteAgreement(@RequestParam Long id) {
        try {
            agreementRepository.deleteById(id);
            return "redirect:/agreement";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/agreement";
        }
    }
    @GetMapping("/agreement")
    public String showAgreement(@RequestParam(required = false) String sort, Model model) {
        Iterable<Agreement> agreements;
        String sortDirection = (sort != null && sort.equals("asc")) ? "asc" : "desc";
        if ("asc".equals(sort)) {
            agreements = agreementRepository.findAllByOrderByAgreementIdAsc();
        } else if ("desc".equals(sort)) {
            agreements = agreementRepository.findAllByOrderByAgreementIdDesc();
        } else {
            agreements = agreementRepository.findAll();
            sortDirection = "asc";
        }
        model.addAttribute("agreementsList", agreements);
        model.addAttribute("sortDirection", sortDirection);
        return "page/agreement";
    }

}