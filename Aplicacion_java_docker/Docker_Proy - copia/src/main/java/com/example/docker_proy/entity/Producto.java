package com.example.docker_proy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @Column(name = "Id_Producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Tipo_Producto")
    private String tipoProducto;
    @Column(name = "Material")
    private Long material;
    @Column(name = "Num_Serie")
    private String numSerie;

     // Relación muchos a uno con Material
    @ManyToOne
    @JoinColumn(name = "Material", referencedColumnName = "Id_Material")
    private Material materials;

    // Relación muchos a uno con Maquina
    @ManyToOne
    @JoinColumn(name = "Num_Serie", referencedColumnName = "Num_Serie_Maq")
    private Maquina maquina;

    // Relación uno a muchos con DetalleCompra
    @OneToMany(mappedBy = "producto")
    private List<DetalleCompra> detallesCompra;

}
