package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Usuario;
import negocio.UsuarioManager;

public class GestionUsuariosView {
    private JFrame frame;
    private JPanel panel;
    private JTable table;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnEditar;
    private UsuarioManager usuarioManager;

    public GestionUsuariosView(UsuarioManager usuarioManager) {
        this.usuarioManager = usuarioManager;
        frame = new JFrame("Gestión de Usuarios");
        panel = new JPanel(new BorderLayout());
        table = new JTable(new UsuarioTableModel(usuarioManager.getUsuarios()));

        btnAgregar = new JButton("Agregar Usuario");
        btnEliminar = new JButton("Eliminar Usuario");
        btnEditar = new JButton("Editar Usuario");

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnAgregar);
        btnPanel.add(btnEliminar);
        btnPanel.add(btnEditar);

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditarUsuarioDialog(frame, usuarioManager, null);
                table.setModel(new UsuarioTableModel(usuarioManager.getUsuarios())); // Refresh table
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    usuarioManager.removeUsuario(usuarioManager.getUsuarios().get(selectedRow));
                    table.setModel(new UsuarioTableModel(usuarioManager.getUsuarios())); // Refresh table
                }
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Usuario usuario = usuarioManager.getUsuarios().get(selectedRow);
                    new EditarUsuarioDialog(frame, usuarioManager, usuario);
                    table.setModel(new UsuarioTableModel(usuarioManager.getUsuarios())); // Refresh table
                }
            }
        });

        frame.add(panel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
