package negocio;

import modelo.Comprador;
import util.TxtUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompradorManager {
    private List<Comprador> compradores;

    public CompradorManager() {
        this.compradores = new ArrayList<>();
        loadCompradoresFromFile("data/compradores.txt");
    }

    public CompradorManager(List<Comprador> compradores) {
        this.compradores = compradores;
    }

    private void loadCompradoresFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) { // Asumiendo que los campos son id, nombre, email, telefono, contrasenia
                    int id = Integer.parseInt(parts[0]);
                    String nombre = parts[1];
                    String email = parts[2];
                    String telefono = parts[3];
                    String contrasenia = parts[4];
                    compradores.add(new Comprador(id, nombre, email, telefono, null, contrasenia));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public List<Comprador> getCompradores() {
        return compradores;
    }

    public void addComprador(Comprador comprador) {
        compradores.add(comprador);
        saveCompradoresToFile("data/compradores.txt");
    }

    public void removeComprador(Comprador comprador) {
        compradores.remove(comprador);
        saveCompradoresToFile("data/compradores.txt");
    }

    public Comprador findCompradorById(int id) {
        for (Comprador comprador : compradores) {
            if (comprador.getId() == id) {
                return comprador;
            }
        }
        return null;
    }

    public void updateComprador(Comprador comprador) {
        Comprador existingComprador = findCompradorById(comprador.getId());
        if (existingComprador != null) {
            existingComprador.setNombre(comprador.getNombre());
            existingComprador.setEmail(comprador.getEmail());
            existingComprador.setTelefono(comprador.getTelefono());
            existingComprador.setContrasenia(comprador.getContrasenia());
            saveCompradoresToFile("data/compradores.txt");
        }
    }

    public int getNextId() {
        int maxId = 0;
        for (Comprador comprador : compradores) {
            if (comprador.getId() > maxId) {
                maxId = comprador.getId();
            }
        }
        return maxId + 1;
    }

    public Comprador findCompradorByNombre(String nombre) {
        for (Comprador comprador : compradores) {
            if (comprador.getNombre().equals(nombre)) {
                return comprador;
            }
        }
        return null;
    }

    private void saveCompradoresToFile(String filePath) {
        TxtUtil.guardarCompradores(compradores, filePath);
    }
}
