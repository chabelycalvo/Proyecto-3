package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Subasta;
import negocio.SubastaManager;

public class GestionSubastasView extends JFrame {
    private SubastaManager subastaManager;
    private JTable subastasTable;
    private SubastaTableModel tableModel;

    public GestionSubastasView(SubastaManager subastaManager) {
        this.subastaManager = subastaManager;

        setTitle("Gestionar Subastas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        tableModel = new SubastaTableModel(subastaManager.getSubastas());
        subastasTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(subastasTable);

        JButton btnAgregar = new JButton("Agregar Subasta");
        JButton btnEditar = new JButton("Editar Subasta");
        JButton btnEliminar = new JButton("Eliminar Subasta");

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para agregar subasta
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = subastasTable.getSelectedRow();
                if (selectedRow != -1) {
                    Subasta subasta = tableModel.getSubastaAt(selectedRow);
                    // Implementar lógica para editar subasta
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una subasta para editar.");
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = subastasTable.getSelectedRow();
                if (selectedRow != -1) {
                    Subasta subasta = tableModel.getSubastaAt(selectedRow);
                    subastaManager.removeSubasta(subasta);
                    tableModel.setSubastas(subastaManager.getSubastas());
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una subasta para eliminar.");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAgregar);
        buttonPanel.add(btnEditar);
        buttonPanel.add(btnEliminar);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
