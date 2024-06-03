package test.modelo;

import modelo.*;
import negocio.SubastaManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubastaManagerTest {
    private SubastaManager subastaManager;
    private List<Subasta> subastas;

    @BeforeEach
    public void setUp() {
        subastas = new ArrayList<>();
        subastaManager = new SubastaManager(subastas);
    }

    @Test
    public void testAgregarSubasta() {
        Propietario propietario = new Propietario(1, "Propietario 1", "email1@example.com", "1234567890", new ArrayList<>());
        Pieza pieza = new Pintura(1, "Pintura 1", "Descripción de la Pintura 1", "Autor 1", 1000.0, "2023-05-31", "Disponible", propietario, "Óleo", "30x40");
        Subasta subasta = new Subasta(1, pieza, new Date(), new Date(), new ArrayList<>(), null);

        subastaManager.agregarSubasta(subasta);

        assertEquals(1, subastas.size());
        assertEquals("Pintura 1", subastas.get(0).getPieza().getNombre());
    }
}
