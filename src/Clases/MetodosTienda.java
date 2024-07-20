/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MetodosTienda {

    final static String ARCHIVO = "archivo.ser";

    //metodos para aregar cumputadoras a la tienda
    public boolean isCodigo(int cod, List<Computadora> computadoras) {
        for (Computadora c : computadoras) {
            if (cod == c.getCodComputadora()) {
                return true;
            }
        }
        return false;

    }

    public void agregarComputadoraTienda(Computadora computador, List<Computadora> computadoras) {
        if (isCodigo(computador.getCodComputadora(), computadoras)) {
            System.out.println("El codigo " + computador.getCodComputadora() + " ya existe");
            return;
        }
        computadoras.add(computador);
        serializarLista(computadoras);
        JOptionPane.showMessageDialog(null, "Se guardo con éxito el computador", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);

    }

    public void eliminarComputadoraTienda(int cod, List<Computadora> computadoras) {

        for (Computadora c : computadoras) {
            if (c.getCodComputadora() == cod) {
                computadoras.remove(c);
                JOptionPane.showMessageDialog(null, "ELIMINADO EXITOSAMENTE");
                serializarLista(computadoras);
                return;

            }

        }

    }

    public boolean modificarPrecioComputador(int cod, List<Computadora> compus, double precio) {
        if (precio == -1) {
            return false;
        }
        if (precio < -1) {
            JOptionPane.showMessageDialog(null, "NO SE ACEPTA VALORES NEGATIVOS");
            return false;
        }
        for (Computadora c : compus) {
            if (cod == c.getCodComputadora()) {
                c.setPrecio(precio);
                JOptionPane.showMessageDialog(null, "Modificacion exitosa", "MODIFICACION", JOptionPane.INFORMATION_MESSAGE);
                serializarLista(compus);
                return true;

            }
        }
        return false; //si no encuentra la compu 

    }

    public boolean modificarSO(String sistemaOperativo, List<Computadora> compus, int cod) {
        for (Computadora c : compus) {
            if (cod == c.getCodComputadora()) {
                c.setSistemaOperativo(sistemaOperativo);
                JOptionPane.showMessageDialog(null, "Modificacion exitosa", "MODIFICACION", JOptionPane.INFORMATION_MESSAGE);
                serializarLista(compus);
                return true;

            }
        }
        return false;//si no encuentra la compu 

    }

    public boolean modificarDescuento(int cod, List<Computadora> compus, double descuento) {
         if (descuento == -1) {
            return false;
        }
        if (descuento < -1) {
            JOptionPane.showMessageDialog(null, "NO SE ACEPTA VALORES NEGATIVOS");
            return false;
        }
        for (Computadora c : compus) {
            if (cod == c.getCodComputadora()) {
                c.setDescuento(descuento);
                JOptionPane.showMessageDialog(null, "Modificacion exitosa", "MODIFICACION", JOptionPane.INFORMATION_MESSAGE);
                serializarLista(compus);
                return true;

            }
        }
        return false; //si no encuentra la compu 

    }

    public void serializarLista(List<Computadora> compus) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            out.writeObject(compus);
           

        } catch (IOException x) {
            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public List<Computadora> deserializarLista() {
        List<Computadora> compus = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            compus = (List<Computadora>) in.readObject();

        } catch (IOException | ClassNotFoundException x) {
            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return compus;

    }

    public void mostrarDatos(List<Computadora> compus) {
        StringBuilder s = new StringBuilder();

        for (Computadora c : compus) {
            s.append(c).append("\n");

        }
        JOptionPane.showMessageDialog(null, s, "Computadoras registradas en: " + Tienda.nombre_Tienda, JOptionPane.INFORMATION_MESSAGE);

    }

    public void mostrarPorCodigo(int cod, List<Computadora> compus) {
        for (Computadora c : compus) {
            if (cod == c.getCodComputadora()) {
                System.out.println(c);
                return;
            }
        }

    }

    public StringBuilder mostrarCodigos(List<Computadora> compus) {
        StringBuilder s = new StringBuilder();
        s.append("CODIGOS REGISTRADOS").append("\n");
        for (Computadora c : compus) {
            s.append("cod ").append(c.getCodComputadora()).append("\n");
        }
        return s;

    }

}
