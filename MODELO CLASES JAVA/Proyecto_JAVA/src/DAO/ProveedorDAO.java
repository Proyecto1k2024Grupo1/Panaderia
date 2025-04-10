package DAO;

/**
 * Clase que maneja las operaciones de acceso a datos para los proveedores en la base de datos.
 * Esta clase proporciona implementaciones para insertar, actualizar, eliminar y obtener proveedores.
 * Utiliza consultas SQL predefinidas para interactuar con la tabla PROVEEDOR.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @date 10/04/2025
 */

import Model.Proveedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    private static ProveedorDAO instance;
    private Connection connection;

    // Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO PROVEEDOR (nombre) VALUES (?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM PROVEEDOR";
    private static final String UPDATE_QUERY = "UPDATE PROVEEDOR SET nombre = ? WHERE codProveedor = ?";
    private static final String DELETE_QUERY = "DELETE FROM PROVEEDOR WHERE codProveedor = ?";

    /**
     * Constructor privado para evitar la creación de instancias fuera de la clase.
     * Inicializa la conexión a la base de datos.
     */
    private ProveedorDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la instancia única de ProveedorDAO (patrón Singleton).
     * @return La única instancia de ProveedorDAO.
     */
    public static synchronized ProveedorDAO getInstance() {
        if (instance == null) {
            instance = new ProveedorDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo proveedor en la base de datos.
     * @param proveedor El proveedor a insertar.
     * @throws SQLException Si ocurre un error al insertar en la base de datos.
     */
    public void insertProveedor(Proveedor proveedor) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, proveedor.getNombre());
            statement.executeUpdate(); // Ejecuta la inserción
        }
    }

    /**
     * Obtiene todos los proveedores almacenados en la base de datos.
     * @return Lista de proveedores.
     * @throws SQLException Si ocurre un error al recuperar los datos.
     */
    public List<Proveedor> getAllProveedores() throws SQLException {
        List<Proveedor> proveedores = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                proveedores.add(resultSetToProveedor(resultSet));
            }
        }
        return proveedores;
    }

    /**
     * Convierte un ResultSet en un objeto Proveedor.
     * @param resultSet El resultado de la consulta SQL.
     * @return Un objeto Proveedor que contiene los datos extraídos del ResultSet.
     * @throws SQLException Si ocurre un error al extraer los datos del ResultSet.
     */
    private Proveedor resultSetToProveedor(ResultSet resultSet) throws SQLException {
        return new Proveedor(
                resultSet.getInt("codProveedor"),
                resultSet.getString("nombre")
        );
    }

    /**
     * Actualiza los datos de un proveedor en la base de datos.
     * @param proveedor El proveedor con los nuevos datos.
     * @throws SQLException Si ocurre un error al actualizar los datos en la base de datos.
     */
    public void updateProveedor(Proveedor proveedor) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, proveedor.getNombre());
            statement.setInt(2, proveedor.getCodProveedor());
            statement.executeUpdate(); // Ejecuta la actualización
        }
    }

    /**
     * Elimina un proveedor de la base de datos usando su ID.
     * @param id El identificador del proveedor a eliminar.
     * @throws SQLException Si ocurre un error al eliminar el proveedor de la base de datos.
     */
    public void deleteProveedorById(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate(); // Ejecuta la eliminación
        }
    }
}
