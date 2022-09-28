package com.example.lab4_20222.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "opcion_servicio")
public class OpcionServicio {
    @Id
    @Column(name = "idopcion_servicio", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "opcion_idopcion", nullable = false)
    private Opcion opcionIdopcion;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "servicio_idservicio", nullable = false)
    private Servicio servicioIdservicio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Opcion getOpcionIdopcion() {
        return opcionIdopcion;
    }

    public void setOpcionIdopcion(Opcion opcionIdopcion) {
        this.opcionIdopcion = opcionIdopcion;
    }

    public Servicio getServicioIdservicio() {
        return servicioIdservicio;
    }

    public void setServicioIdservicio(Servicio servicioIdservicio) {
        this.servicioIdservicio = servicioIdservicio;
    }

}