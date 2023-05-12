package com.gestionpedidos.service.impl;

import com.gestionpedidos.dtos.ProductoDTO;
import com.gestionpedidos.mapper.ProductoMapper;
import com.gestionpedidos.persistence.entities.CategoriaEntity;
import com.gestionpedidos.persistence.entities.ProductoEntity;
import com.gestionpedidos.persistence.respitories.CategoriaRepository;
import com.gestionpedidos.persistence.respitories.ProductoRepository;
import com.gestionpedidos.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements IProductoService {

    private final ProductoMapper productoMapper;
    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    @Override
    public List<ProductoDTO> listProducts() {
        return productoMapper.productsToProdudctDtos(productoRepository.findAll());
    }

    @Override
    public Optional<ProductoDTO> getProductById(Long id) {
        return Optional.ofNullable(productoRepository.findById(id)
                .map(productoMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("P-400"+id + "El Id del Carro no existe ")));
    }

    @Override
    public ProductoDTO createProduct(ProductoDTO productoDTO) {
        CategoriaEntity categoriaEntity = categoriaRepository.findById(productoDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("P-400"+ productoDTO.getCategoriaId()+ "El Id del Carro no existe "));
        ProductoEntity productoEntity = productoMapper.toEntity(productoDTO);
        productoEntity.setCategoria(categoriaEntity);
        ProductoEntity savedProductEntity = productoRepository.save(productoEntity);
        return productoMapper.toDTO(savedProductEntity);
    }

    @Override
    public ProductoDTO updateProduct(Long id, ProductoDTO productoDTO) {
        ProductoEntity productEntity = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("P-400"));

        productoMapper.updateProductoFromDto(productoDTO, productEntity);

        productEntity = productoRepository.save(productEntity);
        return productoMapper.toDTO(productEntity);
    }

    @Override
    public void deleteProduct(Long id) {
        productoRepository.deleteById(id);
    }
}
