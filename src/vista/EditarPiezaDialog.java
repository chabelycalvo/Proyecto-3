package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Pieza;
import negocio.GaleriaManager;

public class EditarPiezaDialog extends JDialog {
    private JTextField txtNombre;
    private JTextField txtDescripcion;
    private JTextField txtPrecio;
    private JTextField txtEstado;
    private JButton btnGuardar;
    private Pieza pieza;
    private GaleriaManager galeriaManager;

    public EditarPiezaDialog(Frame parent, GaleriaManager galeriaManager, Pieza pieza) {
        super(parent, true);
        this.galeriaManager = galeriaManager;
        this.pieza = pieza;

        setTitle(pieza == null ? "Agregar Pieza" : "Editar Pieza");
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField(pieza == null ? "" : pieza.getNombre());
        add(txtNombre);

        add(new JLabel("Descripción:"));
        txtDescripcion = new JTextField(pieza == null ? "" : pieza.getDescripcion());
        add(txtDescripcion);

        add(new JLabel("Precio:"));
        txtPrecio = new JTextField(pieza == null ? "" : String.valueOf(pieza.getPrecio()));
        add(txtPrecio);

        add(new JLabel("Estado:"));
        txtEstado = new JTextField(pieza == null ? "" : pieza.getEstado());
        add(txtEstado);

        btnGuardar = new JButton("Guardar");
        add(new JLabel(""));
        add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pieza == null) {
                    Pieza nuevaPieza = new Pieza(
                        galeriaManager.getPiezas().size() + 1,
                        txtNombre.getText(),
                        txtDescripcion.getText(),
                        null, // Artista debería ser seleccionado de alguna manera
                        Double.parseDouble(txtPrecio.getText()),
                        txtEstado.getText(), getTitle(), null
                    );
                    galeriaManager.addPieza(nuevaPieza);
                } else {
                    pieza.setNombre(txtNombre.getText());
                    pieza.setDescripcion(txtDescripcion.getText());
                    pieza.setPrecio(Double.parseDouble(txtPrecio.getText()));
                    pieza.setEstado(txtEstado.getText());
                }
                dispose();
            }
        });

        setSize(300, 200);
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
