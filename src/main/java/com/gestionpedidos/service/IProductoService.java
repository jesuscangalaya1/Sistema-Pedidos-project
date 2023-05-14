package com.gestionpedidos.service;

import com.gestionpedidos.dtos.ProductoDTO;
import com.gestionpedidos.dtos.request.ProductoDTORequest;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    List<ProductoDTORequest> listProducts();
    Optional<ProductoDTORequest> getProductById(Long id);
    ProductoDTO createProduct(ProductoDTO productoDTO);
    ProductoDTO updateProduct(Long id, ProductoDTO productoDTO);
    void deleteProduct(Long id);
}
