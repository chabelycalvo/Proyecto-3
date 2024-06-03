package vista;

import modelo.HistoriaComprador;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HistoriaCompradorView extends JPanel {
    private JFrame parentFrame;
    private List<HistoriaComprador> historiasCompradores;

    public HistoriaCompradorView(JFrame parentFrame, List<HistoriaComprador> historiasCompradores) {
        this.parentFrame = parentFrame;
        this.historiasCompradores = historiasCompradores;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Historia de Compradores", SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JList<HistoriaComprador> historiaCompradorList = new JList<>(historiasCompradores.toArray(new HistoriaComprador[0]));
        JScrollPane scrollPane = new JScrollPane(historiaCompradorList);
        add(scrollPane, BorderLayout.CENTER);

        // Aquí se pueden agregar más componentes y funcionalidades para la visualización de la historia de los compradores
    }
}
