package com.gestionpedidos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {

    private Long id;

    private Long categoriaId;

    private Double precio;

    private String nombre;

    private String descripcion;

    private int stock;
}
