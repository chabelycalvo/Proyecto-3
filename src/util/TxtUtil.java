package util;

import modelo.Comprador;
import modelo.Empleado;
import modelo.Pieza;
import modelo.Subasta;
import modelo.Pago;
import modelo.Propietario;
import modelo.Transaccion;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TxtUtil {

    // Funcionalidades para Compradores
    public static List<Comprador> cargarCompradores(String filePath) {
        List<Comprador> compradores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|");
                int id = Integer.parseInt(fields[0]);
                String nombre = fields[1];
                String email = fields[2];
                String telefono = fields[3];
                String contrasenia = fields[4];
                Comprador comprador = new Comprador(id, nombre, email, telefono, new ArrayList<>(), contrasenia);
                compradores.add(comprador);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return compradores;
    }

    public static void guardarCompradores(List<Comprador> compradores, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Comprador comprador : compradores) {
                writer.write(comprador.getId() + "|" + comprador.getNombre() + "|" + comprador.getEmail() + "|" + comprador.getTelefono() + "|" + comprador.getContrasenia());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Funcionalidades para Empleados
    public static List<Empleado> cargarEmpleados(String filePath) {
        List<Empleado> empleados = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String nombre = parts[1];
                    String contrasenia = parts[2];
                    Empleado empleado = new Empleado(id, nombre, contrasenia);
                    empleados.add(empleado);
                } else {
                    System.err.println("Formato incorrecto en la línea: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + filePath);
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir ID a número en el archivo: " + filePath);
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar el BufferedReader");
                e.printStackTrace();
            }
        }
        return empleados;
    }


    public static void guardarEmpleados(List<Empleado> empleados, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Empleado empleado : empleados) {
                writer.write(empleado.getId() + "|" + empleado.getNombre() + "|" + empleado.getContrasenia());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Funcionalidades para Piezas
    public static List<Pieza> cargarPiezas(String filePath) {
        List<Pieza> piezas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|");
                int id = Integer.parseInt(fields[0]);
                String nombre = fields[1];
                String descripcion = fields[2];
                String autor = fields[3];
                double precio = Double.parseDouble(fields[4]);
                String fechaCreacion = fields[5];
                String estado = fields[6];
                int propietarioId = Integer.parseInt(fields[7]);
                Propietario propietario = new Propietario(propietarioId, "Propietario " + propietarioId, "email" + propietarioId + "@example.com", "123456789" + propietarioId, new ArrayList<>());
                Pieza pieza = new Pieza(id, nombre, descripcion, autor, precio, fechaCreacion, estado, propietario);
                piezas.add(pieza);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return piezas;
    }

    public static void guardarPiezas(List<Pieza> piezas, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Pieza pieza : piezas) {
                writer.write(pieza.getId() + "|" + pieza.getNombre() + "|" + pieza.getDescripcion() + "|" + pieza.getAutor() + "|" + pieza.getPrecio() + "|" + pieza.getFechaCreacion() + "|" + pieza.getEstado() + "|" + pieza.getPropietario().getId());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Funcionalidades para Subastas
    public static List<Subasta> cargarSubastas(String filePath) {
        List<Subasta> subastas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|");
                int id = Integer.parseInt(fields[0]);
                String nombre = fields[1];
                Date fechaInicio = new SimpleDateFormat("yyyy-MM-dd").parse(fields[2]);
                Date fechaFin = new SimpleDateFormat("yyyy-MM-dd").parse(fields[3]);
                int compradorId = Integer.parseInt(fields[4]);

                Subasta subasta = new Subasta(id, nombre, fechaInicio, fechaFin, compradorId);
                subastas.add(subasta);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return subastas;
    }

    public static void guardarSubastas(List<Subasta> subastas, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Subasta subasta : subastas) {
                String fechaInicioStr = new SimpleDateFormat("yyyy-MM-dd").format(subasta.getFechaInicio());
                String fechaFinStr = new SimpleDateFormat("yyyy-MM-dd").format(subasta.getFechaFin());
                writer.write(subasta.getId() + "|" + subasta.getNombre() + "|" + fechaInicioStr + "|" + fechaFinStr + "|" + subasta.getCompradorId());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Funcionalidades para Pagos
    public static List<Pago> cargarPagos(String filePath) {
        List<Pago> pagos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|");
                int id = Integer.parseInt(fields[0]);
                int transaccionId = Integer.parseInt(fields[1]);
                double monto = Double.parseDouble(fields[2]);
                String fechaPago = fields[3];
                String metodoPago = fields[4];
                String estado = fields[5];
                Transaccion transaccion = new Transaccion(transaccionId, null, null, null, fields[4], monto, estado, null);
                Pago pago = new Pago(id, transaccion, monto, fechaPago, metodoPago, estado);
                pagos.add(pago);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pagos;
    }

    public static void guardarPagos(List<Pago> pagos, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Pago pago : pagos) {
                writer.write(pago.getId() + "|" + pago.getTransaccion().getId() + "|" + pago.getMonto() + "|" + pago.getFechaPago() + "|" + pago.getMetodoPago() + "|" + pago.getEstado());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
