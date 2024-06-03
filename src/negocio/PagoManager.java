package negocio;

import modelo.Pago;
import modelo.PagoTarjetaCredito;
import util.TxtUtil;

import java.util.List;

public class PagoManager {
    private List<Pago> pagos;

    public PagoManager(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public void procesarPago(Pago pago) {
        pagos.add(pago);
        // Actualizar archivo de texto
        TxtUtil.guardarPagos(pagos, "data/pagos.txt");
    }

    public void procesarPagoTarjeta(PagoTarjetaCredito pagoTarjeta) {
        pagos.add(pagoTarjeta);
        // Actualizar archivo de texto
        TxtUtil.guardarPagos(pagos, "data/pagos.txt");
    }

    // Otros métodos de gestión de pagos
}
