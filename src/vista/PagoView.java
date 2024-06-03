package vista;

import modelo.Pago;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PagoView extends JPanel {
    private JFrame parentFrame;
    private List<Pago> pagos;

    public PagoView(JFrame parentFrame, List<Pago> pagos) {
        this.parentFrame = parentFrame;
        this.pagos = pagos;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Pagos", SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JList<Pago> pagoList = new JList<>(pagos.toArray(new Pago[0]));
        JScrollPane scrollPane = new JScrollPane(pagoList);
        add(scrollPane, BorderLayout.CENTER);

        // Aquí se pueden agregar más componentes y funcionalidades para la gestión de pagos
    }
}
