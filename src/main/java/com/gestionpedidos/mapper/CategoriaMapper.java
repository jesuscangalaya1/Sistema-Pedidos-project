package com.gestionpedidos.mapper;

import com.gestionpedidos.dtos.CategoriaDTO;
import com.gestionpedidos.dtos.ProductoDTO;
import com.gestionpedidos.persistence.entities.CategoriaEntity;
import com.gestionpedidos.persistence.entities.ProductoEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(uses = {ProductoMapper.class})
public interface CategoriaMapper {

    //@Mapping(source = "productos", target = "productos" , ignore = true)
    CategoriaDTO toDTO(CategoriaEntity categoriaEntity);

    @InheritInverseConfiguration
    CategoriaEntity toEntity(CategoriaDTO categoriaDTO);


    // importante para actualizar(me tenia podrido esta wbd)
    @Mapping(target = "id", ignore = true)
    void updateCategoryFromDto(CategoriaDTO categoriaDTO, @MappingTarget CategoriaEntity categoriaEntity);

    // listar solo los brands
    List<CategoriaDTO> categoryListToCategoryDtoList(List<CategoriaEntity> categoriaEntityList);

}
