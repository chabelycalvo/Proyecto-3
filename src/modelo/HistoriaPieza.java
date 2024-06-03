package modelo;

import java.util.List;

public class HistoriaPieza {
    private int id;
    private Pieza pieza;
    private List<Propietario> propietarios;
    private List<Transaccion> transacciones;

    public HistoriaPieza(int id, Pieza pieza, List<Propietario> propietarios, List<Transaccion> transacciones) {
        this.id = id;
        this.pieza = pieza;
        this.propietarios = propietarios;
        this.transacciones = transacciones;
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

    public List<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(List<Propietario> propietarios) {
        this.propietarios = propietarios;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }
}
