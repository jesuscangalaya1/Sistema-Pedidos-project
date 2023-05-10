package com.gestionpedidos.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="categorias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CategoriaEntity {

    @Id
    @SequenceGenerator(name = "categorias_id_generator", sequenceName = "categorias_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "categorias_id_generator")
    private Long categoriaId;

    @Column(nullable = false)
    private String nombre;
}
