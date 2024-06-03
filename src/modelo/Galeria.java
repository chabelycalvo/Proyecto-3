package modelo;

import java.util.List;

public class Galeria {
    private int id;
    private String nombre;
    private String direccion;
    private List<Pieza> piezas;
    private List<Propietario> propietarios;

    public Galeria(int id, String nombre, String direccion, List<Pieza> piezas, List<Propietario> propietarios) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.piezas = piezas;
        this.propietarios = propietarios;
    }

    // Getters y setters

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Pieza> getPiezas() {
        return piezas;
    }

    public void setPiezas(List<Pieza> piezas) {
        this.piezas = piezas;
    }

    public List<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(List<Propietario> propietarios) {
        this.propietarios = propietarios;
    }
}
