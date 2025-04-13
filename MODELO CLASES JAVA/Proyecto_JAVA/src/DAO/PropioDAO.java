package DAO;

/**
 * Clase que maneja las operaciones de acceso a datos para los productos propios en la base de datos.
 * Esta clase extiende de ProductoDAO, proporcionando implementaciones específicas para insertar, actualizar,
 * eliminar y obtener productos propios. Utiliza consultas SQL predefinidas para interactuar con la tabla PROPIO.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @date 10/04/2025
 */

import Model.Propio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropioDAO extends ProductoDAO {

    private static PropioDAO instance;
    private Connection connection;

    // Consultas SQL predefinidas para la tabla PROPIO
    private static final String INSERT_QUERY = "INSERT INTO PROPIO (codigo) VALUES (?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM PROPIO";
    private static final String UPDATE_QUERY = "UPDATE PROPIO SET codigo = ? WHERE codigo = ?";
    private static final String DELETE_QUERY = "DELETE FROM PROPIO WHERE codigo = ?";
    private static final String SELECT_BY_ID_QUERY =
            "SELECT p.codigo, p.nombre, p.tipo, p.precio " +
                    "FROM PRODUCTO p " +
                    "JOIN PROPIO pr ON p.codigo = pr.codigo " +
                    "WHERE p.codigo = ?";


    /**
     * Constructor privado para evitar instanciación directa.
     * Inicializa la conexión a la base de datos.
     */
    private PropioDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la instancia única de PropioDAO (patrón Singleton).
     * @return La única instancia de PropioDAO.
     */
    public static synchronized PropioDAO getInstance() {
        if (instance == null) {
            instance = new PropioDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo producto propio en la base de datos.
     * Utiliza transacciones para garantizar la consistencia de los datos.
     * @param propio Objeto Propio que contiene los datos del producto a insertar.
     * @throws SQLException Si ocurre un error al insertar en la base de datos.
     */
    public void insertPropio(Propio propio) throws SQLException {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(INSERT_QUERY_SUPER)) {

            // Inserta el producto en la tabla de productos generales.
            statement2.setString(1, propio.getNombre());
            statement2.setString(2, propio.getTipo());
            statement2.setDouble(3, propio.getPrecio());
            statement2.executeUpdate();

            // Recupera el código generado automáticamente y lo inserta en la tabla PROPIO.
            ResultSet resultSet2 = statement2.getGeneratedKeys();
            if (resultSet2.next()) {
                statement.setInt(1, resultSet2.getInt(1));
                statement.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e; // Vuelve a lanzar la excepción para que el controlador la maneje
        } finally {
            connection.setAutoCommit(true); // Restablece la auto-commit
        }
    }

    /**
     * Obtiene todos los productos propios almacenados en la base de datos.
     * @return Lista de objetos Propio representando todos los productos propios.
     * @throws SQLException Si ocurre un error al recuperar los datos.
     */
    public List<Propio> getAllPropio() throws SQLException {
        List<Propio> propios = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                propios.add(resultSetToPropio(resultSet));
            }
        }
        return propios;
    }

    /**
     * Convierte un ResultSet en un objeto Propio.
     * @param resultSet El resultado de la consulta SQL.
     * @return Un objeto Propio que contiene los datos del producto.
     * @throws SQLException Si ocurre un error al extraer los datos del ResultSet.
     */
    private Propio resultSetToPropio(ResultSet resultSet) throws SQLException {
        return new Propio(
                resultSet.getInt("codigo"),
                resultSet.getString("nombre"),
                resultSet.getString("tipo"),
                resultSet.getDouble("precio")
        );
    }

    /**
     * Actualiza los datos de un producto propio en la base de datos.
     * Utiliza transacciones para garantizar la consistencia de los datos.
     * @param propio El objeto Propio con los nuevos datos a actualizar.
     * @throws SQLException Si ocurre un error al actualizar los datos en la base de datos.
     */
    public void updatePropio(Propio propio) throws SQLException {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(UPDATE_QUERY_SUPER)) {

            // Actualiza el producto en la tabla de productos generales.
            statement2.setInt(1, propio.getCodigo());
            statement2.setString(2, propio.getNombre());
            statement2.setString(3, propio.getTipo());
            statement2.setDouble(4, propio.getPrecio());
            statement2.executeUpdate();

            // Actualiza el producto en la tabla PROPIO.
            statement.setInt(1, propio.getCodigo());
            statement.setInt(2, propio.getCodigo());
            statement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e; // Vuelve a lanzar la excepción para que el controlador la maneje
        } finally {
            connection.setAutoCommit(true); // Restablece la auto-commit
        }
    }

    /**
     * Elimina un producto propio de la base de datos utilizando su código.
     * @param codigo El identificador único del producto propio a eliminar.
     * @throws SQLException Si ocurre un error al eliminar los datos en la base de datos.
     */
    public void deletePropioByCodigo(int codigo) throws SQLException {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(DELETE_QUERY_SUPER)) {

            // Elimina el producto en la tabla PROPIO.
            statement.setInt(1, codigo);
            statement.executeUpdate();

            // Elimina el producto en la tabla de productos generales.
            statement2.setInt(1, codigo);
            statement2.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e; // Vuelve a lanzar la excepción para que el controlador la maneje
        } finally {
            connection.setAutoCommit(true); // Restablece la auto-commit
        }
    }
    /**
     * Consulta un producto propio en la base de datos a partir de su código.
     * @param codigo El identificador único del producto.
     * @return Un objeto Propio con los datos del producto, o null si no se encuentra.
     * @throws SQLException Si ocurre un error al consultar los datos.
     */
    public Propio getPropioByCodigo(int codigo) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSetToPropio(resultSet);
            } else {
                return null;
            }
        }
    }
}
