package com.gestionpedidos.mapper;

import com.gestionpedidos.dtos.CategoriaDTO;
import com.gestionpedidos.dtos.EstadoDTO;
import com.gestionpedidos.persistence.entities.CategoriaEntity;
import com.gestionpedidos.persistence.entities.EstadoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface EstadoMapper {

    EstadoDTO toDTO(EstadoEntity estadoEntity);

    @InheritInverseConfiguration
    EstadoEntity toEntity(EstadoDTO estadoDTO);

    @Mapping(target = "id", ignore = true)
    void updateEstadoFromDto(EstadoDTO estadoDTO, @MappingTarget EstadoEntity estadoEntity);

    // listar solo las categories
    List<EstadoDTO> categoryListToCategoryDtoList(List<EstadoEntity> estadoEntityList);

}
