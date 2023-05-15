package com.gestionpedidos.persistence.respitories;

import com.gestionpedidos.persistence.entities.DetallePedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoRepository extends JpaRepository<DetallePedidoEntity,Long> {
}
