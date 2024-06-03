package vista;

import modelo.Pieza;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PiezaView extends JPanel {
    private JFrame parentFrame;
    private List<Pieza> piezas;

    public PiezaView(JFrame parentFrame, List<Pieza> piezas) {
        this.parentFrame = parentFrame;
        this.piezas = piezas;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Piezas de Arte", SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JList<Pieza> piezaList = new JList<>(piezas.toArray(new Pieza[0]));
        JScrollPane scrollPane = new JScrollPane(piezaList);
        add(scrollPane, BorderLayout.CENTER);

        // Aquí se pueden agregar más componentes y funcionalidades para la gestión de piezas
    }
}
