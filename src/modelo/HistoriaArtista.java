package modelo;

import java.util.List;

public class HistoriaArtista {
    private int id;
    private Artista artista;
    private List<Pieza> piezas;
    private List<Transaccion> ventas;

    public HistoriaArtista(int id, Artista artista, List<Pieza> piezas, List<Transaccion> ventas) {
        this.id = id;
        this.artista = artista;
        this.piezas = piezas;
        this.ventas = ventas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public List<Pieza> getPiezas() {
        return piezas;
    }

    public void setPiezas(List<Pieza> piezas) {
        this.piezas = piezas;
    }

    public List<Transaccion> getVentas() {
        return ventas;
    }

    public void setVentas(List<Transaccion> ventas) {
        this.ventas = ventas;
    }
}
