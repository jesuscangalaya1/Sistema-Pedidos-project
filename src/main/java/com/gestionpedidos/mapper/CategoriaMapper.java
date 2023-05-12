package com.gestionpedidos.mapper;

import com.gestionpedidos.dtos.CategoriaDTO;
import com.gestionpedidos.dtos.ProductoDTO;
import com.gestionpedidos.persistence.entities.CategoriaEntity;
import com.gestionpedidos.persistence.entities.ProductoEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(uses = {ProductoMapper.class})
public interface CategoriaMapper {

    @Mapping(source = "productos", target = "productos" , ignore = true)
    CategoriaDTO toDTO(CategoriaEntity categoriaEntity);

    @InheritInverseConfiguration
    CategoriaEntity toEntity(CategoriaDTO categoriaDTO);

    //Listar los brands y cars juntos.
    @Named("withCategoriaId")
    @Mapping(source = "categoria.id", target = "categoriaId")
    ProductoDTO productoToDtoWithCategoryId(ProductoEntity productoEntity);

    @IterableMapping(qualifiedByName = "withCategoriaId")
    List<ProductoDTO> productsToProductsDtos(List<ProductoEntity> productoEntities);



    // importante para actualizar(me tenia podrido esta wbd)
    @Mapping(target = "id", ignore = true)
    // si no ignoramos al actualizar la lista de productos se borrara en casaca
    @Mapping(target = "productos", ignore = true)
    void updateCategoryFromDto(CategoriaDTO categoriaDTO, @MappingTarget CategoriaEntity categoriaEntity);

    // listar solo los brands
    List<CategoriaDTO> categoryListToCategoryDtoList(List<CategoriaEntity> categoriaEntityList);

}
