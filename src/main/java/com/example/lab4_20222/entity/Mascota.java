package com.example.lab4_20222.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mascota")
public class Mascota {
    @Id
    @Column(name = "idmascota", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Size(max = 45)
    @NotNull
    @Column(name = "anho", nullable = false, length = 45)
    private String anho;

    @NotNull
    @Lob
    @Column(name = "historia", nullable = false)
    private String historia;

    @NotNull
    @Lob
    @Column(name = "observaciones", nullable = false)
    private String observaciones;

    @Size(max = 45)
    @NotNull
    @Column(name = "sexo", nullable = false, length = 45)
    private String sexo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "raza_especie_idraza", nullable = false)
    private RazaEspecie razaEspecieIdraza;

    @Size(max = 45)
    @Column(name = "raza_otros", length = 45)
    private String razaOtros;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_idcuenta")
    private Cuenta cuentaIdcuenta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public RazaEspecie getRazaEspecieIdraza() {
        return razaEspecieIdraza;
    }

    public void setRazaEspecieIdraza(RazaEspecie razaEspecieIdraza) {
        this.razaEspecieIdraza = razaEspecieIdraza;
    }

    public String getRazaOtros() {
        return razaOtros;
    }

    public void setRazaOtros(String razaOtros) {
        this.razaOtros = razaOtros;
    }

    public Cuenta getCuentaIdcuenta() {
        return cuentaIdcuenta;
    }

    public void setCuentaIdcuenta(Cuenta cuentaIdcuenta) {
        this.cuentaIdcuenta = cuentaIdcuenta;
    }

}