package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para gestionar la conexión a la base de datos.
 * Utiliza un patrón Singleton para mantener una única conexión activa.
 *
 * Proporciona métodos para obtener y cerrar la conexión con la base de datos.
 * La conexión se establece utilizando los parámetros definidos en las constantes.
 *
 * Esta clase es fundamental para centralizar el acceso a la base de datos y
 * garantizar la reutilización eficiente de la conexión.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @since 10/04/2025
 */
public class DBConnection {

    /**
     * URL de conexión a la base de datos MariaDB.
     */
    private static final String URL = "jdbc:mariadb://panaderia.cnou80g8ic24.us-east-1.rds.amazonaws.com:3306/Panaderia";

    /**
     * Nombre de usuario para acceder a la base de datos.
     */
    private static final String USERNAME = "admin";

    /**
     * Contraseña del usuario para acceder a la base de datos.
     */
    private static final String PASSWORD = "JessicaSilviaVanesa";

    /**
     * Objeto Connection que mantiene la conexión activa con la base de datos.
     */
    private static Connection connection;

    /**
     * Constructor privado para evitar la creación de instancias de la clase.
     */
    private DBConnection() {}

    /**
     * Obtiene la instancia única de la conexión con la base de datos.
     * Si no existe una conexión previa, se crea una nueva.
     *
     * @return Objeto Connection para interactuar con la base de datos.
     */
    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DBConnection.class) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }

    /**
     * Cierra la conexión activa con la base de datos si existe.
     * Establece la referencia de conexión a null tras cerrarla.
     */
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
