package com.examen.controller;

import com.examen.model.Usuario;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String mostrarHome(Model model, HttpSession session) {
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    
    if (usuario == null) {
        return "redirect:/";
    }
    model.addAttribute("titulo", "Inicio");
    model.addAttribute("contenido", "home.jsp");
    model.addAttribute("usuario", session.getAttribute("usuario"));
    return "layout";
}
}
