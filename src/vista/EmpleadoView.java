package vista;

import negocio.GaleriaManager;
import negocio.PagoManager;
import negocio.SubastaManager;
import modelo.Empleado;

import javax.swing.*;
import java.awt.*;

public class EmpleadoView extends JFrame {
    private Empleado empleado;
    private GaleriaManager galeriaManager;
    private PagoManager pagoManager;
    private SubastaManager subastaManager;

    public EmpleadoView(JFrame parentFrame, GaleriaManager galeriaManager, PagoManager pagoManager, SubastaManager subastaManager, Empleado empleado) {
        this.galeriaManager = galeriaManager;
        this.pagoManager = pagoManager;
        this.subastaManager = subastaManager;
        this.empleado = empleado;

        setTitle("Vista del Empleado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Bienvenido, " + empleado.getNombre(), SwingConstants.CENTER);
        panel.add(label, BorderLayout.NORTH);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuEmpleado = new JMenu("Empleado");
        JMenuItem menuItemVerPiezas = new JMenuItem("Ver Piezas");
        JMenuItem menuItemGestionSubastas = new JMenuItem("Gestionar Subastas");
        JMenuItem menuItemHistorialTransacciones = new JMenuItem("Historial de Transacciones");
        JMenuItem menuItemPerfil = new JMenuItem("Perfil");

        menuEmpleado.add(menuItemVerPiezas);
        menuEmpleado.add(menuItemGestionSubastas);
        menuEmpleado.add(menuItemHistorialTransacciones);
        menuEmpleado.add(menuItemPerfil);
        menuBar.add(menuEmpleado);

        setJMenuBar(menuBar);
        add(panel);
        setVisible(true);
    }
}
