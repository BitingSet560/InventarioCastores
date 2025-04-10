package com.examen.repository;

import com.examen.model.Producto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByEstatusTrue();
}
