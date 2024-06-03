package negocio;

import modelo.Comprador;
import modelo.Pago;
import modelo.PagoTarjetaCredito;
import util.TxtUtil;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Pago> getPagos() {
        return pagos;

    }

    public List<Pago> getPagosByComprador(Comprador comprador) {
        return pagos.stream()
                .filter(pago -> pago.getTransaccion().getComprador().equals(comprador))
                .collect(Collectors.toList());
    }

    // Otros métodos de gestión de pagos
}
