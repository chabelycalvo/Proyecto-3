package modelo;

import java.util.Date;

public class Transaccion {
    private int id;
    private Pieza pieza;
    private Comprador comprador;
    private Date fechaTransaccion;
    private String tipoTransaccion;
    private double monto;
    private String estado;
    private Empleado empleado;

    public Transaccion(int id, Pieza pieza, Comprador comprador, Date fechaTransaccion, String tipoTransaccion, double monto, String estado, Empleado empleado) {
        this.id = id;
        this.pieza = pieza;
        this.comprador = comprador;
        this.fechaTransaccion = fechaTransaccion;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.estado = estado;
        this.empleado = empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
