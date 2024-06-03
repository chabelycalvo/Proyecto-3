package vista;

import modelo.Comprador;
import modelo.Empleado;
import negocio.GaleriaManager;
import negocio.PagoManager;
import negocio.SubastaManager;
import util.TxtUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InicioView extends JPanel {
    private JFrame parentFrame;
    private GaleriaManager galeriaManager;
    private PagoManager pagoManager;
    private SubastaManager subastaManager;
    private List<Comprador> compradores;
    private List<Empleado> empleados;

    // Contraseñas de ejemplo para administrador y empleado
    private final String ADMIN_PASSWORD = "1";
    private final String EMPLEADO_PASSWORD = "2";

    public InicioView(JFrame parentFrame, GaleriaManager galeriaManager, PagoManager pagoManager, SubastaManager subastaManager) {
        this.parentFrame = parentFrame;
        this.galeriaManager = galeriaManager;
        this.pagoManager = pagoManager;
        this.subastaManager = subastaManager;
        this.compradores = TxtUtil.cargarCompradores("data/compradores.txt");
        this.empleados = TxtUtil.cargarEmpleados("data/empleados.txt");
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        JLabel imageLabel = new JLabel(new ImageIcon("path/to/artgallery/image.jpg")); // Asegúrate de tener una imagen en este path
        add(imageLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));

        JButton adminButton = new JButton("Administrador");
        JButton empleadoButton = new JButton("Empleado");
        JButton compradorButton = new JButton("Comprador");

        buttonPanel.add(adminButton);
        buttonPanel.add(empleadoButton);
        buttonPanel.add(compradorButton);

        add(buttonPanel, BorderLayout.CENTER);

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginDialog("Administrador");
            }
        });

        empleadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginDialog("Empleado");
            }
        });

        compradorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCompradorLoginDialog();
            }
        });
    }

    private void showLoginDialog(String role) {
        JPasswordField passField = new JPasswordField();
        Object[] message = {
            "Contraseña:", passField
        };

        int option = JOptionPane.showConfirmDialog(parentFrame, message, "Iniciar Sesión - " + role, JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String password = new String(passField.getPassword());

            if (authenticate(role, password)) {
                if (role.equals("Administrador")) {
                    new AdminView(parentFrame, galeriaManager, pagoManager, subastaManager);
                } else {
                    Empleado empleado = new Empleado(1, "Empleado", EMPLEADO_PASSWORD); // Ejemplo de empleado
                    new EmpleadoView(parentFrame, galeriaManager, pagoManager, subastaManager, empleado);
                }
                parentFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showCompradorLoginDialog() {
        JTextField nameField = new JTextField();
        JPasswordField passField = new JPasswordField();
        Object[] message = {
            "Nombre:", nameField,
            "Contraseña:", passField
        };

        int option = JOptionPane.showConfirmDialog(parentFrame, message, "Iniciar Sesión - Comprador", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nombre = nameField.getText();
            String contrasenia = new String(passField.getPassword());

            if (authenticateComprador(nombre, contrasenia)) {
                new CompradorView(parentFrame, galeriaManager, pagoManager, subastaManager);
                parentFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Nombre o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean authenticate(String role, String password) {
        if (role.equals("Administrador")) {
            return ADMIN_PASSWORD.equals(password);
        } else if (role.equals("Empleado")) {
            return EMPLEADO_PASSWORD.equals(password);
        }
        return false;
    }

    private boolean authenticateComprador(String nombre, String contrasenia) {
        for (Comprador comprador : compradores) {
            if (comprador.getNombre().equals(nombre) && comprador.getContrasenia().equals(contrasenia)) {
                return true;
            }
        }
        return false;
    }
}
