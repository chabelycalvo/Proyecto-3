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
    private JTextField telefonoField;
    private JPasswordField passField;
    private CompradorManager compradorManager;

    public RegistrarCompradorDialog(JFrame parentFrame, CompradorManager compradorManager) {
        super(parentFrame, "Registrar Comprador", true);
        this.compradorManager = compradorManager;

        setLayout(new GridLayout(5, 2));

        add(new JLabel("Nombre:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Telefono:"));
        telefonoField = new JTextField();
        add(telefonoField);

        add(new JLabel("Contraseña:"));
        passField = new JPasswordField();
        add(passField);

        JButton registerButton = new JButton("Registrar");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarComprador();
            }
        });
        add(registerButton);

        setSize(400, 300);
        setLocationRelativeTo(parentFrame);
    }

    private void registrarComprador() {
        String nombre = nameField.getText();
        String email = emailField.getText();
        String telefono = telefonoField.getText();
        String contrasenia = new String(passField.getPassword());

        if (nombre.isEmpty() || email.isEmpty() || telefono.isEmpty() || contrasenia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = compradorManager.getNextId();
        Comprador comprador = new Comprador(id, nombre, email, telefono, null, contrasenia);
        compradorManager.addComprador(comprador);
        JOptionPane.showMessageDialog(this, "Comprador registrado exitosamente", "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}
