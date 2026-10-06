/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasepoo1;

/**
 *
 * @author lilyt
 */
public class Usuario {
    private String nombre;
    private String usuario;
    private String contrasena;
    protected String rolUsuario;

    public Usuario(String nombre, String usuario, String contrasena) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rolUsuario = "GENERAL";
    }

    public boolean autenticar(String user, String pass) {
        return this.usuario.equals(user) && this.contrasena.equals(pass);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }
}
