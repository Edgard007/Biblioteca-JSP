
package com.modelo;

/**
 * Nombre de la clase: Carrito
 * Fecha: 09-11-2019
 * Version: 1.0
 * Copyriht: Denis Valladares
 * @author Denis Valladares
 */
public class Carrito {
    private int idLibro;
    private String nombre;
    private String editorial;
    private String autor;
    private int cantidad;
    private double precio;
    private double subtotal;
    private int idCliente;
    private int stock;
    private boolean fisico;
    private boolean digital;

    public Carrito() {
    }

    public Carrito(int idLibro, String nombre, String editorial, String autor, int cantidad, double precio, double subtotal, int idCliente, int stock, boolean fisico, boolean digital) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.idCliente = idCliente;
        this.stock = stock;
        this.fisico = fisico;
        this.digital = digital;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isFisico() {
        return fisico;
    }

    public void setFisico(boolean fisico) {
        this.fisico = fisico;
    }

    public boolean isDigital() {
        return digital;
    }

    public void setDigital(boolean digital) {
        this.digital = digital;
    }
}
