package com.gestionpedidos.persistence.respitories;

import com.gestionpedidos.persistence.entities.CategoriaEntity;
import com.gestionpedidos.persistence.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<ProductoEntity,Long> {
    List<ProductoEntity> findByCategoria(CategoriaEntity categoria);
}
