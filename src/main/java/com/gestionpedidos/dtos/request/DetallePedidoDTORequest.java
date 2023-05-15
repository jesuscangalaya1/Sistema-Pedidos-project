package com.gestionpedidos.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedidoDTORequest {

    private Long id;

    @NotBlank
    private ProductoDTORequest producto;


    @NotBlank
    private Long cantidad;
}
