package com.gestionpedidos.persistence.respitories;

import com.gestionpedidos.persistence.entities.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

}
