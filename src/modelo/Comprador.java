package modelo;

import java.util.List;

public class Comprador {
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private List<Transaccion> historialCompras;
    private String contrasenia;

    public Comprador(int id, String nombre, String email, String telefono, List<Transaccion> historialCompras, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.historialCompras = historialCompras;
        this.contrasenia = contrasenia;
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

    public List<Transaccion> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(List<Transaccion> historialCompras) {
        this.historialCompras = historialCompras;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
