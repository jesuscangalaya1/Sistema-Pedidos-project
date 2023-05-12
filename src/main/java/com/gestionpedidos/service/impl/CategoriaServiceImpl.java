package com.gestionpedidos.service.impl;

import com.gestionpedidos.dtos.CategoriaDTO;
import com.gestionpedidos.dtos.ProductoDTO;
import com.gestionpedidos.exception.BusinessException;
import com.gestionpedidos.mapper.CategoriaMapper;
import com.gestionpedidos.persistence.entities.CategoriaEntity;
import com.gestionpedidos.persistence.respitories.CategoriaRepository;
import com.gestionpedidos.service.ICategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements ICategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    @Override
    public List<CategoriaDTO> listCategories() {
        List<CategoriaEntity> productoEntities = categoriaRepository.findAll();
        return Optional.of(productoEntities)
                .filter(list -> !list.isEmpty())
                .map(categoriaMapper::categoryListToCategoryDtoList)
                .orElseThrow(() -> new BusinessException("P-204", HttpStatus.NO_CONTENT, "Lista Vacia de Productos"));
    }

    @Override
    public List<CategoriaDTO> listCategoryAndProducts() {
        List<CategoriaEntity> categoriaEntities = categoriaRepository.findAll();
        if (categoriaEntities.isEmpty()) {
            throw new BusinessException("P-204", HttpStatus.NO_CONTENT, "No se encontraron categorías");
        }
        return categoriaEntities.stream()
                .map(category -> {
                    CategoriaDTO categoriaDTO = categoriaMapper.toDTO(category);
                    List<ProductoDTO> productoDTOList = categoriaMapper.productsToProductsDtos(category.getProductos());
                    categoriaDTO.setProductos(productoDTOList);
                    return categoriaDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoriaDTO> getCategoryById(Long id) {
        return Optional.ofNullable(categoriaRepository.findById(id)
                .map(categoriaMapper::toDTO)
                .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id de la Categoria no existe " + id)));
    }

    @Override
    public CategoriaDTO createCategory(CategoriaDTO categoriaDTO) {
        CategoriaEntity categoriaEntity = categoriaMapper.toEntity(categoriaDTO);
        CategoriaEntity savedCategoryEntity = categoriaRepository.save(categoriaEntity);
        return categoriaMapper.toDTO(savedCategoryEntity);
    }

    @Override
    public CategoriaDTO updateCategory(Long id, CategoriaDTO categoriaDTO) {
        CategoriaEntity categoriaEntity = categoriaRepository.findById(id)
                .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id de la Categoria no existe " + id));
        categoriaMapper.updateCategoryFromDto(categoriaDTO, categoriaEntity);
        categoriaEntity = categoriaRepository.save(categoriaEntity);
        return categoriaMapper.toDTO(categoriaEntity);
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id de la Categoria no existe");
        }
        categoriaRepository.deleteById(id);
    }
}
