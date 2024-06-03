package vista;

import javax.swing.*;

import modelo.Galeria;
import negocio.GaleriaManager;
import negocio.PagoManager;
import negocio.SubastaManager;
import negocio.UsuarioManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminView extends JFrame {
    private GaleriaManager galeriaManager;
    private PagoManager pagoManager;
    private SubastaManager subastaManager;
    private UsuarioManager usuarioManager;

    private JPanel panel;
    private JButton btnGestionarUsuarios;
    private JButton btnGestionarPiezas;
    private JButton btnGestionarSubastas;

    public AdminView(JFrame parentFrame, GaleriaManager galeriaManager, PagoManager pagoManager,
            SubastaManager subastaManager, UsuarioManager usuarioManager) {
        this.galeriaManager = galeriaManager;
        this.pagoManager = pagoManager;
        this.subastaManager = subastaManager;
        this.usuarioManager = usuarioManager;

        setTitle("Vista de Administrador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        panel = new JPanel();
        btnGestionarUsuarios = new JButton("Gestionar Usuarios");
        btnGestionarPiezas = new JButton("Gestionar Piezas");
        btnGestionarSubastas = new JButton("Gestionar Subastas");

        panel.add(btnGestionarUsuarios);
        panel.add(btnGestionarPiezas);
        panel.add(btnGestionarSubastas);

        btnGestionarUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GestionUsuariosView(usuarioManager);
            }
        });

        btnGestionarPiezas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GestionPiezasView(galeriaManager);
            }
        });

        btnGestionarSubastas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GestionSubastasView(subastaManager);
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crear instancias ficticias para GaleriaManager, PagoManager, SubastaManager y UsuarioManager
        // para probar AdminView
        Galeria galeria = new Galeria(1, "Galería de Arte", "Calle 123", new ArrayList<>(), new ArrayList<>());
        GaleriaManager galeriaManager = new GaleriaManager(galeria);
        PagoManager pagoManager = new PagoManager(new ArrayList<>());
        SubastaManager subastaManager = new SubastaManager(new ArrayList<>());
        UsuarioManager usuarioManager = new UsuarioManager(new ArrayList<>());

        new AdminView(new JFrame(), galeriaManager, pagoManager, subastaManager, usuarioManager);
    }
}
