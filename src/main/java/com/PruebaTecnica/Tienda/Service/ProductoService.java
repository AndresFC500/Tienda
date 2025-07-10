package com.PruebaTecnica.Tienda.Service;


import com.PruebaTecnica.Tienda.Model.Producto;
import com.PruebaTecnica.Tienda.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Comparator;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto venderProducto(Long id, int cantidad) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        if (producto.getCantidadActual() < cantidad) {
            throw new RuntimeException("Stock insuficiente");
        }
        producto.setCantidadActual(producto.getCantidadActual() - cantidad);
        producto.setUnidadesVendidas(producto.getUnidadesVendidas() + cantidad);
        return productoRepository.save(producto);
    }

    public Producto pedirProducto(Long id, int cantidad) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setCantidadActual(producto.getCantidadActual() + cantidad);
        return productoRepository.save(producto);
    }

    public double calcularTotalVentas() {
        return productoRepository.findAll().stream()
                .mapToDouble(p -> p.getPrecioFinal() * p.getUnidadesVendidas())
                .sum();
    }

    public double calcularPromedioVentas() {
        int totalUnidades = productoRepository.findAll().stream()
                .mapToInt(Producto::getUnidadesVendidas)
                .sum();
        return totalUnidades == 0 ? 0 : calcularTotalVentas() / totalUnidades;
    }

    public Optional<Producto> productoMasVendido() {
        return productoRepository.findAll().stream()
                .max(Comparator.comparing(Producto::getUnidadesVendidas));
    }

    public Optional<Producto> productoMenosVendido() {
        return productoRepository.findAll().stream()
                .min(Comparator.comparing(Producto::getUnidadesVendidas));
    }
}

