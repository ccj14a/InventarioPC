/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Clases.Computadora;
import Clases.Menus;
import Clases.MetodosTienda;
import Clases.Tienda;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ALE
 */
public class Principal {

    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void datosComputadora(List<Computadora> compus) {
        MetodosTienda met = new MetodosTienda();
        int cod;
        double precio;
        double descu;
        String so = "";
        try {
            String iC = JOptionPane.showInputDialog(null, "Codigo de la computadora:", "CODIGO", JOptionPane.QUESTION_MESSAGE);
            if (iC == null) {
                return;
            }
            cod = Integer.parseInt(iC);
            if (met.isCodigo(cod, compus)) {
                JOptionPane.showMessageDialog(null, "El codigo " + cod + " ya existe", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String iP = JOptionPane.showInputDialog(null, "Precio: ", "PRECIO", JOptionPane.QUESTION_MESSAGE);
            if (iP == null) {
                return;
            }
            precio = Double.parseDouble(iP);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String inputD = JOptionPane.showInputDialog(null, "Descuento:", "Descuento", JOptionPane.QUESTION_MESSAGE);
            if (inputD == null) {
                return;
            }
            descu = Double.parseDouble(inputD);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        so = JOptionPane.showInputDialog("Sistema operativo:");
        if (so == null) {
            return;
        }
        Computadora c = new Computadora(cod, precio, so, descu);
        met.agregarComputadoraTienda(c, compus);
    }

    public static double precio() {
        double precio;
        try {
            precio = Double.parseDouble(JOptionPane.showInputDialog(null, "Precio:", "PRECIO", JOptionPane.QUESTION_MESSAGE));
            return precio;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ERROR");
            return -1;

        }

    }

    public static String nSO() {
        String so;
        so = JOptionPane.showInputDialog(null, "Sistema operativo:");
        return so;

    }

    public static double nD() {
        double desc;

        try {
            desc = Double.parseDouble(JOptionPane.showInputDialog(null, "Descuento: ", "Descuento", JOptionPane.QUESTION_MESSAGE));
            return desc;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ERROR");
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        int op1, op2;
        MetodosTienda mt = new MetodosTienda();
        //System.out.println("Este es un menaje nuevo");
        //List<Computadora> cargarData = mt.deserializarLista();
        List<Computadora> compus = new ArrayList<>(mt.deserializarLista());
        Tienda t = new Tienda();
        do {
            op1 = Menus.menuTienda();
            switch (op1) {
                case 1:
                    JOptionPane.showMessageDialog(null, t, "DATOS TIENDA", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:

                    datosComputadora(compus);

                    break;
                case 3:
                    if (compus.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay computadoras registradas en " + Tienda.nombre_Tienda, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        break;
                    }

                    mt.mostrarDatos(compus);

                    break;
                case 4:
                    StringBuilder s = mt.mostrarCodigos(compus);
                    s.append("\nColoca el codigo:");
                    int cod = Integer.parseInt(JOptionPane.showInputDialog(null, s, "CODIGO", JOptionPane.INFORMATION_MESSAGE));

                    if (mt.isCodigo(cod, compus)) {
                        System.out.println("COMPUTADORA ACTUAL");
                        mt.mostrarPorCodigo(cod, compus);
                        boolean estado = false;
                        do {

                            op2 = Menus.menuModificacionCampos();

                            switch (op2) {
                                case 1:
                                    estado = mt.modificarSO(nSO(), compus, cod);
                                    break;
                                case 2:

                                    estado = mt.modificarPrecioComputador(cod, compus, precio());
                                    break;
                                case 3:

                                    estado = mt.modificarDescuento(cod, compus, nD());
                                    break;
                                case 4:
                                    String r;
                                    r = JOptionPane.showInputDialog(null, "Estas seguro que quieres eliminar no hay vuelta atras(S/N):");
                                    if (r.equals("S") || r.equals("s")) {
                                        mt.eliminarComputadoraTienda(cod, compus);

                                    }
                                    break;

                            }
                            if (op2 == 5) {
                                break;
                            }
                            if (estado) {
                                System.out.println("COMPUTADORA LUEGO DE LAS ACTUALIZACIONES");
                                mt.mostrarPorCodigo(cod, compus);
                            }

                        } while (op2 != 5);

                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "El codigo no existe", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    }
                    break;

            }

        } while (op1 != 5);

    }

}
