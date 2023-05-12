package com.gestionpedidos.mapper;

import com.gestionpedidos.dtos.ProductoDTO;
import com.gestionpedidos.persistence.entities.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface ProductoMapper {

    @Mapping(source = "categoria.id", target = "categoriaId")
    ProductoDTO toDTO(ProductoEntity entity);

    @Mapping(source = "categoriaId", target = "categoria.id")
    ProductoEntity toEntity(ProductoDTO dto);

    void updateProductoFromDto(ProductoDTO productoDTO, @MappingTarget ProductoEntity productoEntity);

    List<ProductoDTO> productsToProdudctDtos(List<ProductoEntity> productoEntityList);
}
