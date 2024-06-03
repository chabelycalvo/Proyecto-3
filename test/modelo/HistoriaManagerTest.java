package test.modelo;

import modelo.*;
import negocio.HistoriaManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoriaManagerTest {
    private HistoriaManager historiaManager;
    private List<HistoriaPieza> historiasPiezas;
    private List<HistoriaArtista> historiasArtistas;
    private List<HistoriaComprador> historiasCompradores;

    @BeforeEach
    public void setUp() {
        historiasPiezas = new ArrayList<>();
        historiasArtistas = new ArrayList<>();
        historiasCompradores = new ArrayList<>();
        historiaManager = new HistoriaManager(historiasPiezas, historiasArtistas, historiasCompradores);
    }

    @Test
    public void testObtenerHistoriaPieza() {
        Propietario propietario = new Propietario(1, "Propietario 1", "email1@example.com", "1234567890", new ArrayList<>());
        Pieza pieza = new Pintura(1, "Pintura 1", "Descripción de la Pintura 1", "Autor 1", 1000.0, "2023-05-31", "Disponible", propietario, "Óleo", "30x40");
        HistoriaPieza historiaPieza = new HistoriaPieza(1, pieza, new ArrayList<>(), new ArrayList<>());

        historiasPiezas.add(historiaPieza);

        HistoriaPieza result = historiaManager.obtenerHistoriaPieza(pieza);
        assertEquals(pieza.getNombre(), result.getPieza().getNombre());
    }
}
