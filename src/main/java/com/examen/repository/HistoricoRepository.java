package com.examen.repository;

import com.examen.model.Historico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository <Historico, Integer> {
    
}
