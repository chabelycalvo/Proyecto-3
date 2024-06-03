// HistorialComprasView.java
package vista;

import modelo.Comprador;
import modelo.Pago;
import negocio.PagoManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HistorialComprasView extends JFrame {
    public HistorialComprasView(PagoManager pagoManager, Comprador comprador) {
        setTitle("Historial de Compras");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        List<Pago> pagos = pagoManager.getPagosByComprador(comprador);
        String[] columnNames = { "ID", "Transacción ID", "Monto", "Fecha de Pago", "Método de Pago", "Estado" };
        Object[][] data = new Object[pagos.size()][6];

        for (int i = 0; i < pagos.size(); i++) {
            Pago pago = pagos.get(i);
            data[i][0] = pago.getId();
            data[i][1] = pago.getTransaccion().getId();
            data[i][2] = pago.getMonto();
            data[i][3] = pago.getFechaPago();
            data[i][4] = pago.getMetodoPago();
            data[i][5] = pago.getEstado();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
