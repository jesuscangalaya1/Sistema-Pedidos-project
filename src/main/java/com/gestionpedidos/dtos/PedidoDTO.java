package com.gestionpedidos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    //private ClientesRequest cliente;

    private List<DetallePedidoDTO> detallePedidos;

    private Date fechaEntrega;
}
