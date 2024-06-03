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

public class AgregarSubastaDialog extends JDialog {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private JTextField nombreField;
    private JTextField fechaInicioField;
    private JTextField fechaFinField;
    private JTextField compradorIdField;
    private SubastaManager subastaManager;

    public AgregarSubastaDialog(Frame parent, SubastaManager subastaManager) {
        super(parent, "Agregar Subasta", true);
        this.subastaManager = subastaManager;
        initComponents();
    }

    private void initComponents() {
        nombreField = new JTextField(20);
        fechaInicioField = new JTextField(20);
        fechaFinField = new JTextField(20);
        compradorIdField = new JTextField(20);

        JButton btnAgregar = new JButton("Agregar");

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                Date fechaInicio;
                Date fechaFin;
                try {
                    fechaInicio = DATE_FORMAT.parse(fechaInicioField.getText());
                    fechaFin = DATE_FORMAT.parse(fechaFinField.getText());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(AgregarSubastaDialog.this, "Formato de fecha incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int compradorId = Integer.parseInt(compradorIdField.getText());

                Subasta nuevaSubasta = new Subasta(0, nombre, fechaInicio, fechaFin, compradorId);
                subastaManager.addSubasta(nuevaSubasta);
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
        add(btnAgregar);

        pack();
    }
}
