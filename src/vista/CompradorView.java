package vista;

import negocio.GaleriaManager;
import negocio.PagoManager;
import negocio.SubastaManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        // Acción para "Ver Piezas"
        menuItemVerPiezas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para ver las piezas disponibles
                verPiezas(galeriaManager);
            }
        });

        // Acción para "Participar en Subastas"
        menuItemSubastas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para participar en subastas
                participarEnSubastas(subastaManager);
            }
        });

        // Acción para "Historial de Compras"
        menuItemHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para ver el historial de compras
                verHistorialCompras();
            }
        });

        // Acción para "Perfil"
        menuItemPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para ver y editar el perfil del comprador
                verPerfil();
            }
        });
    }

    private void verPiezas(GaleriaManager galeriaManager) {
        // Implementar lógica para mostrar las piezas disponibles en la galería
        JOptionPane.showMessageDialog(this, "Mostrando las piezas disponibles...");
    }

    private void participarEnSubastas(SubastaManager subastaManager) {
        // Implementar lógica para mostrar y participar en las subastas
        JOptionPane.showMessageDialog(this, "Participando en subastas...");
    }

    private void verHistorialCompras() {
        // Implementar lógica para mostrar el historial de compras del comprador
        JOptionPane.showMessageDialog(this, "Mostrando el historial de compras...");
    }

    private void verPerfil() {
        // Implementar lógica para mostrar y editar el perfil del comprador
        JOptionPane.showMessageDialog(this, "Mostrando el perfil del comprador...");
    }
}
