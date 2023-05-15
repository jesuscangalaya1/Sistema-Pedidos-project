package com.gestionpedidos.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClienteEntity {

    @Id
    @SequenceGenerator(name = "clientes_id_generator", sequenceName = "clientes_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "clientes_id_generator")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String detarmento;

    @Column(nullable = false)
    private String provincia;


    @Column(nullable = false)
    private String distrito;

    @Column(nullable = false)
    private String celular;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String documento;

}
