package com.iluk.git.mainProj.controller;


import com.iluk.git.mainProj.data.Entitys.Companie;
import com.iluk.git.mainProj.data.Entitys.Employer;
import com.iluk.git.mainProj.data.Entitys.EmployerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class EmployerController {
    private final EmployerRepository employerRepository;

    public EmployerController(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }
    /*@GetMapping("/employer")
    public String showEmplyoer(Model model) {
        var employers = employerRepository.findAll();
        model.addAttribute("empls", employers);
        return "page/employer";
    }*/
    @GetMapping("/employer/add")
    public String showAddCompanieForm() {
        return "page/employerAdd";
    }

    @PostMapping("/employer/add")
    public String addCompanie(
            @RequestParam String lastName,
            @RequestParam String firstName,
            @RequestParam String middleName,
            @RequestParam String qualification,
            @RequestParam String activityType,
            @RequestParam String otherInfo,
            @RequestParam BigDecimal expectedSalary
            ) {
        try {

            Employer employer = new Employer();
            employer.setLastName(lastName);
            employer.setFirstName(firstName);
            employer.setMiddleName(middleName);
            employer.setQualification(qualification);
            employer.setActivityType(activityType);
            employer.setOtherInfo(otherInfo);
            employer.setExpectedSalary(expectedSalary);

            employerRepository.save(employer);

            return "redirect:/employer";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/employer";
        }
    }
    @GetMapping("/employer/edit")
    public String showEditEmployerForm(@RequestParam Long id, Model model) {
        Employer employer = employerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
        model.addAttribute("empl", employer);
        return "page/employerEdit";
    }

    @PostMapping("/employer/edit")
    public String editEmployer(
            @RequestParam Long id,
            @RequestParam String lastName,
            @RequestParam String firstName,
            @RequestParam String middleName,
            @RequestParam String qualification,
            @RequestParam String activityType,
            @RequestParam String otherInfo,
            @RequestParam BigDecimal expectedSalary) {
        try {
            Employer employer = employerRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid ID"));

            employer.setLastName(lastName);
            employer.setFirstName(firstName);
            employer.setMiddleName(middleName);
            employer.setQualification(qualification);
            employer.setActivityType(activityType);
            employer.setOtherInfo(otherInfo);
            employer.setExpectedSalary(expectedSalary);

            employerRepository.save(employer);
            return "redirect:/employer";
        }catch (Exception e) {
            e.printStackTrace();
            return "redirect:/companie";
        }

    }
    @GetMapping("/employer/delete")
    public String deleteEmployer(@RequestParam Long id) {
        try {
            employerRepository.deleteById(id);
            return "redirect:/employer";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/employer";
        }
    }
    @GetMapping("/employer")
    public String showEmplyoer(
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String search,
            Model model) {

        Iterable<Employer> employers;
        String sortDirection = (sort != null && sort.equals("asc")) ? "asc" : "desc";

        if (search != null && !search.isEmpty()) {
            employers = employerRepository.searchAcrossAllFields(search);
        } else if ("asc".equals(sort)) {
            employers = employerRepository.findAllByOrderByEmployerIdAsc();
        } else if ("desc".equals(sort)) {
            employers = employerRepository.findAllByOrderByEmployerIdDesc();
        } else {
            employers = employerRepository.findAll();
            sortDirection = "asc";
        }

        model.addAttribute("empls", employers);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("searchTerm", search);
        return "page/employer";
    }
}
