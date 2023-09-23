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
@Table(name = "maquina")
public class Maquina {
    @Id
    @Column(name = "Num_Serie_Maq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String numSerieMaq;
    @Column(name = "Marca")
    private String marca;
    @Column(name = "Modelo")
    private String modelo;
    @Column(name = "Fecha_Compra")
    private Date fechaCompra;

}
