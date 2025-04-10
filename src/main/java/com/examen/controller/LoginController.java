package com.examen.controller;

import com.examen.model.Usuario;
import com.examen.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @GetMapping("/")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String correo,
                                 @RequestParam String contrasena,
                                 Model model) {
        Usuario usuario = usuarioRepositorio.findByCorreo(correo);
        if (usuario != null && usuario.getContrasena().equals(contrasena) && usuario.getEstatus()) {
            model.addAttribute("usuario", usuario);
            return "home"; 
        } else {
            model.addAttribute("error", "Credenciales inválidas o usuario inactivo");
            return "login";
        }
    }
}
