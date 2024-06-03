package modelo;

import java.util.Date;
import java.util.List;

public class Subasta {
    private int id;
    private Pieza pieza;
    private Date fechaInicio;
    private Date fechaFin;
    private List<Oferta> ofertas;
    private Comprador ganador;
    private String nombre;
    private int compradorId;
    private int piezaId;


    public Subasta(int id, Pieza pieza, Date fechaInicio, Date fechaFin, List<Oferta> ofertas, Comprador ganador, String nombre, int compradorId, int piezaId) {
        this.id = id;
        this.pieza = pieza;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ofertas = ofertas;
        this.ganador = ganador;
    }

    // Getters y setters

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

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public Comprador getGanador() {
        return ganador;
    }

    public void setGanador(Comprador ganador) {
        this.ganador = ganador;
    }

    public void setPiezaId(int piezaId) {
        this.piezaId = piezaId;
    }

    public int getPiezaId() {
        return piezaId;
    }

    public void setCompradorId(int compradorId) {
        this.compradorId = compradorId;
    }

    public int getCompradorId() {
        return compradorId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }   
 }