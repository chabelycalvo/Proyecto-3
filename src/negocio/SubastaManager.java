package negocio;

import modelo.Subasta;
import modelo.Oferta;
import util.TxtUtil;

import java.util.List;

public class SubastaManager {
    private List<Subasta> subastas;

    public SubastaManager(List<Subasta> subastas) {
        this.subastas = subastas;
    }

    public void agregarSubasta(Subasta subasta) {
        subastas.add(subasta);
        // Actualizar archivo de texto
        TxtUtil.guardarSubastas(subastas, "data/subastas.txt");
    }

    public void agregarOferta(Subasta subasta, Oferta oferta) {
        subasta.getOfertas().add(oferta);
        // Actualizar archivo de texto
        TxtUtil.guardarSubastas(subastas, "data/subastas.txt");
    }

    public Subasta obtenerSubastaPorId(int id) {
        return subastas.stream().filter(subasta -> subasta.getId() == id).findFirst().orElse(null);
    }

    // Otros métodos de gestión de subastas
}