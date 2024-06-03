package vista;

import negocio.GaleriaManager;
import negocio.PagoManager;
import negocio.SubastaManager;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JFrame {
    public AdminView(JFrame parentFrame, GaleriaManager galeriaManager, PagoManager pagoManager, SubastaManager subastaManager) {
        setTitle("Vista del Administrador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Bienvenido, Administrador", SwingConstants.CENTER);
        panel.add(label, BorderLayout.NORTH);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuGestion = new JMenu("Gestión");
        JMenuItem menuItemPiezas = new JMenuItem("Gestionar Piezas");
        JMenuItem menuItemSubastas = new JMenuItem("Gestionar Subastas");
        JMenuItem menuItemPagos = new JMenuItem("Gestionar Pagos");
        JMenuItem menuItemUsuarios = new JMenuItem("Gestionar Usuarios");
        JMenuItem menuItemReportes = new JMenuItem("Reportes");

        menuGestion.add(menuItemPiezas);
        menuGestion.add(menuItemSubastas);
        menuGestion.add(menuItemPagos);
        menuGestion.add(menuItemUsuarios);
        menuGestion.add(menuItemReportes);
        menuBar.add(menuGestion);

        setJMenuBar(menuBar);
        add(panel);
        setVisible(true);
    }
}
