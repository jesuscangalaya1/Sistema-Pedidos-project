package com.gestionpedidos.dtos.request;

import com.gestionpedidos.dtos.CategoriaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
            //ProductoRequest
public class ProductoDTORequest {


    private Long id;

    private CategoriaDTO categoria;

    private Double precio;

    private String nombre;

    private String descripcion;

    private int stock;


}
