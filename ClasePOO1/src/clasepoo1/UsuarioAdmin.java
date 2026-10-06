/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasepoo1;

/**
 *
 * @author lilyt
 */
public class UsuarioAdmin extends Usuario {
    public UsuarioAdmin(String nombre, String usuario, String contrasena) {
        super(nombre, usuario, contrasena);
        this.rolUsuario = "ADMIN";
    }
}
