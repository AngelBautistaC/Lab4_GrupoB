package com.example.lab4_20222.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "raza_especie")
public class RazaEspecie {
    @Id
    @Column(name = "idraza", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "descripcion", nullable = false, length = 45)
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}