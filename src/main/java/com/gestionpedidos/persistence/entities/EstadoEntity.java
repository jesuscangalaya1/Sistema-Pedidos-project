package com.gestionpedidos.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="estados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EstadoEntity {

    @Id
    @SequenceGenerator(name = "estados_id_generator", sequenceName = "estados_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "estados_id_generator")
    private Long estadoId;

    @Column(nullable = false)
    private String nombre;


}
