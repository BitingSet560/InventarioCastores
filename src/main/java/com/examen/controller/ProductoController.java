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
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private HistoricoRepository historicoRepository;
    @Autowired
    private MovimientoRepository movimientoRepository;

    @GetMapping("/productos")
    public String mostrarProductos( Model model,
                                    HttpSession session) {
        List<Producto> lista = productoRepository.findAll();
        model.addAttribute("titulo", "Producttos");
        model.addAttribute("contenido", "productos.jsp");
        model.addAttribute("productos", lista);
        return "layout"; 
    }

    @PostMapping("/agregarStock")
    public String agregarStock(
            @RequestParam("idProducto") Integer idProducto,
            @RequestParam("cantidad") Integer cantidad,
            HttpSession session,
            RedirectAttributes redirectAttributes)  {

        Optional<Producto> optionalProducto = productoRepository.findById(idProducto);
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            int cantidadStock = producto.getCantidad();
            if(cantidad > cantidadStock){
                //Actualizar la cantidad
                producto.setCantidad(cantidad);
                productoRepository.save(producto);

                // Guardar en el histórico
                Historico h = new Historico();
                h.setUsuario(usuario);
                h.setProducto(producto);

                Movimiento movimiento = movimientoRepository.findById(1).orElse(null);
                h.setMovimiento(movimiento);
                h.setCantidad(cantidad);
                h.setFecha(LocalDateTime.now());

                historicoRepository.save(h);

                redirectAttributes.addFlashAttribute("mensaje", "✅ Stock actualizado correctamente.");
            }
            else{
                redirectAttributes.addFlashAttribute("mensaje", "❌ No puede ingresar un numero menor al stock actual.");
            }
        } else {
            redirectAttributes.addFlashAttribute("error", " ❌ Producto no encontrado.");
        }

        return "redirect:/productos";
    }


    @PostMapping("/activarDesactivarProducto")
    public String activarDesactivarProducto(
            @RequestParam("idProducto") Integer idProducto,
            RedirectAttributes redirectAttributes) 
    {
        Optional<Producto> optionalProducto = productoRepository.findById(idProducto);
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            Boolean estatus = producto.getEstatus();
            producto.setEstatus(!estatus);
            productoRepository.save(producto);
            redirectAttributes.addFlashAttribute("mensaje", "✅ Estatus actualizado correctamente.");
        }
        else {
            redirectAttributes.addFlashAttribute("error", "❌ Producto no encontrado.");
        }

        return "redirect:/productos";
    }

    @PostMapping("/agregarProducto")
    public String agregarProducto(@RequestParam String nombre,  Model model) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setCantidad(0);
        producto.setEstatus(true); 
        productoRepository.save(producto);
        
        model.addAttribute("mensaje", "✅ Producto agregado correctamente.");
        
        return "redirect:/productos";
    }
}
