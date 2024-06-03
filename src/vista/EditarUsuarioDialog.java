package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Usuario;
import negocio.UsuarioManager;

public class EditarUsuarioDialog extends JDialog {
    private JTextField txtNombre;
    private JTextField txtRol;
    private JButton btnGuardar;
    private Usuario usuario;
    private UsuarioManager usuarioManager;

    public EditarUsuarioDialog(Frame parent, UsuarioManager usuarioManager, Usuario usuario) {
        super(parent, true);
        this.usuarioManager = usuarioManager;
        this.usuario = usuario;

        setTitle(usuario == null ? "Agregar Usuario" : "Editar Usuario");
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField(usuario == null ? "" : usuario.getNombre());
        add(txtNombre);

        add(new JLabel("Rol:"));
        txtRol = new JTextField(usuario == null ? "" : usuario.getRol());
        add(txtRol);

        btnGuardar = new JButton("Guardar");
        add(new JLabel(""));
        add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario == null) {
                    Usuario nuevoUsuario = new Usuario(
                        usuarioManager.getUsuarios().size() + 1,
                        txtNombre.getText(),
                        txtRol.getText()
                    );
                    usuarioManager.addUsuario(nuevoUsuario);
                } else {
                    usuario.setNombre(txtNombre.getText());
                    usuario.setRol(txtRol.getText());
                }
                dispose();
            }
        });

        setSize(300, 200);
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
