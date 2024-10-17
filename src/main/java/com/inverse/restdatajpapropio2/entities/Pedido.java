package com.inverse.restdatajpapropio2.entities;

import jakarta.persistence.*;

@Entity
@Table(name="pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private String torta;
    private double precio;
    private String direccion;


    public Pedido() {
    }

    public Pedido(String cliente, String torta, double precio, String direccion) {
        this.cliente = cliente;
        this.torta = torta;
        this.precio = precio;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTorta() {
        return torta;
    }

    public void setTorta(String torta) {
        this.torta = torta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
