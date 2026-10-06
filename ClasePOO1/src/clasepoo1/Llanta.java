/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasepoo1;

/**
 *
 * @author lilyt
 */
public class Llanta {
    private String marca;
    private int tamanio;
    private double presion;

    // AQUI ESTÁ LA CLAVE: El constructor debe recibir los 3 datos
    public Llanta(String marca, int tamanio, double presion) {
        this.marca = marca;
        this.tamanio = tamanio;
        this.presion = presion;
    }

    public void mostrarInformacion() {
        System.out.println("Marca de llanta: " + marca);
        System.out.println("Tamaño: " + tamanio + " pulgadas");
        System.out.println("Presión: " + presion + " PSI");
    }
}
