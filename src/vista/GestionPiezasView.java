package vista;

import javax.swing.*;

import modelo.Pieza;
import negocio.GaleriaManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GestionPiezasView {
    private JFrame frame;
    private JPanel panel;
    private JTable table;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnEditar;
    private GaleriaManager galeriaManager;

    public GestionPiezasView(GaleriaManager galeriaManager) {
        this.galeriaManager = galeriaManager;
        frame = new JFrame("Gestión de Piezas");
        panel = new JPanel(new BorderLayout());
        table = new JTable(new PiezaTableModel(galeriaManager.getPiezas()));

        btnAgregar = new JButton("Agregar Pieza");
        btnEliminar = new JButton("Eliminar Pieza");
        btnEditar = new JButton("Editar Pieza");

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnAgregar);
        btnPanel.add(btnEliminar);
        btnPanel.add(btnEditar);

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para agregar pieza
                new EditarPiezaDialog(frame, galeriaManager, null);
                table.setModel(new PiezaTableModel(galeriaManager.getPiezas())); // Refresh table
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    galeriaManager.removePieza(galeriaManager.getPiezas().get(selectedRow));
                    table.setModel(new PiezaTableModel(galeriaManager.getPiezas())); // Refresh table
                }
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Pieza pieza = galeriaManager.getPiezas().get(selectedRow);
                    new EditarPiezaDialog(frame, galeriaManager, pieza);
                    table.setModel(new PiezaTableModel(galeriaManager.getPiezas())); // Refresh table
                }
            }
        });

        frame.add(panel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
