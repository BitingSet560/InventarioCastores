package com.examen;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {
    @GetMapping("/Prueba")
    public String inicio() {
        return "Spring Boot está corriendo";
    }

    @GetMapping("/saludo")
    public String saludo() {
        return "¡Saludos desde el backend! :D";
    }
}
