package com.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examen.model.Usuario;;;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByCorreo(String correo);
}
