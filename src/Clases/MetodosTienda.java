/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ALE
 */
public class MetodosTienda {

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
        System.out.println("Se agrego con exito el computador");

    }

    public void eliminarComputadoraTienda(int cod, List<Computadora> computadoras) {
        for (Computadora c : computadoras) {
            if (isCodigo(cod, computadoras)) {
                computadoras.remove(c);
                JOptionPane.showMessageDialog(null, "Se elimino cone exito","mensaje",JOptionPane.INFORMATION_MESSAGE);
                return;
            }

        }
       

    }

    public void modificarPrecioComputador(int cod, List<Computadora> compus, double precio) {
        for (Computadora c : compus) {
            if (isCodigo(cod, compus)) {
                c.setPrecio(precio);
                System.out.println("Modificacion exitosa");
                return;

            }
        }

    }
    public void modificarSO(String sistemaOperativo, List<Computadora> compus, int cod){
        for (Computadora c : compus) {
            if (isCodigo(cod, compus)) {
                c.setSistemaOperativo(sistemaOperativo);
                System.out.println("Modificacion exitosa");
                return;

            }
        }
        
    }
    public void modificarDescuento(int cod, List<Computadora> compus, double descuento){
          for (Computadora c : compus) {
            if (isCodigo(cod, compus)) {
                c.setDescuento(descuento);
                System.out.println("Modificacion exitosa");
                return;

            }
        }
        
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
    public void mostrarCodigos(List<Computadora> compus){
        System.out.println("CODIGOS REGISTRADOS:");
        for(Computadora c:compus){
            System.out.println("cod: "+ c.getCodComputadora());
        }
    }

}
