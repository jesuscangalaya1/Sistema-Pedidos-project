package com.gestionpedidos.mapper;

import com.gestionpedidos.dtos.CategoriaDTO;
import com.gestionpedidos.dtos.DetallePedidoDTO;
import com.gestionpedidos.dtos.ProductoDTO;
import com.gestionpedidos.persistence.entities.CategoriaEntity;
import com.gestionpedidos.persistence.entities.DetallePedidoEntity;
import com.gestionpedidos.persistence.entities.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface DetallePedidoMapper {

    //@Mapping(source = "pedido.id", target = "pedidoId")
    @Mapping(source = "producto.id", target = "productoId")
    DetallePedidoDTO toDTO(DetallePedidoEntity entity);

    //@Mapping(source = "pedidoId", target = "pedido.id")
    @Mapping(source = "productoId", target = "producto.id")
    DetallePedidoEntity toEntity(DetallePedidoDTO dto);

    @Mapping(target = "id", ignore = true)
    void updateProductoFromDto(DetallePedidoDTO detallePedidoDTO, @MappingTarget DetallePedidoEntity detallePedidoEntity);

    List<DetallePedidoDTO> detalleListToDetalleDtoList(List<DetallePedidoEntity> detallePedidoEntityList);


}
