package negocio;

import modelo.Subasta;

import java.util.List;

public class SubastaManager {
    private List<Subasta> subastas;

    public SubastaManager(List<Subasta> subastas) {
        this.subastas = subastas;
    }

    public List<Subasta> getSubastas() {
        return subastas;
    }

    public void addSubasta(Subasta subasta) {
        subastas.add(subasta);
    }

    public void removeSubasta(Subasta subasta) {
        subastas.remove(subasta);
    }

    public Subasta findSubastaById(int id) {
        for (Subasta subasta : subastas) {
            if (subasta.getId() == id) {
                return subasta;
            }
        }
        return null;
    }

    public void updateSubasta(Subasta subasta) {
        Subasta existingSubasta = findSubastaById(subasta.getId());
        if (existingSubasta != null) {
            existingSubasta.setNombre(subasta.getNombre());
            existingSubasta.setFechaInicio(subasta.getFechaInicio());
            existingSubasta.setFechaFin(subasta.getFechaFin());
            existingSubasta.setCompradorId(subasta.getCompradorId());
        }
    }
}
