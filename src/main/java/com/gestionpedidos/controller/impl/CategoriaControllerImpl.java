package com.gestionpedidos.controller.impl;

import com.gestionpedidos.controller.ICategoriaController;
import com.gestionpedidos.dtos.CategoriaDTO;
import com.gestionpedidos.dtos.response.RestResponse;
import com.gestionpedidos.service.ICategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class CategoriaControllerImpl implements ICategoriaController {

    private final ICategoriaService categoriaService;

    @Override
    public RestResponse<List<CategoriaDTO>> listCategoyAndProducts() {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "CATEGORY AND PRODUCTS SUCCESSFULLY READED",
                categoriaService.listCategoryAndProducts());
    }

    @Override
    public RestResponse<List<CategoriaDTO>> listCategories() {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "CATEGORIES SUCCESSFULLY READED",
                categoriaService.listCategories());    }

    @Override
    public RestResponse<Optional<CategoriaDTO>> getCategoryById(Long id) {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "BRANDCAR ID: " +id+" SUCCESSFULLY READED",
                categoriaService.getCategoryById(id));    }

    @Override
    public RestResponse<CategoriaDTO> createCategory(CategoriaDTO categoriaDTO) {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.CREATED),
                "CATEGORY SUCCESSFULLY CREATED",
                categoriaService.createCategory(categoriaDTO));
    }

    @Override
    public RestResponse<CategoriaDTO> updatedCategory(Long id, CategoriaDTO categoriaDTO) {
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "CATEGORY ID: "+id+" SUCCESSFULLY UPDATED",
                categoriaService.updateCategory(id, categoriaDTO));
    }

    @Override
    public RestResponse<String> deleteCategory(Long id) {
        categoriaService.deleteCategory(id);
        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "CATEGORY ID: " +id+" SUCCESSFULLY DELETED",
                ""); // Data null.
    }
}
