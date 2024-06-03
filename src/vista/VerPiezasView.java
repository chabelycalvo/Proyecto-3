package vista;

import modelo.Pieza;
import negocio.GaleriaManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VerPiezasView extends JFrame {
    public VerPiezasView(GaleriaManager galeriaManager) {
        setTitle("Ver Piezas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        List<Pieza> piezas = galeriaManager.getPiezas();
        String[] columnNames = { "ID", "Nombre", "Descripción", "Autor", "Precio", "Fecha Creación", "Estado" };
        Object[][] data = new Object[piezas.size()][7];

        for (int i = 0; i < piezas.size(); i++) {
            Pieza pieza = piezas.get(i);
            data[i][0] = pieza.getId();
            data[i][1] = pieza.getNombre();
            data[i][2] = pieza.getDescripcion();
            data[i][3] = pieza.getAutor();
            data[i][4] = pieza.getPrecio();
            data[i][5] = pieza.getFechaCreacion();
            data[i][6] = pieza.getEstado();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
