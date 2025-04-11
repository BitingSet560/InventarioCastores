package com.examen.controller;

import com.examen.DTO.HistoricoDTO;
import com.examen.model.Historico;
import com.examen.repository.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HistoricoController {
    @Autowired
    private HistoricoRepository historicoRepository;

    @GetMapping("/historico")
    public String mostrarHistorico(Model model) {
        List<Historico> lista = historicoRepository.findAll();
        
        List<HistoricoDTO> listaDTO = lista.stream()
            .map(HistoricoDTO::new)
            .toList();
        model.addAttribute("titulo", "Inicio");
        model.addAttribute("contenido", "historico.jsp");
        model.addAttribute("historico", listaDTO);
        return "layout";

    }
    
}
