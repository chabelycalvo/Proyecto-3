package vista;

import modelo.Comprador;
import negocio.CompradorManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarCompradorDialog extends JDialog {
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JPasswordField passwordField;
    private CompradorManager compradorManager;

    public RegistrarCompradorDialog(JFrame parentFrame, CompradorManager compradorManager) {
        super(parentFrame, "Registrar Comprador", true);
        this.compradorManager = compradorManager;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Nombre:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Teléfono:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton registerButton = new JButton("Registrar");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarComprador();
            }
        });
        add(registerButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(cancelButton);

        pack();
        setLocationRelativeTo(getParent());
    }

    private void registrarComprador() {
        String nombre = nameField.getText();
        String email = emailField.getText();
        String telefono = phoneField.getText();
        String contrasenia = new String(passwordField.getPassword());

        if (nombre.isEmpty() || email.isEmpty() || telefono.isEmpty() || contrasenia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = compradorManager.getNextId();
        Comprador nuevoComprador = new Comprador(id, nombre, email, telefono, null, contrasenia);
        compradorManager.addComprador(nuevoComprador);
        JOptionPane.showMessageDialog(this, "Comprador registrado exitosamente.", "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}
