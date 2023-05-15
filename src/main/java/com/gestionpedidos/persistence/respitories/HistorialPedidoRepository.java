package com.gestionpedidos.persistence.respitories;

import com.gestionpedidos.persistence.entities.HistorialpedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistorialPedidoRepository extends JpaRepository<HistorialpedidoEntity, Long> {
}
