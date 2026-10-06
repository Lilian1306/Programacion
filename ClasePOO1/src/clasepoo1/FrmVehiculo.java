/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasepoo1;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author lilyt
 */
public class FrmVehiculo extends JFrame {

    JLabel lblTitulo = new JLabel("Registro de vehiculo");
    JLabel lblMarca = new JLabel("Marca:");
    JLabel lblModelo = new JLabel("Modelo:");
    JLabel lblAnio = new JLabel("Año:");
    JLabel lblPrecio = new JLabel("Precio:");
    /*
    JLabel lblMarcaLlanta = new JLabel("Marca Llanta:");
    JLabel lblTamanio = new JLabel("Tamaño:");
    JLabel lblPresion = new JLabel("Presion:");*/
    JLabel lblColor = new JLabel("Color:");
    
    // PARA EL MOTOR
    JLabel lblMarcaMotor = new JLabel("Marca Motor:");
    JLabel lblCilindrada = new JLabel("Cilindrada:");
    JLabel lblCombustible = new JLabel("Combustible:");
    
    JTextField txtMarca = new JTextField();
    JTextField txtModelo = new JTextField();
    JTextField txtAnio = new JTextField();
    JTextField txtPrecio = new JTextField();
    /*
    JTextField txtMarcaLlanta = new JTextField();
    JTextField txtTamanio = new JTextField();
    JTextField txtPresion = new JTextField();*/
    JTextField txtColor = new JTextField();
    
    // PARA EL MOTOR
    JTextField txtMarcaMotor = new JTextField();
    JTextField txtCilindrada = new JTextField();
    JTextField txtCombustible = new JTextField();

    JButton btnGuardar = new JButton("Guardar");
    
    JButton btnActualizar = new JButton("Actualizar");
    
    JButton btnEliminar = new JButton("Eliminar");
    
    JButton btnGuardarMotor = new JButton("Registrar Motor");
        //int contador = 0;

    JTable tablaVehiculos;
    DefaultTableModel modeloTabla;
    JScrollPane scrollTabla;
    
    int x = 20;
    ArrayList<Vehiculo> Vehiculos = new ArrayList();
    
    private boolean tieneMotor = false;
    private int idMotorActual = 0;

    FrmVehiculo() {

        setTitle("Registro de Vehículo");
        setSize(560, 800); // 1. Cambiamos el alto a 600 para que quepa la tabla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        lblTitulo.setBounds(150, 20, 200, 30);
        add(lblTitulo);

        // VEHICULOS
        lblMarca.setBounds(50, 60, 100, 30);
        add(lblMarca);
        txtMarca.setBounds(150, 60, 200, 30);
        add(txtMarca);

        lblModelo.setBounds(50, 100, 100, 30);
        add(lblModelo);
        txtModelo.setBounds(150, 100, 200, 30);
        add(txtModelo);

        lblAnio.setBounds(50, 140, 100, 30);
        add(lblAnio);
        txtAnio.setBounds(150, 140, 200, 30);
        add(txtAnio);

        lblPrecio.setBounds(50, 180, 100, 30);
        add(lblPrecio);
        txtPrecio.setBounds(150, 180, 200, 30);
        add(txtPrecio);
        
        lblColor.setBounds(50, 220, 100, 30);
        add(lblColor);
        txtColor.setBounds(150, 220, 200, 30);
        add(txtColor);

         
        // --- BOTONES DE VEHÍCULO ---
        btnGuardar.setBounds(30, 265, 150, 30);
        add(btnGuardar);
        
        btnActualizar.setBounds(190, 265, 150, 30);
        add(btnActualizar);
        
        btnEliminar.setBounds(350, 265, 150, 30);
        add(btnEliminar);
        /*
        lblMarcaLlanta.setBounds(50, 230, 100, 30);
        add(lblMarcaLlanta);
        txtMarcaLlanta.setBounds(150, 230, 200, 30);
        add(txtMarcaLlanta);

        lblTamanio.setBounds(50, 270, 100, 30);
        add(lblTamanio);
        txtTamanio.setBounds(150, 270, 200, 30);
        add(txtTamanio);

        lblPresion.setBounds(50, 310, 100, 30);
        add(lblPresion);
        txtPresion.setBounds(150, 310, 200, 30);
        add(txtPresion);*/


        // --- CAMPOS DE MOTOR ---
        lblMarcaMotor.setBounds(50, 315, 100, 30);
        add(lblMarcaMotor);
        txtMarcaMotor.setBounds(150, 315, 200, 30);
        add(txtMarcaMotor);

        lblCilindrada.setBounds(50, 355, 100, 30);
        add(lblCilindrada);
        txtCilindrada.setBounds(150, 355, 200, 30);
        add(txtCilindrada);

        lblCombustible.setBounds(50, 395, 100, 30);
        add(lblCombustible);
        txtCombustible.setBounds(150, 395, 200, 30);
        add(txtCombustible);
        
        // --- BOTÓN DE MOTOR ---
        btnGuardarMotor.setBounds(150, 435, 200, 30);
        add(btnGuardarMotor);
        
        
        Conexion c = new Conexion();
        Vehiculos = c.mostrarVehiculos();
        
        modeloTabla = new DefaultTableModel();
        
        modeloTabla.addColumn("id");
        modeloTabla.addColumn("Marca");
        modeloTabla.addColumn("Modelo");
        modeloTabla.addColumn("anho");
        modeloTabla.addColumn("color");
        modeloTabla.addColumn("precio");
        
        tablaVehiculos = new JTable(modeloTabla);
            
        scrollTabla = new JScrollPane(tablaVehiculos);
            
        scrollTabla.setBounds(50, 480, 450, 250);
        add(scrollTabla);
        

        recorremosVehiculos();
        System.out.println("ya tengo mis vehiculos " + Vehiculos.size());
            
        this.btnGuardar.addActionListener(e-> {
            funcionbtn();
        });
            
        this.btnActualizar.addActionListener(e-> {
            funcionActualizar();
        });
        
        this.btnEliminar.addActionListener(e -> {
            funcionEliminar();
        });
        
        // PARA EL MOTOR
        this.btnGuardarMotor.addActionListener(e -> { funcionGuardarActualizarMotor(); });
            
        this.tablaVehiculos.getSelectionModel().addListSelectionListener(e -> {
            // Esto evita que el evento se dispare dos veces por clic
            if (!e.getValueIsAdjusting() && tablaVehiculos.getSelectedRow() != -1) {
                funcionfila();
            }
        });
    }

