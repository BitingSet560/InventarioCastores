package com.examen.repository;

import com.examen.model.Historico;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository <Historico, Integer> {
    List<Historico> findByMovimiento_Nombre(String nombre);
}
