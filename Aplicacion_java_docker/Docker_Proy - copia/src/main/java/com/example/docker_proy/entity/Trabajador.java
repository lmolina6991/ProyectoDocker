package com.example.docker_proy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "trabajador")
public class Trabajador {
    @Id
    @Column(name = "Id_trabajador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Fecha_Nacimiento")
    private Date fechaNacimiento;
    @Column(name = "Direccion")
    private String direccion;

}

