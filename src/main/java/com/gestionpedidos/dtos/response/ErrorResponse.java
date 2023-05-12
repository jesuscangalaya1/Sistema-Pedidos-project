package com.gestionpedidos.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private LocalDateTime date;
    private String code;
    private String message;
}
