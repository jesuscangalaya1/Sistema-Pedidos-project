package com.gestionpedidos.service;

import com.gestionpedidos.dtos.DetallePedidoDTO;
import com.gestionpedidos.dtos.ProductoDTO;
import com.gestionpedidos.dtos.request.ProductoDTORequest;

import java.util.List;
import java.util.Optional;

public interface IDetallePedidoService {

    //List<ProductoDTORequest> listProducts();

    //Optional<ProductoDTORequest> getProductById(Long id);
    List<DetallePedidoDTO> list();
    DetallePedidoDTO createDetallePedido(DetallePedidoDTO detallePedidoDTO);
    DetallePedidoDTO updateDetallePedido(Long id, DetallePedidoDTO detallePedidoDTO);
    void deleteDetallePedido(Long id);
}
