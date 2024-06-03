package modelo;

public class Pieza {
    private int id;
    private String nombre;
    private String descripcion;
    private String autor;
    private double precio;
    private String fechaCreacion;
    private String estado;
    private Propietario propietario;

    public Pieza(int id, String nombre, String descripcion, String autor, double precio, String fechaCreacion, String estado, Propietario propietario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.autor = autor;
        this.precio = precio;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.propietario = propietario;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
}
