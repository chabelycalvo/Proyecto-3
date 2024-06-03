package modelo;

import java.util.List;

public class Propietario {
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private List<Pieza> piezas;

    public Propietario(int id, String nombre, String email, String telefono, List<Pieza> piezas) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Pieza> getPiezas() {
        return piezas;
    }

    public void setPiezas(List<Pieza> piezas) {
        this.piezas = piezas;
    }
}
