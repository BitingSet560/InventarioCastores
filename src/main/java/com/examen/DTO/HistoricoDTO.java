package com.examen.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.examen.model.Historico;

public class HistoricoDTO {
    private int idHistorico;
    private String usuario;
    private String producto;
    private String movimiento;
    private int cantidad;
    private String fechaFormateada;

    public HistoricoDTO(Historico h) {
        this.idHistorico = h.getIdHistorico();
        this.usuario = h.getUsuario().getNombre();
        this.producto = h.getProducto().getNombre();
        this.movimiento = h.getMovimiento().getNombre();
        this.cantidad = h.getCantidad();
        this.fechaFormateada = formatearFecha(h.getFecha());
    }

    private String formatearFecha(LocalDateTime fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return fecha.format(formatter);
    }

    // Getters
    public int getIdHistorico() { return idHistorico; }
    public String getUsuario() { return usuario; }
    public String getProducto() { return producto; }
    public String getMovimiento() { return movimiento; }
    public int getCantidad() { return cantidad; }
    public String getFechaFormateada() { return fechaFormateada; }
}
