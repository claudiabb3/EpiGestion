
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
import java.sql.Statement;

public class ConexionDB {
    
    private Connection connection;
    private static final String HOST = "jdbc:mysql://localhost:3306/";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "root";
    private static final String DB = "epigestion";
    
    // Constructor
    public ConexionDB() {
        try {
            // Cargar el driver 
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Conectar automáticamente al crear una instancia de ConexionDB
            connection = DriverManager.getConnection(HOST, USUARIO, CONTRASENIA);
            System.out.println("Conexión establecida con el servidor MySQL.");
            verificarYCrearBaseDeDatos();
            connection.close(); 
            
            // Conectar a la base de datos 'epigestion'
            connection = DriverManager.getConnection(HOST + DB, USUARIO, CONTRASENIA);
            System.out.println("Conexión establecida con la base de datos 'epigestion'.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
    // Método para conectar a la base de datos
    public Connection  conectar() {
        try {
            connection = DriverManager.getConnection(HOST + DB, USUARIO, CONTRASENIA);
            System.out.println("Conexión establecida con la base de datos.");
            verificarYCrearBaseDeDatos();
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return connection;
    }
    
    // Método para obtener la conexión
    public Connection getConexion() {
        return connection;
    }
    // Método para verificar si la base de datos existe y crearla si no
    private void verificarYCrearBaseDeDatos() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SHOW DATABASES LIKE '" + DB + "'");
            if (!resultSet.next()) {
                System.out.println("La base de datos '" + DB + "' no existe. Creándola...");
                statement.executeUpdate("CREATE DATABASE " + DB);
                System.out.println("Base de datos '" + DB + "' creada correctamente.");
                crearTablasYDatosIniciales();
            } else {
                System.out.println("La base de datos '" + DB + "' ya existe.");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error al verificar y crear la base de datos: " + e.getMessage());
        }
    }
    
    // Método para crear las tablas y los datos iniciales
    private void crearTablasYDatosIniciales() {
        try {
            Statement statement = connection.createStatement();
            //usar la base de datos epigestion
            statement.executeUpdate("use epigestion;");
            // Crear las tablas
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS USUARIO (Id_usuario INT AUTO_INCREMENT NOT NULL PRIMARY KEY, Nombre VARCHAR(20) NOT NULL, Contrasenia VARCHAR(8) NOT NULL, Departamento VARCHAR(20));");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS EPI (Id_epi INT AUTO_INCREMENT NOT NULL PRIMARY KEY, Descripcion VARCHAR(50) NOT NULL, Talla VARCHAR(3), Unidades INT(3) NOT NULL);");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS EMPLEADO (Id_empleado INT AUTO_INCREMENT NOT NULL PRIMARY KEY, Nombre VARCHAR(20) NOT NULL, Apellido1 VARCHAR(20) NOT NULL, Apellido2 VARCHAR(20) NOT NULL, Puesto VARCHAR(50));");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS ENTREGA_EPI (id_entrega INT AUTO_INCREMENT NOT NULL PRIMARY KEY, Nombre_emp VARCHAR(20) NOT NULL, Apellido1_emp VARCHAR(20) NOT NULL, Apellido2_emp VARCHAR(20) NOT NULL, Puesto_emp VARCHAR(50) NOT NULL, Descripcion_epi VARCHAR(50) NOT NULL, Fecha_entrega TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL, id_empleado_fk INT NOT NULL, FOREIGN KEY(id_empleado_fk) REFERENCES EMPLEADO(Id_empleado), id_epi INT NOT NULL, und INT NOT NULL);");
            System.out.println("Tablas creadas correctamente.");
            // Insertar datos iniciales
            statement.executeUpdate("INSERT INTO USUARIO (Nombre, Contrasenia, Departamento) VALUES ('Claudia', 'ClaudiaB', 'Oficina técnica'); ");
            statement.executeUpdate("INSERT INTO USUARIO (Nombre, Contrasenia, Departamento) VALUES ('Ilerna', 'Ilerna', 'Jurado');");
            statement.executeUpdate("INSERT INTO EPI VALUES (1, 'Zapatos', '42', 5), (2, 'Zapatos', '39', 1), (3, 'Zapatos', '41', 3), (4, 'Zapatos', '43', 2), (5, 'Camiseta marga corta', 'M', 3), (6, 'Camiseta marga corta', 'L', 5), (7, 'Camiseta marga corta', 'XL', 3), (8, 'Camiseta marga corta', 'XXL', 10), (9, 'Camiseta marga larga', 'XXL', 1), (10, 'Camiseta marga larga', 'XL', 4), (11, 'Camiseta marga larga', 'L', 7), (12, 'Camiseta marga larga', 'M', 2), (13, 'Forro polar', 'M', 6), (14, 'Forro polar', 'L', 8), (15, 'Forro polar', 'XL', 7);");
            statement.executeUpdate("INSERT INTO EMPLEADO (Id_empleado, Nombre, Apellido1, Apellido2, Puesto) VALUES (101, 'Erika', 'Carnicer', 'Blanco', 'Encargada planta'), (NULL, 'Pedro', 'Alias', 'Gracia', 'Operador maquina'), (NULL, 'Angel', 'Martinez', 'Martinez', 'Operador maquina'), (NULL, 'Maria', 'Girona', 'Bergasa', 'Operador maquina'), (NULL, 'Alejandro', 'Pablo', 'Calvo', 'Operador maquina'), (NULL, 'Marcos', 'Hernandez', 'Perez', 'Operador maquina'), (NULL, 'Nestor', 'fernandez', 'Sanchez', 'Operador produccion'), (NULL, 'Carmen', 'García', 'Rodriguez', 'Operador produccion'), (NULL, 'Daniel', 'Gonlalez', 'Martin', 'Operador produccion'), (NULL, 'Jose', 'Heredia', 'Artal', 'Operador produccion'), (NULL, 'Fernando', 'Cebolla', 'España', 'Operador produccion'), (NULL, 'Jesus', 'Moreno', 'Franco', 'Calidad'), (NULL, 'Adrian', 'Tauste', 'Zaragoza', 'Responsable planta');");
            System.out.println("Datos iniciales insertados correctamente.");
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error al crear las tablas y los datos iniciales: " + e.getMessage());
        }
    }
    
    // Métodos para preparar consulta
    public PreparedStatement prepararConsulta(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }
    // metodo para ejecutar consulta
    public ResultSet ejecutarConsulta(PreparedStatement statement) throws SQLException {
        return statement.executeQuery();
    }
    // metodo para ejecutar update
    public int ejecutarActualizacion(PreparedStatement statement) throws SQLException {
        return statement.executeUpdate();
    }
    
    // Método para desconectar de la base de datos
    public void desconectar() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Desconexión exitosa de la base de datos.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}