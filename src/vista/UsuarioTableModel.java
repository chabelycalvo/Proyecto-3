package vista;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import modelo.Usuario;

public class UsuarioTableModel extends AbstractTableModel {
    private List<Usuario> usuarios;
    private String[] columnNames = {"ID", "Nombre", "Rol"};

    public UsuarioTableModel(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = usuarios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return usuario.getId();
            case 1:
                return usuario.getNombre();
            case 2:
                return usuario.getRol();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
