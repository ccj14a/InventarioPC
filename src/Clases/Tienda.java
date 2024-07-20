/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author ALE
 */
public class Tienda {

    //encapsulando los atributos
    public static final String nombre_Tienda="COMPU_TIENDA";
    private final String direccion="AV_1234";

    public Tienda() {
    }


    @Override
    public String toString() {
        return "" + "nombreTienda=" + nombre_Tienda + ", direccion=" + direccion + '+';
    }

}
