package com.gestionpedidos.service.impl;

import com.gestionpedidos.dtos.DetallePedidoDTO;
import com.gestionpedidos.exception.BusinessException;
import com.gestionpedidos.mapper.DetallePedidoMapper;
import com.gestionpedidos.persistence.entities.CategoriaEntity;
import com.gestionpedidos.persistence.entities.DetallePedidoEntity;
import com.gestionpedidos.persistence.entities.ProductoEntity;
import com.gestionpedidos.persistence.respitories.DetallePedidoRepository;
import com.gestionpedidos.persistence.respitories.ProductoRepository;
import com.gestionpedidos.service.IDetallePedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetallePedidoServiceImpl implements IDetallePedidoService {

    private final DetallePedidoRepository detallePedidoRepository;
    private final ProductoRepository productoRepository;
    private final DetallePedidoMapper detallePedidoMapper;

    @Override
    public List<DetallePedidoDTO> list() {
        List<DetallePedidoEntity> detallePedidoEntities = this.detallePedidoRepository.findAll();
        return Optional.of(detallePedidoEntities)
                .filter(list -> !list.isEmpty())
                .map(detallePedidoMapper::detalleListToDetalleDtoList)
                .orElseThrow(() -> new BusinessException("P-204", HttpStatus.NO_CONTENT, "Lista Vacia de Productos"));
    }

    @Override
    public DetallePedidoDTO createDetallePedido(DetallePedidoDTO detallePedidoDTO) {
        ProductoEntity productoEntity = this.productoRepository.findById(detallePedidoDTO.getProductoId())
                .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id del Producto no existe " + detallePedidoDTO.getProductoId()));
        DetallePedidoEntity detallePedido = detallePedidoMapper.toEntity(detallePedidoDTO);
        detallePedido.setProducto(productoEntity);
        DetallePedidoEntity savedDetalleEntity = this.detallePedidoRepository.save(detallePedido);
        return detallePedidoMapper.toDTO(savedDetalleEntity);
    }
 // con el id del pedido
/*    @Override
    public DetallePedidoDTO createDetallePedido(DetallePedidoDTO detallePedidoDTO) {
        ProductoEntity productoEntity = this.productoRepository.findById(detallePedidoDTO.getProductoId())
                .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id del Producto no existe " + detallePedidoDTO.getProductoId()));

        PedidoEntity pedidoEntity = this.pedidoRepository.findById(detallePedidoDTO.getPedidoId())
                .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id del Pedido no existe " + detallePedidoDTO.getPedidoId()));

        DetallePedidoEntity detallePedido = detallePedidoMapper.toEntity(detallePedidoDTO);
        detallePedido.setProducto(productoEntity);
        detallePedido.setPedido(pedidoEntity);

        DetallePedidoEntity savedDetalleEntity = this.detallePedidoRepository.save(detallePedido);
        return detallePedidoMapper.toDTO(savedDetalleEntity);
    }*/



    @Override
    public DetallePedidoDTO updateDetallePedido(Long id, DetallePedidoDTO detallePedidoDTO) {
        DetallePedidoEntity detallePedido = detallePedidoRepository.findById(id)
                .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id del Producto no existe " + id));

        // Verificar si la categoríaId es válida
        Long productoId = detallePedidoDTO.getProductoId();
        if (productoId != null) {
            ProductoEntity productoEntity = productoRepository.findById(productoId)
                    .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id de la Categoría no existe " + productoId));
            detallePedido.setProducto(productoEntity);
        }

        detallePedidoMapper.updateProductoFromDto(detallePedidoDTO, detallePedido);

        detallePedido = detallePedidoRepository.save(detallePedido);
        return detallePedidoMapper.toDTO(detallePedido);
    }

    @Override
    public void deleteDetallePedido(Long id) {
        if (!detallePedidoRepository.existsById(id)) {
            throw new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id del Detalle no existe");
        }
        detallePedidoRepository.deleteById(id);
    }
}
