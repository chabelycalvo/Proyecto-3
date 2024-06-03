package vista; 

import javax.swing.table.AbstractTableModel;

import modelo.Pieza;

import java.util.List;

public class PiezaTableModel extends AbstractTableModel {
    private List<Pieza> piezas;
    private String[] columnNames = {"ID", "Nombre", "Descripción", "Precio", "Estado"};

    public PiezaTableModel(List<Pieza> piezas) {
        this.piezas = piezas;
    }

    @Override
    public int getRowCount() {
        return piezas.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pieza pieza = piezas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pieza.getId();
            case 1:
                return pieza.getNombre();
            case 2:
                return pieza.getDescripcion();
            case 3:
                return pieza.getPrecio();
            case 4:
                return pieza.getEstado();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
