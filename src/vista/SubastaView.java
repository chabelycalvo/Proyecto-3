package vista;

import modelo.Subasta;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SubastaView extends JPanel {
    private JFrame parentFrame;
    private List<Subasta> subastas;

    public SubastaView(JFrame parentFrame, List<Subasta> subastas) {
        this.parentFrame = parentFrame;
        this.subastas = subastas;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Subastas", SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JList<Subasta> subastaList = new JList<>(subastas.toArray(new Subasta[0]));
        JScrollPane scrollPane = new JScrollPane(subastaList);
        add(scrollPane, BorderLayout.CENTER);

        // Aquí se pueden agregar más componentes y funcionalidades para la gestión de subastas
    }
}
