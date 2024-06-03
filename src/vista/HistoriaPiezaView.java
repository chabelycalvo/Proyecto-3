package vista;

import modelo.HistoriaPieza;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HistoriaPiezaView extends JPanel {
    private JFrame parentFrame;
    private List<HistoriaPieza> historiasPiezas;

    public HistoriaPiezaView(JFrame parentFrame, List<HistoriaPieza> historiasPiezas) {
        this.parentFrame = parentFrame;
        this.historiasPiezas = historiasPiezas;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Historia de Piezas", SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JList<HistoriaPieza> historiaPiezaList = new JList<>(historiasPiezas.toArray(new HistoriaPieza[0]));
        JScrollPane scrollPane = new JScrollPane(historiaPiezaList);
        add(scrollPane, BorderLayout.CENTER);

        // Aquí se pueden agregar más componentes y funcionalidades para la visualización de la historia de las piezas
    }
}
