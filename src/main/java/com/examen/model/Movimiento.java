package com.examen.model;
import jakarta.persistence.*;


@Entity
@Table(name = "Movimientos", schema = "dbo")
public class Movimiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMovimiento")
    private Byte id;

    @Column(nullable = false, length = 30, name = "Nombre")
    private String nombre;

    @Column(nullable = false, name = "estatus")
    private Boolean estatus;

    public Byte getId(Integer id){
        return this.id;
    }

    public Movimiento() {}

    // Getters y setters
    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }
}
