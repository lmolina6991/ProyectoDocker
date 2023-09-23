package com.uptc.mapeo.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "PATROCINADOR")
public class Patrocinador {
    @Id
    @Column(name = "Id_Patrocinador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatrocinador;
    @Column(name = "Nombre_Patrocinador")
    private String nombrePatrocinador;
    @OneToMany(mappedBy = "patrocinador")
    private List<Proyecto> proyectos;

    public Patrocinador() {
    }

    public Long getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(Long idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public String getNombrePatrocinador() {
        return nombrePatrocinador;
    }

    public void setNombrePatrocinador(String nombrePatrocinador) {
        this.nombrePatrocinador = nombrePatrocinador;
    }

    @Override
    public String toString() {
        return "Patrocinador{" +
                "idPatrocinador=" + idPatrocinador +
                ", nombrePatrocinador='" + nombrePatrocinador + '\'' +
                '}';
    }
}
