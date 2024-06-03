package vista;

import negocio.GaleriaManager;
import negocio.PagoManager;
import negocio.SubastaManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JPanel {
    private JFrame parentFrame;
    private GaleriaManager galeriaManager;
    private PagoManager pagoManager;
    private SubastaManager subastaManager;

    public LoginView(JFrame parentFrame, GaleriaManager galeriaManager, PagoManager pagoManager, SubastaManager subastaManager) {
        this.parentFrame = parentFrame;
        this.galeriaManager = galeriaManager;
        this.pagoManager = pagoManager;
        this.subastaManager = subastaManager;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel userLabel = new JLabel("Usuario:");
        JTextField userField = new JTextField(20);
        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField(20);
        JButton loginButton = new JButton("Iniciar Sesión");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(userLabel, gbc);

        gbc.gridx = 1;
        add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passLabel, gbc);

        gbc.gridx = 1;
        add(passField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                if (authenticate(username, password)) {
                    if (username.equals("admin")) {
                        new AdminView(parentFrame, galeriaManager, pagoManager, subastaManager);
                    } else if (username.equals("comprador")) {
                        new CompradorView(parentFrame, galeriaManager, pagoManager, subastaManager);
                    } else {
                        new EmpleadoView(parentFrame, galeriaManager, pagoManager, subastaManager);
                    }
                    parentFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(parentFrame, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean authenticate(String username, String password) {
        // Aquí se puede implementar la lógica de autenticación
        return true; // Simplificación para el ejemplo
    }
}
