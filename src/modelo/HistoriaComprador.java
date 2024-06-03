package modelo;

import java.util.List;

public class HistoriaComprador {
    private int id;
    private Comprador comprador;
    private List<Transaccion> compras;
    private double valorColeccion;

    public HistoriaComprador(int id, Comprador comprador, List<Transaccion> compras, double valorColeccion) {
        this.id = id;
        this.comprador = comprador;
        this.compras = compras;
        this.valorColeccion = valorColeccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public List<Transaccion> getCompras() {
        return compras;
    }

    public void setCompras(List<Transaccion> compras) {
        this.compras = compras;
    }

    public double getValorColeccion() {
        return valorColeccion;
    }

    public void setValorColeccion(double valorColeccion) {
        this.valorColeccion = valorColeccion;
    }
}
