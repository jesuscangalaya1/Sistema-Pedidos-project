package com.gestionpedidos.dtos.request;

import com.gestionpedidos.dtos.ClienteDTO;
import com.gestionpedidos.dtos.DetallePedidoDTO;
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
public class PedidoDTORequest {

    private ClienteDTO cliente;

    private List<DetallePedidoDTO> detallePedidos;

    private Date fechaEntrega;
}
