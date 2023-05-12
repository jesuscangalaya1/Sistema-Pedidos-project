package com.gestionpedidos.service;

import com.gestionpedidos.dtos.ProductoDTO;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    List<ProductoDTO> listProducts();
    //List<ProductoDTO> listProductsAndCategories();
    Optional<ProductoDTO> getProductById(Long id);
    ProductoDTO createProduct(ProductoDTO productoDTO);
    ProductoDTO updateProduct(Long id, ProductoDTO productoDTO);
    void deleteProduct(Long id);
}
