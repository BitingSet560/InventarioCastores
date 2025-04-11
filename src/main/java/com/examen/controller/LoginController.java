package com.examen.controller;

import com.examen.model.Usuario;
import com.examen.repository.UsuarioRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String correo,
                                 @RequestParam String contrasena,
                                 HttpSession session,
                                 Model model) {

        Usuario usuario = usuarioRepositorio.findByCorreo(correo);
        if (usuario != null && usuario.getContrasena().equals(contrasena) && usuario.getEstatus()) {
            session.setAttribute("usuario", usuario);
            model.addAttribute("usuario", usuario);
            model.addAttribute("titulo", "Inicio");
            model.addAttribute("contenido", "home.jsp");
            return "layout"; 
        } else {
            model.addAttribute("error", "Credenciales inválidas o usuario inactivo");
            return "login";
        }
    }

    @PostMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
