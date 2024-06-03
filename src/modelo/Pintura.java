package modelo;

public class Pintura extends Pieza {
    private String tecnica;
    private String dimensiones;

    public Pintura(int id, String nombre, String descripcion, String autor, double precio, String fechaCreacion, String estado, Propietario propietario, String tecnica, String dimensiones) {
        super(id, nombre, descripcion, autor, precio, fechaCreacion, estado, propietario);
        this.tecnica = tecnica;
        this.dimensiones = dimensiones;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }
}
