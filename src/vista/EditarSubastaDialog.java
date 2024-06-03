package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Subasta;
import negocio.SubastaManager;

public class EditarSubastaDialog extends JDialog {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private JTextField nombreField;
    private JTextField fechaInicioField;
    private JTextField fechaFinField;
    private JTextField compradorIdField;
    private SubastaManager subastaManager;
    private Subasta subasta;

    public EditarSubastaDialog(Frame parent, SubastaManager subastaManager, Subasta subasta) {
        super(parent, "Editar Subasta", true);
        this.subastaManager = subastaManager;
        this.subasta = subasta;
        initComponents();
    }

    private void initComponents() {
        nombreField = new JTextField(subasta.getNombre(), 20);
        fechaInicioField = new JTextField(DATE_FORMAT.format(subasta.getFechaInicio()), 20);
        fechaFinField = new JTextField(DATE_FORMAT.format(subasta.getFechaFin()), 20);
        compradorIdField = new JTextField(String.valueOf(subasta.getCompradorId()), 20);

        JButton btnGuardar = new JButton("Guardar");

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subasta.setNombre(nombreField.getText());
                try {
                    subasta.setFechaInicio(DATE_FORMAT.parse(fechaInicioField.getText()));
                    subasta.setFechaFin(DATE_FORMAT.parse(fechaFinField.getText()));
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(EditarSubastaDialog.this, "Formato de fecha incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                subasta.setCompradorId(Integer.parseInt(compradorIdField.getText()));

                subastaManager.updateSubasta(subasta);
                dispose();
            }
        });

        setLayout(new GridLayout(5, 2));
        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Fecha Inicio:"));
        add(fechaInicioField);
        add(new JLabel("Fecha Fin:"));
        add(fechaFinField);
        add(new JLabel("ID Comprador:"));
        add(compradorIdField);
        add(btnGuardar);

        pack();
    }
}
