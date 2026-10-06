/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasepoo1;

/**
 *
 * @author alumno
 */


public class Motor {
    private int idMotor;
    private int idVehiculo;
    private String marca;
    private String cilindrada;
    private String tipoCombustible;

 
    public Motor(int idMotor, int idVehiculo, String marca, String cilindrada, String tipoCombustible) {
        this.idMotor = idMotor;
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.cilindrada = cilindrada;
        this.tipoCombustible = tipoCombustible;
    }

  
    public int getIdMotor() { return idMotor; }
    public void setIdMotor(int idMotor) { this.idMotor = idMotor; }

    public int getIdVehiculo() { return idVehiculo; }
    public void setIdVehiculo(int idVehiculo) { this.idVehiculo = idVehiculo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getCilindrada() { return cilindrada; }
    public void setCilindrada(String cilindrada) { this.cilindrada = cilindrada; }

    public String getTipoCombustible() { return tipoCombustible; }
    public void setTipoCombustible(String tipoCombustible) { this.tipoCombustible = tipoCombustible; }
}
