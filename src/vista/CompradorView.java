package vista;

import negocio.GaleriaManager;
import negocio.PagoManager;
import negocio.SubastaManager;

import javax.swing.*;
import java.awt.*;

public class CompradorView extends JFrame {
    public CompradorView(JFrame parentFrame, GaleriaManager galeriaManager, PagoManager pagoManager, SubastaManager subastaManager) {
        setTitle("Vista del Comprador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Bienvenido, Comprador", SwingConstants.CENTER);
        panel.add(label, BorderLayout.NORTH);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuComprador = new JMenu("Comprador");
        JMenuItem menuItemVerPiezas = new JMenuItem("Ver Piezas");
        JMenuItem menuItemSubastas = new JMenuItem("Participar en Subastas");
        JMenuItem menuItemHistorial = new JMenuItem("Historial de Compras");
        JMenuItem menuItemPerfil = new JMenuItem("Perfil");

        menuComprador.add(menuItemVerPiezas);
        menuComprador.add(menuItemSubastas);
        menuComprador.add(menuItemHistorial);
        menuComprador.add(menuItemPerfil);
        menuBar.add(menuComprador);

        setJMenuBar(menuBar);
        add(panel);
        setVisible(true);
    }
}
