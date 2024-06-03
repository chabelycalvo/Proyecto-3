package vista;

import modelo.Subasta;
import modelo.Pieza;
import negocio.SubastaManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ParticiparSubastasView extends JFrame {
    public ParticiparSubastasView(SubastaManager subastaManager) {
        setTitle("Participar en Subastas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        List<Subasta> subastas = subastaManager.getSubastas();
        String[] columnNames = { "ID", "Pieza", "Fecha Inicio", "Fecha Fin", "Ganador", "Comprador ID" };
        Object[][] data = new Object[subastas.size()][6];

        for (int i = 0; i < subastas.size(); i++) {
            Subasta subasta = subastas.get(i);
            Pieza pieza = subasta.getPieza(); // Usando el nuevo método getPieza()
            data[i][0] = subasta.getId();
            data[i][1] = pieza != null ? pieza.getNombre() : "N/A";
            data[i][2] = subasta.getFechaInicio();
            data[i][3] = subasta.getFechaFin();
            data[i][4] = subasta.getGanador() != null ? subasta.getGanador().getNombre() : "N/A";
            data[i][5] = subasta.getCompradorId();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
