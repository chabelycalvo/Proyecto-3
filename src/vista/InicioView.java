package vista;

import modelo.Comprador;
import modelo.Empleado;
import negocio.CompradorManager;
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
    private CompradorManager compradorManager;
    private List<Comprador> compradores;
    private List<Empleado> empleados;

    private final String ADMIN_PASSWORD = "1";
    private final String EMPLEADO_PASSWORD = "2";

    public InicioView(JFrame parentFrame, GaleriaManager galeriaManager, PagoManager pagoManager,
            SubastaManager subastaManager, CompradorManager compradorManager) {
        this.parentFrame = parentFrame;
        this.galeriaManager = galeriaManager;
        this.pagoManager = pagoManager;
        this.subastaManager = subastaManager;
        this.compradorManager = compradorManager;
        this.compradores = compradorManager.getCompradores();
        this.empleados = TxtUtil.cargarEmpleados("data/empleados.txt");
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

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
                showCompradorOptions();
            }
        });
    }

    private void showLoginDialog(String role) {
        JPasswordField passField = new JPasswordField();
        Object[] message = {
                "Contraseña:", passField
        };

        int option = JOptionPane.showConfirmDialog(parentFrame, message, "Iniciar Sesión - " + role,
                JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String password = new String(passField.getPassword());

            if (authenticate(role, password)) {
                if (role.equals("Administrador")) {
                    new AdminView(parentFrame, galeriaManager, pagoManager, subastaManager, null);
                } else {
                    Empleado empleado = new Empleado(1, "Empleado", EMPLEADO_PASSWORD);
                    new EmpleadoView(parentFrame, galeriaManager, pagoManager, subastaManager, empleado);
                }
                parentFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showCompradorOptions() {
        String[] options = { "Iniciar Sesión", "Registrarse" };
        int choice = JOptionPane.showOptionDialog(parentFrame, "Elige una opción", "Comprador",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            showCompradorLoginDialog();
        } else if (choice == 1) {
            new RegistrarCompradorDialog(parentFrame, compradorManager).setVisible(true);
        }
    }

    private void showCompradorLoginDialog() {
        JTextField nameField = new JTextField();
        JPasswordField passField = new JPasswordField();
        Object[] message = {
                "Nombre:", nameField,
                "Contraseña:", passField
        };

        int option = JOptionPane.showConfirmDialog(parentFrame, message, "Iniciar Sesión - Comprador",
                JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nombre = nameField.getText();
            String contrasenia = new String(passField.getPassword());

            if (authenticateComprador(nombre, contrasenia)) {
                Comprador comprador = compradorManager.findCompradorByNombre(nombre);
                new CompradorView(parentFrame, galeriaManager, pagoManager, subastaManager, comprador);
                parentFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Nombre o contraseña incorrectos", "Error",
                        JOptionPane.ERROR_MESSAGE);
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
        Comprador comprador = compradorManager.findCompradorByNombre(nombre);
        return comprador != null && comprador.getContrasenia().equals(contrasenia);
    }
}
