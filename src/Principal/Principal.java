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
        System.out.print("Codigo computadora:");
        try {
            cod = Integer.parseInt(entrada.readLine());
            if (met.isCodigo(cod, compus)) {
                System.out.println("el codigo " + cod + " ya existe");
                return;
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.println("ERROR");
            return;
        }
        System.out.print("precio: ");
        try {
            precio = Double.parseDouble(entrada.readLine());
        } catch (IOException | NumberFormatException ex) {
            System.out.println("ERROR");
            return;
        }
        System.out.print("Descuento:");
        try {
            descu = Double.parseDouble(entrada.readLine());
        } catch (IOException | NumberFormatException ex) {
            System.out.println("ERROR");
            return;
        }
        System.out.print("Sistema operativo:");
        try {
            so = entrada.readLine();
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
        Computadora c = new Computadora(cod, precio, so, descu);
        met.agregarComputadoraTienda(c, compus);
    }

    public static double precio() {
        double precio;

        System.out.print("precio:");
        try {
            precio = Double.parseDouble(entrada.readLine());
            return precio;
        } catch (IOException ex) {
            System.out.println("ERROR");
        
            return 0;

        }

    }

    public static String nSO() {
        String so;
        System.out.print("sistema operativo:");
        try {
            so = entrada.readLine();
            return so;
        } catch (IOException ex) {
            System.out.println("ERROR");
            return null;
        }
    }

    public static double nD() {
        double desc;
        System.out.print("descuento:");
        try {
            desc = Double.parseDouble(entrada.readLine());
            return desc;
        } catch (IOException ex) {
            System.out.println("ERROR");
            return 0;
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
                    System.out.println(t);
                    break;
                case 2:
                    System.out.println(t);
                    datosComputadora(compus);

                    break;
                case 3:
                    if (compus.isEmpty()) {
                        System.out.println("No hay computadoras registradas en " + Tienda.nombre_Tienda);
                        break;
                    }
                    System.out.println("COMPUTADORAS REGISTRADAS");
                    System.out.println(Tienda.nombre_Tienda);
                    mt.mostrarDatos(compus);

                    break;
                case 4:
                    mt.mostrarCodigos(compus);
                    System.out.println("Buscar x codigo: ");
                    int cod = Integer.parseInt(entrada.readLine());
                    if (mt.isCodigo(cod, compus)) {
                        mt.mostrarPorCodigo(cod, compus);
                        do {
                            op2 = Menus.menuModificacionCampos();
                            switch (op2) {
                                case 1:
                                    mt.modificarSO(nSO(), compus, cod);
                                    break;
                                case 2:
                                    mt.modificarPrecioComputador(cod, compus, precio());
                                    break;
                                case 3:
                                    mt.modificarDescuento(cod, compus, nD());
                                    break;
                                case 4:
                                    String r;
                                    System.out.print("Estas seguro que quieres eliminar no hay vuelta atras(S/N):");
                                    r = entrada.readLine();
                                    if (r.equals("S") || r.equals("s")) {
                                        mt.eliminarComputadoraTienda(cod, compus);

                                    }
                                    break;
                            }
                        } while (op2 != 5);

                        break;
                    } else {
                        System.out.println("el codigo no existe");
                    }
                    break;

            }

        } while (op1 != 5);

    }

}
