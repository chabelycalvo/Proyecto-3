package modelo;

public class Empleado {
    private int id;
    private String nombre;
    private String contrasenia;

    public Empleado(int id, String nombre, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
