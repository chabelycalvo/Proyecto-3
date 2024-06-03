package modelo;

public class PagoTarjetaCredito extends Pago {
    private String tarjeta;
    private String nombreTitular;
    private String fechaExpiracion;
    private String codigoSeguridad;

    public PagoTarjetaCredito(int id, Transaccion transaccion, double monto, String fechaPago, String metodoPago, String estado,
                              String tarjeta, String nombreTitular, String fechaExpiracion, String codigoSeguridad) {
        super(id, transaccion, monto, fechaPago, metodoPago, estado);
        this.tarjeta = tarjeta;
        this.nombreTitular = nombreTitular;
        this.fechaExpiracion = fechaExpiracion;
        this.codigoSeguridad = codigoSeguridad;
    }

    // Getters y setters adicionales para los campos de tarjeta de crédito
    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }
}
