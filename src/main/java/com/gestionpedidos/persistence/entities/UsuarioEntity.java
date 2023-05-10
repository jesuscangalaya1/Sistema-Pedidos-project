package com.gestionpedidos.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="USUARIOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {

    @Id
    @SequenceGenerator(name = "usuario_id_generator", sequenceName = "usuario_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "usuario_id_generator")
    private Long id;

    private String username;
    private String password;
    private String name;
    private String lastname;
    private String cellphone;
    private Integer gender;
    private String email;
    private String birthDate;
    private String facebook;

    @Column(nullable = true)
    private Integer tipoUsuario;
}
