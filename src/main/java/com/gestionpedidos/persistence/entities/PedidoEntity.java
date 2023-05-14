package com.gestionpedidos.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PedidoEntity {

    @Id
    @SequenceGenerator(name = "pedidos_id_generator", sequenceName = "pedidos_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "pedidos_id_generator")
    private Long pedidoId ;

    @JoinColumn(name = "clienteId", referencedColumnName = "clienteId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClienteEntity cliente;


    @JoinColumn(name = "estadoId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoEntity estado;

    private Date fechaEntrega;


    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedidoEntity> detallePedidos = new ArrayList<>();

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistorialpedidoEntity> historialpedidos = new ArrayList<>();


}
