package model;

public class Factura {

    private int id_cliente;
    private String fecha;

    public Factura(){

    }

    public Factura(int id_cliente, String fecha) {
        this.id_cliente = id_cliente;
        this.fecha = fecha;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
