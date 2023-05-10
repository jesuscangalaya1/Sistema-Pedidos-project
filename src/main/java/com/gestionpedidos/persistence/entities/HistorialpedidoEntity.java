package com.gestionpedidos.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="historialpedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HistorialpedidoEntity {

    @Id
    @SequenceGenerator(name = "historialpedidos_id_generator", sequenceName = "historialpedidos_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "historialpedidos_id_generator")
    private Long historialPedidoId;

    @JsonIgnore
    @JoinColumn(name = "pedidoId", referencedColumnName = "pedidoId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PedidoEntity pedido;

    private Date fecha;

    @JoinColumn(name = "estadoId", referencedColumnName = "estadoId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoEntity estado;
}
