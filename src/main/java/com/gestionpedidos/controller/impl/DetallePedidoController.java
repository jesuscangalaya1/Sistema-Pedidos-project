package com.gestionpedidos.controller.impl;

import com.gestionpedidos.dtos.DetallePedidoDTO;
import com.gestionpedidos.service.IDetallePedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/detalles-pedidos")
public class DetallePedidoController {
    private final IDetallePedidoService detallePedidoService;

    @GetMapping
    public ResponseEntity<List<DetallePedidoDTO>> listAll(){
        return new ResponseEntity<>(this.detallePedidoService.list(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DetallePedidoDTO> createDetalle(@RequestBody DetallePedidoDTO detallePedidoDTO){
        return new ResponseEntity<>(this.detallePedidoService.createDetallePedido(detallePedidoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedidoDTO> updateDetalle(@PathVariable Long id, @RequestBody DetallePedidoDTO detallePedidoDTO){
        return new ResponseEntity<>(this.detallePedidoService.updateDetallePedido(id, detallePedidoDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDetalle(@PathVariable Long id){
        this.detallePedidoService.deleteDetallePedido(id);
        return new ResponseEntity<>("eliminado exitosamente", HttpStatus.OK);
    }
}
