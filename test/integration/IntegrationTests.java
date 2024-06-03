package test.integration;

import modelo.*;
import negocio.GaleriaManager;
import negocio.SubastaManager;
import negocio.PagoManager;
import negocio.HistoriaManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTests {
    private GaleriaManager galeriaManager;
    private SubastaManager subastaManager;
    private PagoManager pagoManager;
    private HistoriaManager historiaManager;

    private Galeria galeria;
    private List<Subasta> subastas;
    private List<Pago> pagos;
    private List<HistoriaPieza> historiasPiezas;
    private List<HistoriaArtista> historiasArtistas;
    private List<HistoriaComprador> historiasCompradores;

    @BeforeEach
    public void setUp() {
        galería = new Galería(1, "Galería de Prueba", "Calle Falsa 123", new ArrayList<>(), new ArrayList<>());
        subastas = new ArrayList<>();
        pagos = new ArrayList<>();
        historiasPiezas = new ArrayList<>();
        historiasArtistas = new ArrayList<>();
        historiasCompradores = new ArrayList<>();

        galeriaManager = new GaleriaManager(galería);
        subastaManager = new SubastaManager(subastas);
        pagoManager = new PagoManager(pagos);
        historiaManager = new HistoriaManager(historiasPiezas, historiasArtistas, historiasCompradores);
    }

    @Test
    public void testIntegracionCompleta() {
        Propietario propietario = new Propietario(1, "Propietario 1", "email1@example.com", "1234567890", new ArrayList<>());
        Comprador comprador = new Comprador(1, "Comprador 1", "comprador1@example.com", "0987654321", new ArrayList<>());
        Pieza pieza = new Pintura(1, "Pintura 1", "Descripción de la Pintura 1", "Autor 1", 1000.0, "2023-05-31", "Disponible", propietario, "Óleo", "30x40");
        Transacción transaccion = new Transaccion(1, pieza, comprador, new Date(), "Compra Directa", 1000.0, "Completada");
        Pago pago = new Pago(1, transaccion, 1000.0, "2023-05-31", "Tarjeta de Crédito", "Completado");
        Subasta subasta = new Subasta(1, pieza, new Date(), new Date(), new ArrayList<>(), comprador);
        HistoriaPieza historiaPieza = new HistoriaPieza(1, pieza, new ArrayList<>(), new ArrayList<>());

        // Agregar y verificar piezas
        galeriaManager.agregarPieza(pieza);
        assertEquals(1, galeriaManager.listarPiezas().size());

        // Agregar y verificar subasta
        subastaManager.agregarSubasta(subasta);
        assertEquals(1, subastaManager.obtenerSubastaPorId(1).getId());

        // Procesar y verificar pago
        pagoManager.procesarPago(pago);
        assertEquals(1, pagos.size());

        // Agregar y verificar historia de pieza
        historiasPiezas.add(historiaPieza);
        assertEquals(pieza.getNombre(), historiaManager.obtenerHistoriaPieza(pieza).getPieza().getNombre());
    }
}
