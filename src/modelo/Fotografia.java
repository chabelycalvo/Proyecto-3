package modelo;

public class Fotografia extends Pieza {
    private String tipo;
    private String tamanio;

    public Fotografia(int id, String nombre, String descripcion, String autor, double precio, String fechaCreacion, String estado, Propietario propietario, String tipo, String tamanio) {
        super(id, nombre, descripcion, autor, precio, fechaCreacion, estado, propietario);
        this.tipo = tipo;
        this.tamanio = tamanio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }
}
