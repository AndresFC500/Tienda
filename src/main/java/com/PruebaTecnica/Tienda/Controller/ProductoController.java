package com.PruebaTecnica.Tienda.Controller;

import com.PruebaTecnica.Tienda.Model.PedidoRequest;
import com.PruebaTecnica.Tienda.Model.Producto;
import com.PruebaTecnica.Tienda.Model.VentaRequest;
import com.PruebaTecnica.Tienda.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return productoService.listarProductos();
    }

    @PostMapping("/productos")
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    @PostMapping("/ventas")
    public Producto vender(@RequestBody VentaRequest request) {
        return productoService.venderProducto(request.getId(), request.getCantidad());
    }

    @PostMapping("/pedidos")
    public Producto pedir(@RequestBody PedidoRequest request) {
        return productoService.pedirProducto(request.getId(), request.getCantidad());
    }

    @GetMapping("/estadisticas")
    public Map<String, Object> getEstadisticas() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("ingresosTotales", productoService.calcularTotalVentas());
        stats.put("promedioVentas", productoService.calcularPromedioVentas());
        stats.put("masVendido", productoService.productoMasVendido().map(Producto::getNombre).orElse("-"));
        stats.put("menosVendido", productoService.productoMenosVendido().map(Producto::getNombre).orElse("-"));
        return stats;
    }
}
