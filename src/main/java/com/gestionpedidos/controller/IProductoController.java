package com.gestionpedidos.controller;

import com.gestionpedidos.dtos.ProductoDTO;
import com.gestionpedidos.dtos.response.RestResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

@Validated
@Tag(name = "Products", description = "Operaciones permitidas sobre la entidad Product")
@RequestMapping("/api/products")
public interface IProductoController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<List<ProductoDTO>> listProducts();

    @GetMapping(value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<Optional<ProductoDTO>> getProductById(
            @Parameter(description = "El ID del Product a obtener", required = true)
            @PathVariable @Positive(message = "el ID solo acepta numeros positivos")
            Long id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<ProductoDTO> createProduct(
            @Parameter(description = "Created Product object", required = true)
            @RequestBody ProductoDTO productoDTO);

    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<ProductoDTO> updatedProduct(
            @Parameter(description = "El ID de la Product a actualizar", required = true)
            @PathVariable @Positive(message = "el ID solo acepta numeros positivos")
            Long id,
            @Parameter(description = "The Product body.")
            @RequestBody ProductoDTO productoDTO);

    @DeleteMapping("/{id}")
    RestResponse<String> deleteProduct(
            @Parameter(description = "El ID de la Product a eliminar", required = true)
            @PathVariable @Positive(message = "el ID solo acepta numeros positivos")
            @Min(value = 1, message = "el ID mínimo permitido es 1")
            Long id);
}
