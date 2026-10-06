/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasepoo1;

/**
 *
 * @author lilyt
 */
public class Vehiculo {
    /*Aributos describen a una clase, variables globales*/
    int id; 
    String marca;
    String modelo;
    private int anio;
    private double precio;
    private Llanta llanta;
    String color;
    
    /*Private limita el acceso desde afuera, solo se puede acceder desde adentro de la clase*/
    /*el constructor se llama igual que la clase y en un metodo*/

    public Vehiculo(int id, String marca, String modelo, int anio, double precio, String color) {
        /*this*/
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
        this.color = color;
    }

    Vehiculo(){}

    void mostrarInformacion(){
        System.out.println("Marca"+marca);
        System.out.println("Modelo"+modelo);
        System.out.println("anho"+anio);
        System.out.println("Precio Q"+precio);
        System.out.println("Precio Q"+color);
    }
    /*
    get: obtener
    set: colocar
    */
    public int getId(){
        return this.id;
    }
    public String getModelo()
    {
        return this.modelo;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void SetPrecio( double p){
        if(p>0)
            this.precio=p;
    }
    public double GetPrecio()
    {
        return this.precio;
    }

    public int getAnio() {

        return anio;
    }

    public void setAnio(int anio) {
        if(anio>2010)
            this.anio = anio;
        else
            this.anio=0;
    }

    public Llanta getLlanta() {
        return llanta;
    }
}


