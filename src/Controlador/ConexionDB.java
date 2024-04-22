
package Controlador;
/**
 *
 * @author Claud
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class ConexionDB {
    
    private Connection connection;
    private static final String host = "jdbc:mysql://localhost:3306/gestionepi";
    private static final String usuario = "root";
    private static final String contrasenia = "root";
    private static final String db = "gestionepi";
    
    public Connection conectar() throws ClassNotFoundException, SQLException{
      Class.forName("com.mysql.cj.jdbc.Driver");
             connection =DriverManager.getConnection(host,usuario,contrasenia);    
             
        return connection;
    }
    
    public PreparedStatement prepararConsulta(String sql) {
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("Error al preparar la consulta: " + e.getMessage());
            return null;
        }
    }

    public ResultSet ejecutarConsulta(PreparedStatement statement) {
        try {
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
            return null;
        }
    }
    public void desconectar() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    public int ejecutarActualizacion(PreparedStatement statement) {
    try {
        return statement.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error al ejecutar la actualización: " + e.getMessage());
        return -1;
    }
}
}
