package DAO;

import Model.Ajeno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Clase DAO (Data Access Object) para gestionar los productos ajenos en la base de datos.
 */

public class AjenoDAO extends ProductoDAO {

    private static AjenoDAO instance;
    private Connection connection;

    // Consultas SQL predefinidas para la tabla AJENO
    private static final String INSERT_QUERY = "INSERT INTO AJENO (codigo) VALUES (?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM AJENO a JOIN PRODUCTO pr ON a.codigo = pr.codigo";
    private static final String UPDATE_QUERY = "UPDATE AJENO SET codigo = ? WHERE codigo = ?";
    private static final String DELETE_QUERY = "DELETE FROM AJENO WHERE codigo = ?";
    private static final String SELECT_BY_ID_QUERY =
            "SELECT p.codigo, p.nombre, p.tipo, p.precio " +
                    "FROM PRODUCTO p " +
                    "JOIN AJENO a ON p.codigo = a.codigo " +
                    "WHERE p.codigo = ?";

    /**
     * Constructor privado para evitar instanciación directa.
     * Inicializa la conexión a la base de datos.
     */
    private AjenoDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la instancia única de AjenoDAO (patrón Singleton).
     * @return La única instancia de AjenoDAO.
     */
    public static synchronized AjenoDAO getInstance() {
        if (instance == null) {
            instance = new AjenoDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo producto ajeno en la base de datos.
     * Utiliza transacciones para garantizar la consistencia de los datos.
     * @param ajeno Objeto Ajeno que contiene los datos del producto a insertar.
     * @throws SQLException Si ocurre un error al insertar en la base de datos.
     */
    public void insertAjeno(Ajeno ajeno) throws SQLException {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement statement2 = connection.prepareStatement(INSERT_QUERY_SUPER, Statement.RETURN_GENERATED_KEYS)) {

            // Inserta el producto en la tabla de productos generales.
            statement2.setString(1, ajeno.getNombre());
            statement2.setString(2, ajeno.getTipo());
            statement2.setDouble(3, ajeno.getPrecio());
            statement2.executeUpdate();

            // Recupera el código generado automáticamente y lo inserta en la tabla AJENO.
            ResultSet resultSet2 = statement2.getGeneratedKeys();
            if (resultSet2.next()) {
                int generatedCode = resultSet2.getInt(1);  // Aquí obtienes el código generado
                statement.setInt(1, generatedCode);  // Usa ese código para la tabla AJENO
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
     * Obtiene todos los productos ajenos almacenados en la base de datos.
     * @return Lista de objetos Ajeno representando todos los productos ajenos.
     * @throws SQLException Si ocurre un error al recuperar los datos.
     */
    public List<Ajeno> getAllAjenos() throws SQLException {
        List<Ajeno> ajenosList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ajenosList.add(resultSetToAjeno(resultSet));
            }
        }
        return ajenosList;
    }

    /**
     * Convierte un ResultSet en un objeto Ajeno.
     * @param resultSet El resultado de la consulta SQL.
     * @return Un objeto Ajeno que contiene los datos del producto.
     * @throws SQLException Si ocurre un error al extraer los datos del ResultSet.
     */
    private Ajeno resultSetToAjeno(ResultSet resultSet) throws SQLException {
        return new Ajeno(
                resultSet.getInt("codigo"),
                resultSet.getString("nombre"),
                resultSet.getString("tipo"),
                resultSet.getDouble("precio")
        );
    }

    /**
     * Actualiza los datos de un producto ajeno en la base de datos.
     * Utiliza transacciones para garantizar la consistencia de los datos.
     * @param ajeno El objeto Ajeno con los nuevos datos a actualizar.
     * @throws SQLException Si ocurre un error al actualizar los datos en la base de datos.
     */
    public void updateAjeno(Ajeno ajeno) throws SQLException {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(UPDATE_QUERY_SUPER)) {

            // Actualiza el producto en la tabla de productos generales.
            statement2.setString(1, ajeno.getNombre());
            statement2.setString(2, ajeno.getTipo());
            statement2.setDouble(3, ajeno.getPrecio());
            statement2.setInt(4, ajeno.getCodigo());
            statement2.executeUpdate();

            // Actualiza el producto en la tabla AJENO.
            statement.setInt(1, ajeno.getCodigo());
            statement.setInt(2, ajeno.getCodigo());
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
     * Elimina un producto ajeno de la base de datos utilizando su código.
     * @param codigo El identificador único del producto ajeno a eliminar.
     * @throws SQLException Si ocurre un error al eliminar los datos en la base de datos.
     */
    public void deleteAjenoByCodigo(int codigo) throws SQLException {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(DELETE_QUERY_SUPER)) {

            // Elimina el producto en la tabla AJENO.
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
     * Consulta un producto ajeno en la base de datos a partir de su código.
     * @param codigo El identificador único del producto.
     * @return Un objeto Ajeno con los datos del producto, o null si no se encuentra.
     * @throws SQLException Si ocurre un error al consultar los datos.
     */
    public Ajeno getAjenoByCodigo(int codigo) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSetToAjeno(resultSet);
            } else {
                return null;
            }
        }
    }
}
