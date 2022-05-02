package com.example.MyTFE.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiabeticController {

    @GetMapping("/")
    public String home(){
        return"home";
    }
}
