package com.gestionpedidos.controller.impl;

import com.gestionpedidos.dtos.DetallePedidoDTO;
import com.gestionpedidos.dtos.EstadoDTO;
import com.gestionpedidos.service.IEstadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/estados")
public class EstadoController {
    private final IEstadoService estadoService;


    @GetMapping
    public ResponseEntity<List<EstadoDTO>> listAll(){
        return new ResponseEntity<>(this.estadoService.listEstados(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EstadoDTO>> getByID(@PathVariable Long id){
        return new ResponseEntity<>(this.estadoService.getEstadoById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EstadoDTO> createEstado(@RequestBody EstadoDTO estadoDTO){
        return new ResponseEntity<>(this.estadoService.createEstado(estadoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoDTO> updateEstado(@PathVariable Long id, @RequestBody EstadoDTO estadoDTO){
        return new ResponseEntity<>(this.estadoService.updateEstado(id, estadoDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDetalle(@PathVariable Long id){
        this.estadoService.deleteEstado(id);
        return new ResponseEntity<>("eliminado exitosamente", HttpStatus.OK);
    }
}
