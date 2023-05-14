package com.gestionpedidos.mapper;

import com.gestionpedidos.dtos.ProductoDTO;
import com.gestionpedidos.dtos.request.ProductoDTORequest;
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


    //UpdateProducto
    @Mapping(target = "id", ignore = true)
    void updateProductoFromDto(ProductoDTO productoDTO, @MappingTarget ProductoEntity productoEntity);


    //GetByIdWithCategories
    @Mapping(source = "categoria.id", target = "categoria.id")
    ProductoDTORequest toDTOWithCategoria(ProductoEntity entity);

    //ListWithCategories
    List<ProductoDTORequest> productsToProdudctDtos(List<ProductoEntity> productoEntityList);
}
