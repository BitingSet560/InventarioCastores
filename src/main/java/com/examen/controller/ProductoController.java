package com.examen.controller;
import com.examen.model.Producto;
import com.examen.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
@Controller
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/productos")
    public String mostrarProductos(Model model) {
        List<Producto> lista = productoRepository.findAll();
        model.addAttribute("productos", lista);
        return "productos"; 
    }

    @GetMapping("/salidas")
    public String mostrarProductosActivos(Model model) {
        List<Producto> lista = productoRepository.findByEstatusTrue();
        model.addAttribute("productos", lista);
        return "salidas"; 
    }

    @PostMapping("/agregarStock")
    public String agregarStock(
            @RequestParam("idProducto") Integer idProducto,
            @RequestParam("cantidad") Integer cantidad,
            RedirectAttributes redirectAttributes)  {

        Optional<Producto> optionalProducto = productoRepository.findById(idProducto);

        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            int cantidadStock = producto.getCantidad();
            if(cantidad > cantidadStock){
                producto.setCantidad(cantidad);
                productoRepository.save(producto);
                redirectAttributes.addFlashAttribute("mensaje", "Stock actualizado correctamente.");
            }
            else{
                redirectAttributes.addFlashAttribute("mensaje", "No puede ingresar un numero menor al stock actual.");
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "Producto no encontrado.");
        }

        return "redirect:/productos";
    }

    @PostMapping("/restarStock")
    public String restarStock(
            @RequestParam("idProducto") Integer idProducto,
            @RequestParam("cantidad") Integer cantidad,
            RedirectAttributes redirectAttributes)  {

        Optional<Producto> optionalProducto = productoRepository.findById(idProducto);

        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            int cantidadStock = producto.getCantidad();
            if(cantidad <= cantidadStock){
                producto.setCantidad(producto.getCantidad() - cantidad);
                productoRepository.save(producto);
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
            redirectAttributes.addFlashAttribute("error", "Producto no encontrado.");
        }

        return "redirect:/productos";
    }
}
