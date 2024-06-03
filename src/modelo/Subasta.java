package modelo;

import java.util.Date;
import java.util.List;

public class Subasta {
    private int id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private int compradorId;
    private List<Pieza> piezas;
    private Comprador ganador;

    public Subasta(int id, String nombre, Date fechaInicio, Date fechaFin, int compradorId) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.compradorId = compradorId;
    }

    public Subasta(int id, Pieza pieza, Date fechaInicio, Date fechaFin, List<Pieza> piezas, Comprador ganador) {
        this.id = id;
        this.nombre = pieza.getNombre();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.piezas = piezas;
        this.ganador = ganador;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCompradorId() {
        return compradorId;
    }

    public void setCompradorId(int compradorId) {
        this.compradorId = compradorId;
    }

    public List<Pieza> getPiezas() {
        return piezas;
    }

    public void setPiezas(List<Pieza> piezas) {
        this.piezas = piezas;
    }

    public Comprador getGanador() {
        return ganador;
    }

    public void setGanador(Comprador ganador) {
        this.ganador = ganador;
    }

    public Pieza getPieza() {
        if (piezas != null && !piezas.isEmpty()) {
            return piezas.get(0); // Retorna la primera pieza, puedes ajustar esto según la lógica de tu
                                  // aplicación
        }
        return null;
    }

    public String getGanadorNombre() {
        return (ganador != null) ? ganador.getNombre() : "N/A";
    }
}
