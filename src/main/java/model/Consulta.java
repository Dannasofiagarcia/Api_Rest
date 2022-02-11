package model;

public class Consulta {

    private int num_factura;
    private int id_cliente;
    private int cantidad;
    private double total_factura;
    private double totalcon_descuento;

    public Consulta() {

    }

    public Consulta(int num_factura, int id_cliente, int cantidad, double total_factura, double totalcon_descuento) {
        this.num_factura = num_factura;
        this.id_cliente = id_cliente;
        this.cantidad = cantidad;
        this.total_factura = total_factura;
        this.totalcon_descuento = totalcon_descuento;
    }

    public int getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(int num_factura) {
        this.num_factura = num_factura;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal_factura() {
        return total_factura;
    }

    public void setTotal_factura(double total_factura) {
        this.total_factura = total_factura;
    }

    public double getTotal_descuento() {
        return totalcon_descuento;
    }

    public void setTotal_descuento(double total_descuento) {
        this.totalcon_descuento = total_descuento;
    }
}
