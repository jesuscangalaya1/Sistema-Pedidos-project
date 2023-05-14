package com.gestionpedidos.controller.impl;

import com.gestionpedidos.controller.IProductoController;
import com.gestionpedidos.dtos.ProductoDTO;
import com.gestionpedidos.dtos.request.ProductoDTORequest;
import com.gestionpedidos.dtos.response.RestResponse;
import com.gestionpedidos.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class IProductoControllerImpl implements IProductoController {

    private final IProductoService productoService;

    @Override
    public RestResponse<List<ProductoDTORequest>> listProducts() {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "PRODUCT SUCCESSFULLY READED",
                productoService.listProducts());
    }

    @Override
    public RestResponse<Optional<ProductoDTORequest>> getProductById(Long id) {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "PRODUCT ID: " + id + " SUCCESSFULLY READED",
                productoService.getProductById(id));
    }

    @Override
    public RestResponse<ProductoDTO> createProduct(ProductoDTO productoDTO) {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.CREATED),
                "PRODUCT SUCCESSFULLY CREATED",
                productoService.createProduct(productoDTO));    }

    @Override
    public RestResponse<ProductoDTO> updatedProduct(Long id, ProductoDTO productoDTO) {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "PRODUCT ID: " + id + " SUCCESSFULLY UPDATED",
                productoService.updateProduct(id, productoDTO));
    }

    @Override
    public RestResponse<String> deleteProduct(Long id) {
        productoService.deleteProduct(id);
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "PRODUCT ID: " + id + " SUCCESSFULLY DELETED",
                ""); // Data null.
    }
}
