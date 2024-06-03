package negocio;

import modelo.HistoriaPieza;
import modelo.HistoriaArtista;
import modelo.HistoriaComprador;
import modelo.Pieza;
import modelo.Artista;
import modelo.Comprador;

import java.util.List;

public class HistoriaManager {
    private List<HistoriaPieza> historiasPiezas;
    private List<HistoriaArtista> historiasArtistas;
    private List<HistoriaComprador> historiasCompradores;

    public HistoriaManager(List<HistoriaPieza> historiasPiezas, List<HistoriaArtista> historiasArtistas, List<HistoriaComprador> historiasCompradores) {
        this.historiasPiezas = historiasPiezas;
        this.historiasArtistas = historiasArtistas;
        this.historiasCompradores = historiasCompradores;
    }

    public HistoriaPieza obtenerHistoriaPieza(Pieza pieza) {
        return historiasPiezas.stream().filter(historia -> historia.getPieza().equals(pieza)).findFirst().orElse(null);
    }

    public HistoriaArtista obtenerHistoriaArtista(Artista artista) {
        return historiasArtistas.stream().filter(historia -> historia.getArtista().equals(artista)).findFirst().orElse(null);
    }

    public HistoriaComprador obtenerHistoriaComprador(Comprador comprador) {
        return historiasCompradores.stream().filter(historia -> historia.getComprador().equals(comprador)).findFirst().orElse(null);
    }

    // Otros métodos de gestión de historias
}
