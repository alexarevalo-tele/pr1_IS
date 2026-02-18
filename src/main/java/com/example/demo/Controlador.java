package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Controlador {
    @GetMapping(value ="/")
    public String vistaprincipal(Model m){
        m.addAttribute("mensaje", "Esta es la vista pricipal");
        return "vista";
    }

    @PostMapping("/datosusuario")
    public String metodo(Usuario usuario, HttpSession session) {
    // Spring llena automáticamente el objeto 'usuario' con los datos del formulario
    
    // Guardamos el objeto completo en la sesión HTTP
    session.setAttribute("usuarioSesion", usuario);
    
    // Imprimimos en consola para verificar (como hacías antes)
    System.out.println("Guardado en sesión: " + usuario.getNombre());
    
    return "vistausuario";
    }
    
}
