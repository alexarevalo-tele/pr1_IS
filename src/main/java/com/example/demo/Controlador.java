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

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;



@Controller
public class Controlador {
    @GetMapping(value ="/")
    public String vistaprincipal(Model m){
        m.addAttribute("mensaje", "Esta es la vista pricipal");
        return "vista";
    }

    @PostMapping(value = "/datosusuario")
    public String metodo(HttpServletRequest req, HttpServletResponse response){
    String email = req.getParameter("email");
    String nombre = req.getParameter("nombre");
    String apellidos = req.getParameter("apellidos");
    
    Usuario usuario = new Usuario();
    usuario.setEmail(email);
    usuario.setNombre(nombre);
    usuario.setApellidos(apellidos);

    //Obtenemos la sesión desde el request (true para que la cree si no existe)
    HttpSession sesion = req.getSession(true);

    //Guardamos el objeto usuario en la sesión con el atributo "usuario"
    sesion.setAttribute("usuarioSesion", usuario);

    Cookie cookieNombre = new Cookie("user_cookie", nombre);
    cookieNombre.setMaxAge(60 * 60 * 24 * 365); // Segundos en un año
    cookieNombre.setPath("/"); // Disponible en toda la web
    response.addCookie(cookieNombre);
        
    System.out.println("Datos de la sesion: " +email + ", " + nombre + ", " + apellidos);

    return "vistausuario";
    }


    @GetMapping("/datosusuario")
    public String leerCookie(HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("user_cookie".equals(c.getName())) {
                System.out.println("Cookie encontrada en el servidor: " + c.getValue());
            }
        }
    }
    return "vistausuario";
    }
    
    
}
