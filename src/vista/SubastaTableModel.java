package vista;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import modelo.Subasta;
import java.text.SimpleDateFormat;

public class SubastaTableModel extends AbstractTableModel {
    private List<Subasta> subastas;
    private final String[] columnNames = {"ID", "Nombre", "Fecha Inicio", "Fecha Fin", "Comprador ID"};

    public SubastaTableModel(List<Subasta> subastas) {
        this.subastas = subastas;
    }

    @Override
    public int getRowCount() {
        return subastas.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Subasta subasta = subastas.get(rowIndex);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        switch (columnIndex) {
            case 0: return subasta.getId();
            case 1: return subasta.getNombre();
            case 2: return dateFormat.format(subasta.getFechaInicio());
            case 3: return dateFormat.format(subasta.getFechaFin());
            case 4: return subasta.getCompradorId();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Subasta getSubastaAt(int rowIndex) {
        return subastas.get(rowIndex);
    }

    public void setSubastas(List<Subasta> subastas) {
        this.subastas = subastas;
        fireTableDataChanged();
    }
}
