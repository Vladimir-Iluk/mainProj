package com.iluk.git.mainProj.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectHome() {
        return "redirect:/employers";
    }
}
