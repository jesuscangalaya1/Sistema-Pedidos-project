package com.gestionpedidos.dtos.request;

import com.gestionpedidos.persistence.entities.ProductoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedidoRequest {

    @NotBlank
    private ProductoEntity producto;

    @NotBlank
    private Long cantidad;
}
