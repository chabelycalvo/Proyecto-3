package modelo;

public class Escultura extends Pieza {
    private String material;
    private double peso;

    public Escultura(int id, String nombre, String descripcion, String autor, double precio, String fechaCreacion, String estado, Propietario propietario, String material, double peso) {
        super(id, nombre, descripcion, autor, precio, fechaCreacion, estado, propietario);
        this.material = material;
        this.peso = peso;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
