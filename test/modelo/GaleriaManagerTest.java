package test.modelo;

import modelo.Galería;
import modelo.Pieza;
import modelo.Pintura;
import modelo.Propietario;
import negocio.GaleriaManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GaleriaManagerTest {
    private GaleriaManager galeriaManager;
    private Galería galeria;

    @BeforeEach
    public void setUp() {
        galería = new Galería(1, "Galería de Prueba", "Calle Falsa 123", new ArrayList<>(), new ArrayList<>());
        galeriaManager = new GaleriaManager(galería);
    }

    @Test
    public void testAgregarPieza() {
        Propietario propietario = new Propietario(1, "Propietario 1", "email1@example.com", "1234567890", new ArrayList<>());
        Pieza pieza = new Pintura(1, "Pintura 1", "Descripción de la Pintura 1", "Autor 1", 1000.0, "2023-05-31", "Disponible", propietario, "Óleo", "30x40");

        galeriaManager.agregarPieza(pieza);

        List<Pieza> piezas = galeriaManager.listarPiezas();
        assertEquals(1, piezas.size());
        assertEquals("Pintura 1", piezas.get(0).getNombre());
    }
}
