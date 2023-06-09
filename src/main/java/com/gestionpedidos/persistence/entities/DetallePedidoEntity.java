package com.gestionpedidos.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "detalle_pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DetallePedidoEntity {

    @Id
    @SequenceGenerator(
            name = "detallePedidos_id_generator",
            sequenceName = "detallePedidos_id_seq", allocationSize = 1
    )
    @GeneratedValue(
            generator = "detallePedidos_id_generator"
    )
    private Long id;

    @JsonIgnore
    @JoinColumn(name = "pedidoId", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PedidoEntity pedido;

    @JsonBackReference
    @JoinColumn(name = "productoId", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductoEntity producto;

    @Column(nullable = false)
    private Long cantidad;
}
