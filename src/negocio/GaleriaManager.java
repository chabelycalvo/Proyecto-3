package negocio;

import modelo.Comprador;
import modelo.Galeria;
import modelo.Pieza;
import util.TxtUtil;

import java.util.ArrayList;
import java.util.List;

public class GaleriaManager {
    private Galeria galeria;

    public GaleriaManager(Galeria galeria) {
        this.galeria = galeria;
    }

    public List<Pieza> getPiezas() {
        return galeria.getPiezas();
    }

    public void addPieza(Pieza pieza) {
        galeria.getPiezas().add(pieza);
    }

    public void removePieza(Pieza pieza) {
        galeria.getPiezas().remove(pieza);
    }

    public Pieza findPiezaById(int id) {
        for (Pieza pieza : galeria.getPiezas()) {
            if (pieza.getId() == id) {
                return pieza;
            }
        }
        return null;
    }

    public List<Pieza> getPiezasDisponibles() {
        List<Pieza> piezasDisponibles = new ArrayList<>();
        for (Pieza pieza : galeria.getPiezas()) {
            if ("Disponible".equalsIgnoreCase(pieza.getEstado())) {
                piezasDisponibles.add(pieza);
            }
        }
        return piezasDisponibles;
    }

    public void updatePieza(Pieza piezaActualizada) {
        Pieza pieza = findPiezaById(piezaActualizada.getId());
        if (pieza != null) {
            pieza.setNombre(piezaActualizada.getNombre());
            pieza.setDescripcion(piezaActualizada.getDescripcion());
            pieza.setPrecio(piezaActualizada.getPrecio());
            pieza.setEstado(piezaActualizada.getEstado());
            // Actualizar otros atributos según sea necesario
        }
    }

    public Galeria getGaleria() {
        return galeria;
    }

    public void updateComprador(Comprador comprador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateComprador'");
    }
}
