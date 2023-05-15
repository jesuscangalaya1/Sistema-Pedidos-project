package com.gestionpedidos.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductoEntity {

    @Id
    @SequenceGenerator(name = "productos_id_generator", sequenceName = "productos_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "productos_id_generator")
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private CategoriaEntity categoria;

    private Double precio;

    private String nombre;

    private String descripcion;

    private int stock;

}
