package com.gestionpedidos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedidoDTO {

    private Long id;

    @NotBlank
    //private Long pedidoId;

    private Long productoId;

    @NotBlank
    private Long cantidad;
}
