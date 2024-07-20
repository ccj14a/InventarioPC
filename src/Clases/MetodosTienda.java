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

/**
 *
 * @author ALE
 */
public class MetodosTienda {

    final static String ARCHIVO = "archivo";

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
        System.out.println("Se guardo con éxito el computador");

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

    public void modificarPrecioComputador(int cod, List<Computadora> compus, double precio) {
        for (Computadora c : compus) {
            if (cod == c.getCodComputadora()) {
                c.setPrecio(precio);
                System.out.println("Modificacion exitosa");
                serializarLista(compus);
                return;

            }
        }

    }

    public void modificarSO(String sistemaOperativo, List<Computadora> compus, int cod) {
        for (Computadora c : compus) {
            if (cod == c.getCodComputadora()) {
                c.setSistemaOperativo(sistemaOperativo);
                System.out.println("Modificacion exitosa");
                serializarLista(compus);
                return;

            }
        }

    }

    public void modificarDescuento(int cod, List<Computadora> compus, double descuento) {
        for (Computadora c : compus) {
            if (cod == c.getCodComputadora()) {
                c.setDescuento(descuento);
                System.out.println("Modificacion exitosa");
                serializarLista(compus);
                return;

            }
        }

    }

    public void serializarLista(List<Computadora> compus) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            out.writeObject(compus);
            //System.out.println("Se agregó con exito el computador");

        } catch (IOException x) {
            System.out.println("ERROR: " + x.getMessage());
        }

    }

    public List<Computadora> deserializarLista() {
        List<Computadora> compus = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            compus = (List<Computadora>) in.readObject();

        } catch (IOException | ClassNotFoundException x) {
            System.out.println("ERROR: " + x.getMessage());

        }
        return compus;

    }

    public void mostrarDatos(List<Computadora> compus) {
        for (Computadora c : compus) {
            System.out.println(c);
            System.out.println("------------------------------------------------------------------------------------------------------");
        }

    }

    public void mostrarPorCodigo(int cod, List<Computadora> compus) {
        for (Computadora c : compus) {
            if (cod == c.getCodComputadora()) {
                System.out.println(c);
                return;
            }
        }

    }

    public void mostrarCodigos(List<Computadora> compus) {
        System.out.println("CODIGOS REGISTRADOS:");
        for (Computadora c : compus) {
            System.out.println("cod: " + c.getCodComputadora());
        }
    }

}
