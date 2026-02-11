package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Controlador {
    @GetMapping(value ="/")
    public String vistaprincipal(Model m){
        m.addAttribute("mensaje", "Esta es la vista pricipal");
        return "vista";
    }

    @PostMapping(value = "/datosusuario")
    public String metodo(HttpServletRequest req) {
    String email = req.getParameter("email");
    String nombre = req.getParameter("nombre");
    
    System.out.println(email + ", " + nombre);
    
    return "vista";
    }
    
}
