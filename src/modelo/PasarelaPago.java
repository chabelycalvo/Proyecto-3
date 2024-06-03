package modelo;

import java.util.List;

public class PasarelaPago {
    private int id;
    private String nombre;
    private List<Transaccion> transacciones;

    public PasarelaPago(int id, String nombre, List<Transaccion> transacciones) {
        this.id = id;
        this.nombre = nombre;
        this.transacciones = transacciones;
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

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }
}
