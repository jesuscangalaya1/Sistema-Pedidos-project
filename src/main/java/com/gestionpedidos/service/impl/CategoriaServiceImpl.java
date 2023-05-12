package com.gestionpedidos.service.impl;

import com.gestionpedidos.dtos.CategoriaDTO;
import com.gestionpedidos.dtos.ProductoDTO;
import com.gestionpedidos.mapper.CategoriaMapper;
import com.gestionpedidos.persistence.entities.CategoriaEntity;
import com.gestionpedidos.persistence.respitories.CategoriaRepository;
import com.gestionpedidos.service.ICategoriaService;
import lombok.RequiredArgsConstructor;
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
        List<CategoriaEntity> categoriaEntities = categoriaRepository.findAll();
        return categoriaMapper.brandCarListToBrandCarDtoList(categoriaEntities);
    }

    @Override
    public List<CategoriaDTO> listCategoryAndProducts() {
        List<CategoriaEntity> categoriaEntities = categoriaRepository.findAll();
        return categoriaEntities.stream()
                .map(category ->{
                    CategoriaDTO categoriaDTO = categoriaMapper.toDTO(category);
                    List<ProductoDTO> productoDTOList = categoriaMapper.carsToCarDtos(category.getProductos());
                    categoriaDTO.setProductos(productoDTOList);
                    return categoriaDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoriaDTO> getCategoryById(Long id) {
        Optional<CategoriaEntity> categoriaEntityOptional = categoriaRepository.findById(id);
        return categoriaEntityOptional.map(categoriaMapper::toDTO);
    }

    @Override
    public CategoriaDTO createCategory(CategoriaDTO categoriaDTO) {
        CategoriaEntity categoriaEntity = categoriaMapper.toEntity(categoriaDTO);
        CategoriaEntity savedCategoryEntity = categoriaRepository.save(categoriaEntity);
        return categoriaMapper.toDTO(savedCategoryEntity);
    }

    @Override
    public CategoriaDTO updateCategory(Long id, CategoriaDTO categoriaDTO) {
        CategoriaEntity categoriaEntity = categoriaRepository.findById(id).get();
        categoriaMapper.updateBrandCarFromDto(categoriaDTO, categoriaEntity);
        categoriaEntity = categoriaRepository.save(categoriaEntity);
        return categoriaMapper.toDTO(categoriaEntity);
    }

    @Override
    public void deleteCategory(Long id) {
        categoriaRepository.deleteById(id);
    }
}
