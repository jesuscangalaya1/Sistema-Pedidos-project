package com.gestionpedidos.dtos.request;

import com.gestionpedidos.persistence.entities.CategoriaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequest {

    private Long productoId;

    private CategoriaEntity categoria;

    private Double precio;

    private String nombre;

    private String descripcion;

    private int stock;
}
