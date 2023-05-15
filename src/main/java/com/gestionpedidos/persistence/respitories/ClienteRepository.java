package com.gestionpedidos.persistence.respitories;

import com.gestionpedidos.persistence.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity,Long> {
}
