package com.gestionpedidos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String direccion;

    @NotBlank
    private String detarmento;

    @NotBlank
    private String provincia;


    @NotBlank
    private String distrito;

    @NotBlank
    private String celular;

    @NotBlank
    private String correo;

    @NotBlank
    private String documento;
}
