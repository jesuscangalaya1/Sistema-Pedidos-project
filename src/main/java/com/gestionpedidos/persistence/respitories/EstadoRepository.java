package com.gestionpedidos.persistence.respitories;

import com.gestionpedidos.persistence.entities.EstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<EstadoEntity, Long> {
}
