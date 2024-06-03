package test.modelo;

import modelo.*;
import negocio.PagoManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagoManagerTest {
    private PagoManager pagoManager;
    private List<Pago> pagos;

    @BeforeEach
    public void setUp() {
        pagos = new ArrayList<>();
        pagoManager = new PagoManager(pagos);
    }

    @Test
    public void testProcesarPago() {
        Propietario propietario = new Propietario(1, "Propietario 1", "email1@example.com", "1234567890", new ArrayList<>());
        Comprador comprador = new Comprador(1, "Comprador 1", "comprador1@example.com", "0987654321", new ArrayList<>());
        Pieza pieza = new Pintura(1, "Pintura 1", "Descripción de la Pintura 1", "Autor 1", 1000.0, "2023-05-31", "Disponible", propietario, "Óleo", "30x40");
        Transacción transaccion = new Transaccion(1, pieza, comprador, new Date(), "Compra Directa", 1000.0, "Completada");
        Pago pago = new Pago(1, transacción, 1000.0, "2023-05-31", "Tarjeta de Crédito", "Completado");

        pagoManager.procesarPago(pago);

        assertEquals(1, pagos.size());
        assertEquals(1000.0, pagos.get(0).getMonto());
    }
}
