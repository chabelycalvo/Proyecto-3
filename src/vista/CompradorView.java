package vista;

import modelo.Comprador;
import modelo.Pieza;
import modelo.Subasta;
import negocio.GaleriaManager;
import negocio.PagoManager;
import negocio.SubastaManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CompradorView extends JFrame {
    private Comprador comprador;
    private GaleriaManager galeriaManager;
    private PagoManager pagoManager;
    private SubastaManager subastaManager;

    public CompradorView(JFrame parentFrame, GaleriaManager galeriaManager, PagoManager pagoManager,
            SubastaManager subastaManager, Comprador comprador) {
        this.comprador = comprador;
        this.galeriaManager = galeriaManager;
        this.pagoManager = pagoManager;
        this.subastaManager = subastaManager;

        setTitle("Vista del Comprador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Bienvenido, " + comprador.getNombre(), SwingConstants.CENTER);
        panel.add(label, BorderLayout.NORTH);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuComprador = new JMenu("Comprador");
        JMenuItem menuItemVerPiezas = new JMenuItem("Ver Piezas");
        JMenuItem menuItemSubastas = new JMenuItem("Participar en Subastas");
        JMenuItem menuItemHistorial = new JMenuItem("Historial de Compras");
        JMenuItem menuItemPerfil = new JMenuItem("Perfil");

        menuItemVerPiezas.addActionListener(e -> new VerPiezasView(galeriaManager).setVisible(true));
        menuItemSubastas.addActionListener(e -> new ParticiparSubastasView(subastaManager).setVisible(true));
        menuItemHistorial.addActionListener(e -> new HistorialComprasView(pagoManager, comprador).setVisible(true));
        menuItemPerfil.addActionListener(e -> new PerfilView(comprador, galeriaManager).setVisible(true));

        menuComprador.add(menuItemVerPiezas);
        menuComprador.add(menuItemSubastas);
        menuComprador.add(menuItemHistorial);
        menuComprador.add(menuItemPerfil);
        menuBar.add(menuComprador);

        setJMenuBar(menuBar);
        add(panel);
        setVisible(true);
    }

    private void showPiezas() {
        List<Pieza> piezas = galeriaManager.getGaleria().getPiezas();
        String[] columnNames = { "ID", "Nombre", "Descripción", "Autor", "Precio" };
        Object[][] data = new Object[piezas.size()][5];
        for (int i = 0; i < piezas.size(); i++) {
            Pieza pieza = piezas.get(i);
            data[i][0] = pieza.getId();
            data[i][1] = pieza.getNombre();
            data[i][2] = pieza.getDescripcion();
            data[i][3] = pieza.getAutor();
            data[i][4] = pieza.getPrecio();
        }
        JTable table = new JTable(data, columnNames);
        JOptionPane.showMessageDialog(this, new JScrollPane(table), "Piezas Disponibles",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showSubastas() {
        List<Subasta> subastas = subastaManager.getSubastas();
        String[] columnNames = { "ID", "Nombre", "Fecha Inicio", "Fecha Fin", "Ganador" };
        Object[][] data = new Object[subastas.size()][5];
        for (int i = 0; i < subastas.size(); i++) {
            Subasta subasta = subastas.get(i);
            data[i][0] = subasta.getId();
            data[i][1] = subasta.getNombre();
            data[i][2] = subasta.getFechaInicio();
            data[i][3] = subasta.getFechaFin();
            data[i][4] = subasta.getGanadorNombre();
        }
        JTable table = new JTable(data, columnNames);
        JOptionPane.showMessageDialog(this, new JScrollPane(table), "Subastas Disponibles",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showHistorialCompras() {
        JOptionPane.showMessageDialog(this, "Funcionalidad de Historial de Compras no implementada aún",
                "Historial de Compras", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showPerfil() {
        JTextField nombreField = new JTextField(comprador.getNombre());
        JTextField emailField = new JTextField(comprador.getEmail());
        JTextField telefonoField = new JTextField(comprador.getTelefono());
        JPasswordField passField = new JPasswordField(comprador.getContrasenia());
        Object[] message = {
                "Nombre:", nombreField,
                "Email:", emailField,
                "Telefono:", telefonoField,
                "Contraseña:", passField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Perfil", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            comprador.setNombre(nombreField.getText());
            comprador.setEmail(emailField.getText());
            comprador.setTelefono(telefonoField.getText());
            comprador.setContrasenia(new String(passField.getPassword()));
            JOptionPane.showMessageDialog(this, "Perfil actualizado", "Perfil", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
