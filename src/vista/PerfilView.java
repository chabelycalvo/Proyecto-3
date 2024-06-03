// PerfilView.java
package vista;

import modelo.Comprador;
import negocio.CompradorManager;
import negocio.GaleriaManager;

import javax.swing.*;
import java.awt.*;

public class PerfilView extends JFrame {
    public PerfilView(Comprador comprador, GaleriaManager galeriaManager) {
        setTitle("Perfil");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        panel.add(new JLabel("Nombre:"));
        JTextField nombreField = new JTextField(comprador.getNombre());
        panel.add(nombreField);

        panel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField(comprador.getEmail());
        panel.add(emailField);

        panel.add(new JLabel("Teléfono:"));
        JTextField telefonoField = new JTextField(comprador.getTelefono());
        panel.add(telefonoField);

        panel.add(new JLabel("Contraseña:"));
        JPasswordField contraseniaField = new JPasswordField(comprador.getContrasenia());
        panel.add(contraseniaField);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> {
            comprador.setNombre(nombreField.getText());
            comprador.setEmail(emailField.getText());
            comprador.setTelefono(telefonoField.getText());
            comprador.setContrasenia(new String(contraseniaField.getPassword()));
            galeriaManager.updateComprador(comprador);
            JOptionPane.showMessageDialog(this, "Perfil actualizado con éxito");
        });

        add(panel, BorderLayout.CENTER);
        add(btnGuardar, BorderLayout.SOUTH);
        setVisible(true);
    }
}
