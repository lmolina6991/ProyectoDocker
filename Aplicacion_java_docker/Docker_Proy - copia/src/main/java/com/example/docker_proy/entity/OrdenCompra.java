package com.example.docker_proy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orden_compra")
public class OrdenCompra {
    @Id
    @Column(name = "Id_Orden")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Fecha_Realizacion")
    private Date fechaRealizacion;
    @Column(name = "Fecha_Entrega_Esperada")
    private Date fechaEntregaEsperada;
    @Column(name = "Fecha_Entrega_Real")
    private Date fechaEntregaReal;
    @Column(name = "Cliente")
    private Long cliente;

    // Relación muchos a uno con Cliente
    @ManyToOne
    @JoinColumn(name = "Cliente", referencedColumnName = "Id_Cliente")
    private Cliente cliente;

    // Relación uno a muchos con DetalleCompra (inversa)
    @OneToMany(mappedBy = "ordenCompra")
    private List<DetalleCompra> detallesCompra;

}
