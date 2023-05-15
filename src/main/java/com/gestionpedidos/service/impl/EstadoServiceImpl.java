package com.gestionpedidos.service.impl;

import com.gestionpedidos.dtos.EstadoDTO;
import com.gestionpedidos.exception.BusinessException;
import com.gestionpedidos.mapper.EstadoMapper;
import com.gestionpedidos.persistence.entities.CategoriaEntity;
import com.gestionpedidos.persistence.entities.EstadoEntity;
import com.gestionpedidos.persistence.respitories.EstadoRepository;
import com.gestionpedidos.persistence.respitories.PedidoRepository;
import com.gestionpedidos.service.IEstadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstadoServiceImpl implements IEstadoService {

    private final EstadoRepository estadoRepository;
    private final EstadoMapper estadoMapper;
    private final PedidoRepository pedidoRepository;

    @Override
    public List<EstadoDTO> listEstados() {
        List<EstadoEntity> estadoEntities = this.estadoRepository.findAll();
        return Optional.of(estadoEntities)
                .filter(list -> !list.isEmpty())
                .map(estadoMapper::categoryListToCategoryDtoList)
                .orElseThrow(() -> new BusinessException("P-204", HttpStatus.NO_CONTENT, "Lista Vacia de Productos"));
    }

    @Override
    public Optional<EstadoDTO> getEstadoById(Long id) {
        return Optional.ofNullable(estadoRepository.findById(id)
                .map(estadoMapper::toDTO)
                .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id de la Categoria no existe " + id)));
    }

    @Override
    public EstadoDTO createEstado(EstadoDTO estadoDTO) {
        EstadoEntity estadoEntity = estadoMapper.toEntity(estadoDTO);
        EstadoEntity savedEstadoEntity = estadoRepository.save(estadoEntity);
        return estadoMapper.toDTO(savedEstadoEntity);
    }

    @Override
    public EstadoDTO updateEstado(Long id, EstadoDTO estadoDTO) {
        EstadoEntity estadoEntity = estadoRepository.findById(id)
                .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id de la Categoria no existe " + id));
        estadoMapper.updateEstadoFromDto(estadoDTO, estadoEntity);
        estadoEntity = estadoRepository.save(estadoEntity);
        return estadoMapper.toDTO(estadoEntity);
    }

    @Override
    public void deleteEstado(Long id) {
        EstadoEntity estado = estadoRepository.findById(id)
                .orElseThrow(() -> new BusinessException("P-400", HttpStatus.BAD_REQUEST, "El Id de Estado no existe"));

        pedidoRepository.findByEstado(estado)
                .forEach(estados -> {
                    estados.setEstado(null);
                    pedidoRepository.save(estados);
                });
        estadoRepository.delete(estado);
    }
}
