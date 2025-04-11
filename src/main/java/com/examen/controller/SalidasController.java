package com.examen.controller;
import com.examen.model.Producto;
import com.examen.model.Usuario;
import com.examen.model.Historico;
import com.examen.model.Movimiento;
import com.examen.repository.HistoricoRepository;
import com.examen.repository.MovimientoRepository;
import com.examen.repository.ProductoRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class SalidasController {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private HistoricoRepository historicoRepository;
    @Autowired
    private MovimientoRepository movimientoRepository;

    @GetMapping("/salidas")
    public String mostrarProductosActivos(Model model) {
        List<Producto> lista = productoRepository.findByEstatusTrue();
        model.addAttribute("titulo", "Salidas");
        model.addAttribute("contenido", "salidas.jsp");
        model.addAttribute("productos", lista);
        return "layout"; 
    }

    @PostMapping("/restarStock")
    public String restarStock(
            @RequestParam("idProducto") Integer idProducto,
            @RequestParam("cantidad") Integer cantidad,
            HttpSession session,
            RedirectAttributes redirectAttributes)  {

        Optional<Producto> optionalProducto = productoRepository.findById(idProducto);
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            int cantidadStock = producto.getCantidad();
            if(cantidad <= cantidadStock){
                producto.setCantidad(producto.getCantidad() - cantidad);
                productoRepository.save(producto);

                // Guardar en el histórico
                Historico h = new Historico();
                h.setUsuario(usuario);
                h.setProducto(producto);

                Movimiento movimiento = movimientoRepository.findById(2).orElse(null);
                h.setMovimiento(movimiento);
                h.setCantidad(cantidad);
                h.setFecha(LocalDateTime.now());

                historicoRepository.save(h);

                redirectAttributes.addFlashAttribute("mensaje", "Stock actualizado correctamente.");
            }
            else{
                redirectAttributes.addFlashAttribute("mensaje", "No puede sacar una cantidad mayor al stock del producto.");
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "Producto no encontrado.");
        }

        return "redirect:/salidas";
    }
}
