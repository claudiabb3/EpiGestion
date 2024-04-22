package Controlador;

import Modelos.Usuario;
import Vistas.Vlogin;
import Vistas.Vmenu;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDB extends ConexionDB {
        private PreparedStatement ps;
        private ResultSet rs;
        private Usuario usuario;
     
     
    // Constructor vacío
    public UsuarioDB() {
    }
    
    //---------------- consulta a la base dedatos ----------------------//
    private Usuario consultaUsuario(String nombre, String password) {
      
       String sql = "select * from usuario where Nombre= '"+nombre+"' and Contrasenia='"+password+"';";
        
        try {
            conectar();
            ps = prepararConsulta(sql);
            rs =ejecutarConsulta(ps);
            
            while (rs.next()) {
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setPass(rs.getString(3));
                usuario.setDepartamento(rs.getString(4));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al validar usuario: " + e.getMessage());
        }finally{
        desconectar();
        }
        return usuario;
    }
    
    
    
    //---------------- metodos para jframe ----------------------//
    public boolean validar( String us ,String cont){
         usuario = new Usuario();
        // Creamos una instancia de la ventana de login para mostrar mensajes de error
        Vlogin vlogin = new Vlogin();
        
        // Verificamos si los campos de usuario y contraseña están vacíos
        if (us.isEmpty() || cont.isEmpty()) {
            JOptionPane.showMessageDialog(vlogin, "No se ha introducido usuario y contraseña", "ERROR", HEIGHT);
        } else {
            // Realizamos la consulta del usuario en la base de datos
            Usuario usuario = consultaUsuario(us, cont);
            
            // Verificamos si el usuario y la contraseña coinciden con los de la base de datos
            if (usuario.getNombre() !=null && usuario.getPass() !=null) {
                  Vmenu menu = new Vmenu();
                  menu.setVisible(true);
                  
                 
                  return true;
               
            } else {
                // Si no coinciden, mostramos un mensaje de error
                JOptionPane.showMessageDialog(vlogin, "Error en el usuario y/o contrasenia", "ERROR", HEIGHT);
            }
        }
        
        return false;
    }
}
    
    
    
    
