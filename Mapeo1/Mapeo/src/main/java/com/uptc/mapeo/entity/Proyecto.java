package com.uptc.mapeo.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PROYECTO")
public class Proyecto {
    @Id
    @Column(name = "Id_Proyecto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProyecto;
    @Column(name = "Fecha_Inicio")
    private Date fechaInicio;
    @Column(name = "Fecha_Fin")
    private Date fechaFin;
    @Column(name = "Presupuesto")
    private Double presupuesto;
    @ManyToOne
    @JoinColumn(name = "ID_PERSONA", nullable = false)
    private Persona persona;
    @ManyToMany
    @JoinTable(
            name = "PERSONAS_PROYECTO",
            joinColumns = @JoinColumn(name = "ID_PROYECTO"),
            inverseJoinColumns = @JoinColumn(name = "ID_PERDSONA")
    )
    private List<Persona> personas;
    @ManyToOne
    @JoinColumn(name = "ID_PATROCINADOR", nullable = false)
    private Patrocinador patrocinador;

    public Proyecto() {
    }

    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "idProyecto=" + idProyecto +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", presupuesto=" + presupuesto +
                '}';
    }
}
