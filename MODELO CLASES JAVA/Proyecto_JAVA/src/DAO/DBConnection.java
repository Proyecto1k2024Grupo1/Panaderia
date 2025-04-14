package DAO;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para realizar la conexión.
 *
 * @author Vanesa, Silvia, Jessica
 */

public class DBConnection {
    // URL de conexión a la base de datos MySQL
    private static final String URL = "jdbc:mariadb://panaderia.cnou80g8ic24.us-east-1.rds.amazonaws.com:3306/Panaderia";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "JessicaSilviaVanesa";

    private static Connection connection;

    // Constructor privado para evitar instancias directas
    private DBConnection() {}

    // Método estático para obtener la instancia única de la conexión
    public static Connection getConnection() {
        if (connection == null) {
            // Bloqueo sincronizado para evitar concurrencia
            synchronized (DBConnection.class) {
                if (connection == null) {
                    try {
                        // Establecer la conexión
                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    } catch ( SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }

    // Método para cerrar la conexión
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}