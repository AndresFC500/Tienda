package com.PruebaTecnica.Tienda.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String tipo; // PAPELERIA, SUPERMERCADO, DROGUERIA

    private int cantidadActual;

    private int cantidadMinima;

    private double precioBase;

    private int unidadesVendidas;

    public double getIVA() {
        return switch (tipo.toUpperCase()) {
            case "PAPELERIA" -> 0.16;
            case "SUPERMERCADO" -> 0.04;
            case "DROGUERIA" -> 0.12;
            default -> 0.0;
        };
    }

    public double getPrecioFinal() {
        return precioBase * (1 + getIVA());
    }

    public boolean necesitaPedido() {
        return cantidadActual <= cantidadMinima;
    }
}
