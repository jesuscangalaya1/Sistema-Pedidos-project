package com.gestionpedidos.dtos;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {

    private Long id;

    private String nombre;

    @Hidden
    private List<ProductoDTO> productos = new ArrayList<>();
}
