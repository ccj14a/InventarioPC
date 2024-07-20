/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import static Principal.Principal.entrada;
import java.io.IOException;

public class Menus {

    private static final String MENU_TIENDA = """
                                              MENU TIENDA
                                              1.DatosTienda
                                              2.AgregarComputadoras
                                              3.RegistroComputadoras
                                              4.ModificarComputador
                                              5.Salir
                                              """;
    private static final String MENU_MODIFICAR = """
                                               MENU MODIFICACION
                                               1.Modificar so
                                               2.Modificar precio
                                               3.Modificar descuento
                                               4.Eliminar computadora
                                               5.Atras
                                               """;

    public static int menuTienda() {
        int opRetornar = -1;
        System.out.println(MENU_TIENDA);
        try {
            while (true) {
                System.out.println("Coloca una opcion entera(1-5): ");
                opRetornar = Integer.parseInt(entrada.readLine());
                if (opRetornar >= 1 && opRetornar <= 5) {
                    break;
                }
                System.out.println("Opcion fuera de rango");
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Formato invalido: " + e.getMessage());
        }
        return opRetornar;

    }

    public static int menuModificacionCampos() {
        int opRetornar = -1;
        System.out.println(MENU_MODIFICAR);
        try {
            while (true) {
                System.out.println("Coloca una opcion entera(1-5): ");
                opRetornar = Integer.parseInt(entrada.readLine());
                if (opRetornar >= 1 && opRetornar <= 5) {
                    break;
                }
                System.out.println("Opcion fuera de rango");
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Formato invalido: " + e.getMessage());
        }
        return opRetornar;

    }

}
