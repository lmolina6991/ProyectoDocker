package com.example.docker_proy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "detalle_compra")
public class DetalleCompra {
    @Id
    @Column(name = "Id_Detalle")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Id_Orden")
    private Long idOrden;
    @Column(name = "Id_Producto")
    private Long idProducto;
    @Column(name = "Cantidad")
    private Integer cantidad;
    @Column(name = "Precio")
    private BigDecimal precio;

    // Relación muchos a uno con Producto
    @ManyToOne
    @JoinColumn(name = "Id_Producto", referencedColumnName = "id)
    private Producto producto;

    // Relación muchos a uno con OrdenCompra
    @ManyToOne
    @JoinColumn(name = "Id_Orden", referencedColumnName = "id)
    private OrdenCompra ordenCompra;

}
