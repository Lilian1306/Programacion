/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasepoo1;
import java.sql.Connection; //nos sirve para conectar
import java.sql.DriverManager;//se encarga de solicitar la conexión al driver JDBC.
import java.sql.SQLException; //permite manejar errores relacionados con la base de datos.
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    
    public ArrayList<Vehiculo> mostrarVehiculos(){
        String sql="select * from vehiculo";
        ArrayList<Vehiculo> Vehiculos = new ArrayList();
        
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
    double precio =resultado.getDouble("precio");
    
    Vehiculo carro= new Vehiculo( id, marca, modelo, anio, precio, color);
    Vehiculos.add(carro);

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

  return Vehiculos;
  
}
  public void insertarVehiculo(int id, String marca, String modelo, int anio, double precio, String color) {
        String sql = "INSERT INTO VEHICULO (ID_VEHICULO, MARCA, MODELO, ANIO, PRECIO, COLOR) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conexion = conectar();
            java.sql.PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.setInt(4, anio);
            ps.setDouble(5, precio);
            ps.setString(6, color);
            ps.executeUpdate();
            System.out.println("Vehículo insertado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public void actualizarVehiculo(int id, String marca, String modelo, int anio, double precio, String color) {
        String sql = "UPDATE VEHICULO SET MARCA = ?, MODELO = ?, ANIO = ?, PRECIO = ?, COLOR = ? WHERE ID_VEHICULO = ?";
        try {
            Connection conexion = conectar();
            java.sql.PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, marca);
            ps.setString(2, modelo);
            ps.setInt(3, anio);
            ps.setDouble(4, precio);
            ps.setString(5, color);
            ps.setInt(6, id);
            ps.executeUpdate();
            System.out.println("Vehículo actualizado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }
    
    public void eliminarVehiculo(int id) {
        String sql = "DELETE FROM VEHICULO WHERE ID_VEHICULO = ?";
        try {
            Connection conexion = conectar();
            java.sql.PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Vehículo eliminado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}


