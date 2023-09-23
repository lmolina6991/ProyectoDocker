package com.uptc.mapeo.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PERSONA")
public class Persona {
    @Id
    @Column(name = "Id_Persona")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    @Column(name = "Nombre_Persona")
    private String nombrePersona;
    @Column(name = "Apellido_Persona")
    private String apellidoPersona;
    @Column(name = "Fecha_Nacimiento")
    private Date fechaNacimiento;
    @OneToMany(mappedBy = "persona")
    private List<Proyecto> proyectos;
    @ManyToMany(mappedBy = "personas")
    private List<Proyecto> proyectospart;

    public Persona() {
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                ", nombrePersona='" + nombrePersona + '\'' +
                ", apellidoPersona='" + apellidoPersona + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
