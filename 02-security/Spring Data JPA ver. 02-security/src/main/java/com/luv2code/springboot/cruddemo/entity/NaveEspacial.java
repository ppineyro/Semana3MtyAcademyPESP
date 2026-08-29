package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="nave_espacial")
public class NaveEspacial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="modelo")
    private String modelo;

    @Column(name="capacidad_tripulacion")
    private int capacidadTripulacion;

    public NaveEspacial() {
    }

    public NaveEspacial(String nombre, String modelo, int capacidadTripulacion) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.capacidadTripulacion = capacidadTripulacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidadTripulacion() {
        return capacidadTripulacion;
    }

    public void setCapacidadTripulacion(int capacidadTripulacion) {
        this.capacidadTripulacion = capacidadTripulacion;
    }

    @Override
    public String toString() {
        return "NaveEspacial{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", modelo='" + modelo + '\'' +
                ", capacidadTripulacion=" + capacidadTripulacion +
                '}';
    }
}