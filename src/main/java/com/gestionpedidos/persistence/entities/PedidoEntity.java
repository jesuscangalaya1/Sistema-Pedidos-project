package com.gestionpedidos.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
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
    private Long id ;

/*    @JoinColumn(name = "clienteId", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteEntity cliente;*/


    @JoinColumn(name = "estadoId", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoEntity estado;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;




}
