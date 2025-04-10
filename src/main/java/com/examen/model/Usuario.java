package com.examen.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios", schema = "dbo")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String correo;

    @Column(name = "contrasena", nullable = false, length = 25)
    private String contrasena;

    @Column(name = "idRol", nullable = false)
    private Byte idRol;

    @Column(nullable = false)
    private Boolean estatus;
}
