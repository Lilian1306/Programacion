/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebacoraclesab;
import java.sql.Connection; //nos sirve para conectar
import java.sql.DriverManager;//se encarga de solicitar la conexión al driver JDBC.
import java.sql.SQLException; //permite manejar errores relacionados con la base de datos.
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author alumno
 */
public class Conexion {
    public static Connection conectar() {
    Connection conexion = null;
    
    String url = "jdbc:oracle:thin:@localhost:1521:umg";
    String usuario = "system";
    String password = "Umg$2026";//ver correo de la mariano para saber contraseña
    
    try{
      conexion=DriverManager.getConnection(url, usuario, password);
      
      System.out.println("conexion exitosa");
        
    }
    catch(SQLException e){
    System.out.println("error"+e.getMessage());
    }
    
    
      return conexion; 
    }
    
    public void mostrarVehiculos(){
        String sql="select * from vehiculo";
        
        try {
           Connection c=  conectar();  
           Statement statement = c.createStatement();
           ResultSet resultado = statement.executeQuery(sql);
           
    while (resultado.next()) {
    int id = resultado.getInt("ID_VEHICULO");
    String marca = resultado.getString("MARCA");
    String modelo = resultado.getString("MODELO");
    int anio = resultado.getInt("ANIO");
    String color= resultado.getString("color");

    System.out.println("------------------------");
    System.out.println("ID: " + id);
    System.out.println("Marca: " + marca);
    System.out.println("Modelo: " + modelo);
    System.out.println("Año: " + anio);
    System.out.println("Color: " + color);
    }
} catch (SQLException e) {
System.out.println("Error al consultar: " + e.getMessage());
}


    }
}
