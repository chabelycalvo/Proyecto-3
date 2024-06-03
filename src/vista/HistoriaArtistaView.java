package vista;

import modelo.HistoriaArtista;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HistoriaArtistaView extends JPanel {
    private JFrame parentFrame;
    private List<HistoriaArtista> historiasArtistas;

    public HistoriaArtistaView(JFrame parentFrame, List<HistoriaArtista> historiasArtistas) {
        this.parentFrame = parentFrame;
        this.historiasArtistas = historiasArtistas;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Historia de Artistas", SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JList<HistoriaArtista> historiaArtistaList = new JList<>(historiasArtistas.toArray(new HistoriaArtista[0]));
        JScrollPane scrollPane = new JScrollPane(historiaArtistaList);
        add(scrollPane, BorderLayout.CENTER);

        // Aquí se pueden agregar más componentes y funcionalidades para la visualización de la historia de los artistas
    }
}
