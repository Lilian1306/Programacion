/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasepoo1;

/**
 *
 * @author lilyt
 */
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrmLogin extends JDialog {

    JLabel lblTitulo = new JLabel("INICIO DE SESIÓN");
    JLabel lblUsuario = new JLabel("Usuario:");
    JLabel lblContrasena = new JLabel("Contraseña:");

    JTextField txtUsuario = new JTextField();
    JPasswordField txtContrasena = new JPasswordField();

    JButton btnIngresar = new JButton("Ingresar");
    JButton btnCancelar = new JButton("Cancelar");

    private boolean autenticado = false;
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public FrmLogin(JFrame parent) {
        super(parent, "Autenticación", true); 
        setSize(380, 260);
        setLocationRelativeTo(parent);
        setLayout(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

     
        cargarUsuarios();

        lblTitulo.setBounds(120, 20, 200, 30);
        add(lblTitulo);

     
        lblUsuario.setBounds(40, 70, 90, 30);
        add(lblUsuario);
        txtUsuario.setBounds(140, 70, 180, 30);
        add(txtUsuario);

    
        lblContrasena.setBounds(40, 110, 90, 30);
        add(lblContrasena);
        txtContrasena.setBounds(140, 110, 180, 30);
        add(txtContrasena);

    
        btnIngresar.setBounds(50, 165, 120, 30);
        add(btnIngresar);

        btnCancelar.setBounds(190, 165, 120, 30);
        add(btnCancelar);

    
        btnIngresar.addActionListener(e -> {
            validarLogin();
        });

        btnCancelar.addActionListener(e -> {
            this.autenticado = false;
            dispose();
        });
    }

    private void cargarUsuarios() {
        listaUsuarios.add(new UsuarioDigitador("Tony Anderson", "digitador1", "123"));
        listaUsuarios.add(new UsuarioAprobador("Holly", "aprobador1", "456"));
        listaUsuarios.add(new UsuarioAdmin("Administrador General", "admin", "admin123"));
    }

    private void validarLogin() {
        String user = txtUsuario.getText();
        String pass = new String(txtContrasena.getPassword());

        Usuario usuarioLogueado = null;

        for (Usuario u : listaUsuarios) {
            if (u.autenticar(user, pass)) {
                usuarioLogueado = u;
                break;
            }
        }

        if (usuarioLogueado != null) {
            JOptionPane.showMessageDialog(this, "Bienvenido " + usuarioLogueado.getNombre() + " (" + usuarioLogueado.getRolUsuario() + ")");
            this.autenticado = true;
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            txtContrasena.setText("");
        }
    }

    public boolean getAutenticado() {
        return this.autenticado;
    }
}
