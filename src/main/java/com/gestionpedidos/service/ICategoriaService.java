package com.gestionpedidos.service;

import com.gestionpedidos.dtos.CategoriaDTO;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {

    List<CategoriaDTO> listCategories();
    Optional<CategoriaDTO> getCategoryById(Long id);
    CategoriaDTO createCategory(CategoriaDTO categoriaDTO);
    CategoriaDTO updateCategory(Long id, CategoriaDTO categoriaDTO);
    void deleteCategory(Long id);
}
