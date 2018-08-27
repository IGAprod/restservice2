package com.example.iga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping(value="/")
    public  String homepage(){
        return "test";
    }

}