    // --- AQUÍ CREAMOS EL MÉTODO NUEVO ---
    private void recorremosVehiculos() {
        for(int i = 0; i < Vehiculos.size(); i++){
            Vehiculo carro = Vehiculos.get(i);
            this.modeloTabla.addRow(new Object[]{
                carro.getId(),
                carro.getMarca(), 
                carro.getModelo(), 
                carro.getAnio(),
                carro.color,
                carro.GetPrecio()
            });
        }
    }

    public void funcionbtn() {
        String marca = this.txtMarca.getText();
        String modelo = this.txtModelo.getText();
        int anio = Integer.parseInt(this.txtAnio.getText());
        double precio = Double.parseDouble(this.txtPrecio.getText());
        String color = this.txtColor.getText();
        
        int maxId = 0; for (Vehiculo v : Vehiculos) { if (v.getId() > maxId) { maxId = v.getId(); } } int id = maxId + 1;  
        Vehiculo carro = new Vehiculo(id, marca, modelo, anio, precio, color);

        this.modeloTabla.addRow(new Object[]{
            carro.getId(),
            carro.getMarca(), 
            carro.getModelo(), 
            carro.getAnio(),
            carro.color,
            carro.GetPrecio()
        });
        
        this.Vehiculos.add(carro);
        
        Conexion c = new Conexion();
        c.insertarVehiculo(id, marca, modelo, anio, precio, color);

        JOptionPane.showMessageDialog(this, "vehiculo guardado");

        this.txtMarca.setText("");
        this.txtModelo.setText("");
        this.txtAnio.setText("");
        this.txtPrecio.setText("");
        this.txtColor.setText("");
    }
    
    private void funcionfila() {
        int fila = this.tablaVehiculos.getSelectedRow();
        Vehiculo c = this.Vehiculos.get(fila);
        
        this.txtMarca.setText(c.getMarca());
        this.txtModelo.setText(c.getModelo());
        this.txtAnio.setText(String.valueOf(c.getAnio()));
        this.txtPrecio.setText(String.valueOf(c.GetPrecio()));
        this.txtColor.setText(c.color);
        
        cargarMotorPorVehiculo(c.getId());
    }
        
    public void funcionActualizar() {
        int fila = tablaVehiculos.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un vehículo de la tabla primero.");
            return;
        }

        Vehiculo vehiculoSeleccionado = Vehiculos.get(fila);
        int id = vehiculoSeleccionado.getId(); 

        String marca = this.txtMarca.getText();
        String modelo = this.txtModelo.getText();
        int anio = Integer.parseInt(this.txtAnio.getText());
        double precio = Double.parseDouble(this.txtPrecio.getText());
        String color = this.txtColor.getText();

        Conexion c = new Conexion();
        c.actualizarVehiculo(id, marca, modelo, anio, precio, color);

        vehiculoSeleccionado.marca = marca;
        vehiculoSeleccionado.modelo = modelo;
        vehiculoSeleccionado.setAnio(anio);
        vehiculoSeleccionado.SetPrecio(precio);
        vehiculoSeleccionado.color = color;

