package modelo;

import java.util.Date;

public class Oferta {
    private int id;
    private Subasta subasta;
    private Comprador comprador;
    private double monto;
    private Date fechaOferta;

    public Oferta(int id, Subasta subasta, Comprador comprador, double monto, Date fechaOferta) {
        this.id = id;
        this.subasta = subasta;
        this.comprador = comprador;
        this.monto = monto;
        this.fechaOferta = fechaOferta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaOferta() {
        return fechaOferta;
    }

    public void setFechaOferta(Date fechaOferta) {
        this.fechaOferta = fechaOferta;
    }
}
