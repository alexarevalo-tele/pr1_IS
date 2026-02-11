package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {
    @GetMapping(value ="/")
    public String vistaprincipal(Model m){
        m.addAttribute("mensaje", "Esta es la vista pricipal");
        return "vista";
    }
    
}
