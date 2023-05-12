package com.gestionpedidos.controller;

import com.gestionpedidos.dtos.CategoriaDTO;
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
@Tag(name = "Categories", description = "Operaciones permitidas sobre la entidad Category")
@RequestMapping("/api/categories")
public interface ICategoriaController {

    @GetMapping(value ="/categoryAndProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<List<CategoriaDTO>> listCategoyAndProducts();

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<List<CategoriaDTO>> listCategories();

    @GetMapping(value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<Optional<CategoriaDTO>> getCategoryById(
            @Parameter(description = "El ID de la Category a obtener", required = true)
            @PathVariable @Positive(message = "el ID solo acepta numeros positivos")
            Long id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<CategoriaDTO> createCategory(
            @Parameter(description = "Created BrandCar object", required = true)
            @RequestBody CategoriaDTO categoriaDTO);

    @PutMapping(value="/updateBrand/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    RestResponse<CategoriaDTO> updatedCategory(
            @Parameter(description = "El ID de la Category a actualizar", required = true)
            @PathVariable @Positive(message = "el ID solo acepta numeros positivos")
            Long id,
            @Parameter(description = "The Category body.")
            @RequestBody CategoriaDTO categoriaDTO);

    @DeleteMapping("/{id}")
    RestResponse<String> deleteCategory(
            @Parameter(description = "El ID de Category a eliminar", required = true)
            @PathVariable @Positive(message = "el ID solo acepta numeros positivos")
            @Min(value = 1, message = "el ID mínimo permitido es 1")
            Long id);

}
