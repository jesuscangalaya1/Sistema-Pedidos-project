package com.gestionpedidos.service.impl;

import com.gestionpedidos.dtos.ProductoDTO;
import com.gestionpedidos.dtos.request.ProductoDTORequest;
import com.gestionpedidos.exception.BusinessException;
import com.gestionpedidos.mapper.ProductoMapper;
import com.gestionpedidos.persistence.entities.CategoriaEntity;
import com.gestionpedidos.persistence.entities.ProductoEntity;
import com.gestionpedidos.persistence.respitories.CategoriaRepository;
import com.gestionpedidos.persistence.respitories.ProductoRepository;
import com.gestionpedidos.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public List<ProductoDTORequest> listProducts() {
        List<ProductoEntity> productoEntities = productoRepository.findAll();
        return Optional.of(productoEntities)
                .filter(list -> !list.isEmpty())
                .map(productoMapper::productsToProdudctDtos)
                .orElseThrow(() -> new BusinessException("P-204", HttpStatus.NO_CONTENT, "Lista Vacia de Productos"));
    }


    @Override
    public Optional<ProductoDTORequest> getProductById(Long id) {
        ProductoEntity entity = productoRepository.findById(id)
                .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id del Producto no existe " + id));
        return Optional.of(productoMapper.toDTOWithCategoria(entity));
    }




    @Override
    public ProductoDTO createProduct(ProductoDTO productoDTO) {
        CategoriaEntity categoriaEntity = categoriaRepository.findById(productoDTO.getCategoriaId())
                .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id del Producto no existe " + productoDTO.getCategoriaId()));
        ProductoEntity productoEntity = productoMapper.toEntity(productoDTO);
        productoEntity.setCategoria(categoriaEntity);
        ProductoEntity savedProductEntity = productoRepository.save(productoEntity);
        return productoMapper.toDTO(savedProductEntity);
    }

    @Override
    public ProductoDTO updateProduct(Long id, ProductoDTO productoDTO) {
        ProductoEntity productEntity = productoRepository.findById(id)
                .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id del Producto no existe " + id));

        // Verificar si la categoríaId es válida
        Long categoriaId = productoDTO.getCategoriaId();
        if (categoriaId != null) {
            CategoriaEntity categoriaEntity = categoriaRepository.findById(categoriaId)
                    .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id de la Categoría no existe " + categoriaId));
            productEntity.setCategoria(categoriaEntity);
        }

        productoMapper.updateProductoFromDto(productoDTO, productEntity);

        productEntity = productoRepository.save(productEntity);
        return productoMapper.toDTO(productEntity);
    }


    @Override
    public void deleteProduct(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id del Producto no existe");
        }
        productoRepository.deleteById(id);
    }
}
