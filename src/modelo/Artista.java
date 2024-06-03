package modelo;

import java.util.List;

public class Artista {
    private int id;
    private String nombre;
    private String biografia;
    private List<Pieza> piezas;

    public Artista(int id, String nombre, String biografia, List<Pieza> piezas) {
        this.id = id;
        this.nombre = nombre;
        this.biografia = biografia;
        this.piezas = piezas;
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

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public List<Pieza> getPiezas() {
        return piezas;
    }

    public void setPiezas(List<Pieza> piezas) {
        this.piezas = piezas;
    }
}
