package com.PruebaTecnica.Tienda.Repository;

import com.PruebaTecnica.Tienda.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
