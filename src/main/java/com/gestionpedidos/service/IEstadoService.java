package com.gestionpedidos.service;

import com.gestionpedidos.dtos.CategoriaDTO;
import com.gestionpedidos.dtos.EstadoDTO;

import java.util.List;
import java.util.Optional;

public interface IEstadoService {

    List<EstadoDTO> listEstados();
    Optional<EstadoDTO> getEstadoById(Long id);
    EstadoDTO createEstado(EstadoDTO estadoDTO);
    EstadoDTO updateEstado(Long id, EstadoDTO estadoDTO);
    void deleteEstado(Long id);
}
