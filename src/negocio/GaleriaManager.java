package negocio;

import modelo.Galeria;
import modelo.Pieza;
import util.TxtUtil;

import java.util.List;

public class GaleriaManager {
    private Galeria galeria;

    public GaleriaManager(Galeria galeria) {
        this.galeria = galeria;
    }

    public void agregarPieza(Pieza pieza) {
        galeria.getPiezas().add(pieza);
        // Actualizar archivo de texto
        TxtUtil.guardarPiezas(galeria.getPiezas(), "data/piezas.txt");
    }

    public List<Pieza> listarPiezas() {
        return galeria.getPiezas();
    }

    // Otros métodos de gestión de la galería
}
