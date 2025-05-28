package com.iluk.git.mainProj.controller;


import com.iluk.git.mainProj.data.Entitys.Companie;
import com.iluk.git.mainProj.data.Entitys.CompanieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/companie/add")
    public String showAddCompanieForm() {
        return "page/companieAdd";
    }

    @PostMapping("/companie/add")
    public String addCompanie(
            @RequestParam String name,
            @RequestParam String activityType,
            @RequestParam String address,
            @RequestParam String phone) {

        Companie company = new Companie();
        company.setName(name);
        company.setActivityType(activityType);
        company.setAddress(address);
        company.setPhone(phone);

        companieRepository.save(company);

        return "redirect:/companie";
    }
}