package model;

public class Producto {

    private int id_producto;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(){

    }

    public Producto(int id_producto, String nombre, double precio, int stock) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
