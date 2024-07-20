/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author ALE
 */
public class Computadora implements Serializable{

    private int codComputadora;
    private double precio;
    private String sistemaOperativo;
    private double descuento;

    public Computadora(int codComputadora, double precio, String sistemaOperativo, double descuento) {
        this.codComputadora = codComputadora;
        this.precio = precio;
        this.sistemaOperativo = sistemaOperativo;
        this.descuento = descuento;

    }

    public int getCodComputadora() {
        return codComputadora;
    }

    public void setCodComputadora(int codComputadora) {
        this.codComputadora = codComputadora;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double precioFinal() {
        this.precio = this.precio - descuento;
        return precio;

    }

    @Override
    public String toString() {
        return "codComputadora=" + codComputadora
                + ", precio inicial=" + precio + ", sistemaOperativo=" + sistemaOperativo
                + ", descuento=" + descuento + ", precio final=" + precioFinal();
    }

}
