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
    /*@GetMapping("/companie")
    public String showCompanie(Model model) {
        var companies = companieRepository.findAll();
        model.addAttribute("comps", companies);
        return "page/companie";
    }*/
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
        try {
            Companie company = new Companie();
            company.setName(name);
            company.setActivityType(activityType);
            company.setAddress(address);
            company.setPhone(phone);

            companieRepository.save(company);

            return "redirect:/companie";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/companie";
        }

    }
    @GetMapping("/companie/edit")
    public String showEditCompanieForm(@RequestParam Long id, Model model) {
        Companie company = companieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
        model.addAttribute("companie", company);
        return "page/companieEdit";
    }

    @PostMapping("/companie/edit")
    public String editCompanie(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String activityType,
            @RequestParam String address,
            @RequestParam String phone) {
        try {
            Companie company = companieRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid ID"));

            company.setName(name);
            company.setActivityType(activityType);
            company.setAddress(address);
            company.setPhone(phone);

            companieRepository.save(company);
            return "redirect:/companie";
        }catch (Exception e) {
            e.printStackTrace();
            return "redirect:/companie";
        }

    }
    @GetMapping("/companie/delete")
    public String deleteCompanie(@RequestParam Long id) {
        try {
            companieRepository.deleteById(id);
            return "redirect:/companie";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/companie";
        }
    }
    @GetMapping("/companie")
    public String showCompanie(@RequestParam(required = false) String sort, Model model) {
        Iterable<Companie> companies;
        String sortDirection = (sort != null && sort.equals("asc")) ? "asc" : "desc";
        if ("asc".equals(sort)) {
            companies = companieRepository.findAllByOrderByCompanyIdAsc();
        } else if ("desc".equals(sort)) {
            companies = companieRepository.findAllByOrderByCompanyIdDesc();
        } else {
            companies = companieRepository.findAll();
            sortDirection = "asc";
        }
        model.addAttribute("comps", companies);
        model.addAttribute("sortDirection", sortDirection);
        return "page/companie";
    }

}