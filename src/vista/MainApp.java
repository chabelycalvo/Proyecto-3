package vista;

import modelo.Galeria;
import modelo.Propietario;
import modelo.Pago;
import modelo.Pieza;
import modelo.Subasta;
import negocio.GaleriaManager;
import negocio.PagoManager;
import negocio.SubastaManager;
import negocio.CompradorManager;
import util.TxtUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear galería
            List<Pieza> piezas = TxtUtil.cargarPiezas("data/piezas.txt");
            List<Propietario> propietarios = new ArrayList<>();
            List<Pago> pagos = TxtUtil.cargarPagos("data/pagos.txt");
            List<Subasta> subastas = TxtUtil.cargarSubastas("data/subastas.txt");
            Galeria galeria = new Galeria(1, "Galería de Arte", "Calle 123", piezas, propietarios);

            // Inicializar gestores
            GaleriaManager galeriaManager = new GaleriaManager(galeria);
            PagoManager pagoManager = new PagoManager(pagos);
            SubastaManager subastaManager = new SubastaManager(subastas);
            CompradorManager compradorManager = new CompradorManager(TxtUtil.cargarCompradores("data/compradores.txt"));

            // Crear e inicializar la interfaz gráfica
            JFrame frame = new JFrame("Galería de Arte");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);

            // Mostrar la vista de inicio
            InicioView inicioView = new InicioView(frame, galeriaManager, pagoManager, subastaManager,
                    compradorManager);
            frame.add(inicioView);
            frame.setVisible(true);
        });
    }
}
