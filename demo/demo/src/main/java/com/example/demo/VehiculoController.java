/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

/**
 *
 * @author lilyt
 */

import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    
     @GetMapping
    public ArrayList<Vehiculo> listar() {
        
        Conexion c = new Conexion();
        return c.mostrarVehiculos();
        //return "espero les este gustando a BTS";
    }

}
