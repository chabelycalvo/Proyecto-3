package negocio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Comprador;

public class CompradorManager {
    private List<Comprador> compradores;

    public CompradorManager() {
        this.compradores = new ArrayList<>();
        loadCompradoresFromFile("data/compradores.txt");
    }

    private void loadCompradoresFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String nombre = parts[1];
                    String email = parts[2];
                    String telefono = parts[3];
                    String constrasenia = parts[4];
                    compradores.add(new Comprador(id, nombre, email,telefono, null, constrasenia));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public List<Comprador> getCompradores() {
        return compradores;
    }
}
