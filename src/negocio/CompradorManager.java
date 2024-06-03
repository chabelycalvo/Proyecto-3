package negocio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Comprador;

public class CompradorManager {
    private List<Comprador> compradores;
    private String filePath = "data/compradores.txt";

    public CompradorManager(List<Comprador> list) {
        this.compradores = new ArrayList<>();
        loadCompradoresFromFile(filePath);
    }

    private void loadCompradoresFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
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
        guardarCompradores();
    }

    public void removeComprador(Comprador comprador) {
        compradores.remove(comprador);
        guardarCompradores();
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
            guardarCompradores();
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

    private void guardarCompradores() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Comprador comprador : compradores) {
                writer.write(comprador.getId() + "|" + comprador.getNombre() + "|" + comprador.getEmail() + "|"
                        + comprador.getTelefono() + "|" + comprador.getContrasenia());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
