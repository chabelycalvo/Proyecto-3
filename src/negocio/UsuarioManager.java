package negocio;

import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

public class UsuarioManager {
    private List<Usuario> usuarios;

    public UsuarioManager(List<Usuario> usuarios) {
        this.usuarios = usuarios != null ? usuarios : new ArrayList<>();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void removeUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public Usuario findUsuarioById(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public void updateUsuario(Usuario usuarioActualizado) {
        Usuario usuario = findUsuarioById(usuarioActualizado.getId());
        if (usuario != null) {
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setRol(usuarioActualizado.getRol());
        }
    }
}