        modeloTabla.setValueAt(marca, fila, 1);
        modeloTabla.setValueAt(modelo, fila, 2);
        modeloTabla.setValueAt(anio, fila, 3);
        modeloTabla.setValueAt(color, fila, 4);
        modeloTabla.setValueAt(precio, fila, 5);

        JOptionPane.showMessageDialog(this, "Vehículo actualizado correctamente");
        tablaVehiculos.clearSelection();
    }
    
    // PARA EL MOTOR
    private void cargarMotorPorVehiculo(int idVehiculo) {
        Conexion c = new Conexion();
        try (Connection con = Conexion.conectar();
             PreparedStatement pstmt = con.prepareStatement("SELECT id_motor, marca, cilindrada, tipo_combustible FROM MOTORES WHERE id_vehiculo = ?")) {
            
            pstmt.setInt(1, idVehiculo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    idMotorActual = rs.getInt("id_motor");
                    txtMarcaMotor.setText(rs.getString("marca"));
                    txtCilindrada.setText(rs.getString("cilindrada"));
                    txtCombustible.setText(rs.getString("tipo_combustible"));
                    tieneMotor = true;
                    btnGuardarMotor.setText("Actualizar Motor");
                } else {
                    idMotorActual = 0;
                    txtMarcaMotor.setText("");
                    txtCilindrada.setText("");
                    txtCombustible.setText("");
                    tieneMotor = false;
                    btnGuardarMotor.setText("Registrar Motor");
                }
            }
        } catch (Exception e) {
            // Si la tabla motores aún no está creada en Oracle, se maneja de forma silenciosa o con aviso
            System.out.println("Nota sobre motor: " + e.getMessage());
        }
    }
    
    public void funcionGuardarActualizarMotor() {
        int fila = tablaVehiculos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un vehículo de la tabla primero.");
            return;
        }
        
        Vehiculo vehiculoSeleccionado = Vehiculos.get(fila);
        int idVehiculoSeleccionado = vehiculoSeleccionado.getId();
        
        String marcaMotor = txtMarcaMotor.getText();
        String cilindrada = txtCilindrada.getText();
        String combustible = txtCombustible.getText();
        
        Conexion c = new Conexion();
        try (Connection con = Conexion.conectar()) {
            
            if (!tieneMotor) {
                // INSERTAR MOTOR CON PREPAREDSTATEMENT
                String sqlInsert = "INSERT INTO MOTORES (id_vehiculo, marca, cilindrada, tipo_combustible) VALUES (?, ?, ?, ?)";
                try (PreparedStatement pstmt = con.prepareStatement(sqlInsert)) {
                    pstmt.setInt(1, idVehiculoSeleccionado);
                    pstmt.setString(2, marcaMotor);
                    pstmt.setString(3, cilindrada);
                    pstmt.setString(4, combustible);
                    pstmt.executeUpdate();
                    
                    JOptionPane.showMessageDialog(this, "¡Motor registrado con éxito!");
                    tieneMotor = true;
                    btnGuardarMotor.setText("Actualizar Motor");
                }
            } else {
                String sqlUpdate = "UPDATE MOTORES SET marca = ?, cilindrada = ?, tipo_combustible = ? WHERE id_motor = ?";
                try (PreparedStatement pstmt = con.prepareStatement(sqlUpdate)) {
                    pstmt.setString(1, marcaMotor);
                    pstmt.setString(2, cilindrada);
                    pstmt.setString(3, combustible);
                    pstmt.setInt(4, idMotorActual);
                    pstmt.executeUpdate();
                    
                    JOptionPane.showMessageDialog(this, "¡Motor actualizado con éxito!");
                }
            }
            
            cargarMotorPorVehiculo(idVehiculoSeleccionado);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en la operación del motor: " + e.getMessage());
        }
    }
    public void funcionEliminar() {
     int fila = tablaVehiculos.getSelectedRow();

     if (fila == -1) {
         JOptionPane.showMessageDialog(this, "Por favor, seleccione un vehículo de la tabla para eliminar.");
         return;
     }

     // Obtener el ID
     Vehiculo vehiculoSeleccionado = Vehiculos.get(fila);
     int id = vehiculoSeleccionado.getId(); 

     // Eliminar de Oracle
     Conexion c = new Conexion();
     c.eliminarVehiculo(id);

     // Eliminar de nuestro ArrayList y de la tabla visual
     Vehiculos.remove(fila);
     modeloTabla.removeRow(fila);

     JOptionPane.showMessageDialog(this, "Vehículo eliminado correctamente");

     // Limpiar los textfields
     this.txtMarca.setText("");
     this.txtModelo.setText("");
     this.txtAnio.setText("");
     this.txtPrecio.setText("");
     this.txtColor.setText("");
     tablaVehiculos.clearSelection();
 }
}