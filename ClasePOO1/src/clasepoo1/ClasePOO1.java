/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clasepoo1;

/**
 *
 * @author lilyt
 */
public class ClasePOO1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Vehiculo carro1 = new Vehiculo();
        carro1.marca = "Toyota";
        carro1.modelo = "Corolla";

        carro1.SetPrecio(-1000);
        /*al ingresar o al recibir
        */


        /*constructor*/

        carro1.mostrarInformacion();

        /*carro2*/

        //Vehiculo carro2 = new Vehiculo("jeep", "tj", 2000, 50000);

        //carro2.mostrarInformacion();
        //apartir de aqui veremos modo grafico de java
        
        FrmVehiculo ventana = new FrmVehiculo();
        ventana.setVisible(true);

        /*FrmLogin login = new FrmLogin(null);
        login.setVisible(true);

        if (login.getAutenticado()) {
            FrmVehiculo ventana = new FrmVehiculo();
            ventana.setVisible(true);
        } else {
            System.out.println("Acceso denegado. Cerrando programa...");
            System.exit(0);
        }*/

    }

}