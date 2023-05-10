package com.gestionpedidos.dtos.request;

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
public class PedidoRequest {

    //private ClientesRequest cliente;

    private List<DetallePedidoRequest> detallePedidos;

    private Date fechaEntrega;
}
