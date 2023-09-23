package com.example.docker_proy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="asignacion_maquina")
public class AsignacionMaquina {
    @Id
    @Column(name = "Id_Maquina")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Num_Serie")
    private String numSerie;
    @Column(name = "Id_Trabajador")
    private Long idTrabajador;

    @ManyToOne
    @JoinColumn(name = "Num_Serie", referencedColumnName = "Num_Serie_Maq")
    private Maquina maquina;
    
    @ManyToOne
    @JoinColumn(name = "Id_Trabajador")
    private Trabajador trabajador;

}
