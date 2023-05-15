package com.gestionpedidos.persistence.respitories;

import com.gestionpedidos.persistence.entities.CategoriaEntity;
import com.gestionpedidos.persistence.entities.EstadoEntity;
import com.gestionpedidos.persistence.entities.PedidoEntity;
import com.gestionpedidos.persistence.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
    List<PedidoEntity> findByEstado(EstadoEntity estado);
}
