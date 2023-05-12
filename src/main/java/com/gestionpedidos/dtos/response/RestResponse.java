package com.gestionpedidos.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class RestResponse<T> implements Serializable {

    private String status;

    private String code;

    private String message;

    private T data;

    public RestResponse(String status, String code, String message) {
    }
}
