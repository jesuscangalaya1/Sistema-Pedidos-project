package com.gestionpedidos.persistence.respitories;

import com.gestionpedidos.persistence.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<ProductoEntity,Long> {
}
