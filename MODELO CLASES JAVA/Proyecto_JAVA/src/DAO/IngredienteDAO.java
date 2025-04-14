package DAO;

import Model.Ingrediente;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar las operaciones CRUD de los ingredientes en la base de datos.
 * Implementa el patrón Singleton para asegurar que solo haya una instancia activa.
 * Proporciona métodos para insertar, actualizar, eliminar y recuperar ingredientes.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @since 10/04/2025
 */

public class IngredienteDAO {

    /**
     * Instancia única de la clase (patrón Singleton).
     */
    private static IngredienteDAO instance;

    /**
     * Conexión a la base de datos.
     */
    private Connection connection;

    /**
     * Consulta SQL para insertar un nuevo ingrediente.
     */
    private static final String INSERT_QUERY = "INSERT INTO INGREDIENTE (nombre, descripcion) VALUES (?, ?)";

    /**
     * Consulta SQL para obtener todos los ingredientes de la base de datos.
     */
    private static final String SELECT_ALL_QUERY = "SELECT * FROM INGREDIENTE";

    /**
     * Consulta SQL para actualizar un ingrediente existente.
     */
    static final String UPDATE_QUERY = "UPDATE INGREDIENTE SET nombre = ?, descripcion = ? WHERE codIngrediente = ?";

    /**
     * Consulta SQL para eliminar un ingrediente según su código.
     */
    private static final String DELETE_QUERY = "DELETE FROM INGREDIENTE WHERE codIngrediente = ?";

    /**
     * Constructor privado que inicializa la conexión.
     */
    private IngredienteDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Devuelve la instancia única de IngredienteDAO.
     * Si no existe, la crea.
     *
     * @return instancia única de IngredienteDAO
     */
    public static synchronized IngredienteDAO getInstance() {
        if (instance == null) {
            instance = new IngredienteDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo ingrediente en la base de datos.
     *
     * @param ingrediente Objeto Ingrediente a insertar
     * @throws SQLException si ocurre un error durante la operación
     */
    public void insertIngrediente(Ingrediente ingrediente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, ingrediente.getNombre());
            statement.setString(2, ingrediente.getDescripcion());
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene todos los ingredientes de la base de datos.
     *
     * @return Lista de ingredientes
     * @throws SQLException si ocurre un error al consultar la base de datos
     */
    public List<Ingrediente> getAllIngredientes() throws SQLException {
        List<Ingrediente> ingrediente = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ingrediente.add(resultSetToIngrediente(resultSet));
            }
        }
        return ingrediente;
    }

    /**
     * Actualiza los datos de un ingrediente en la base de datos.
     *
     * @param ingrediente Objeto Ingrediente con los nuevos datos
     * @throws SQLException si ocurre un error durante la operación
     */
    public void updateIngrediente(Ingrediente ingrediente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, ingrediente.getCodIngrediente());
            statement.setString(2, ingrediente.getNombre());
            statement.setString(3, ingrediente.getDescripcion());
            statement.executeUpdate();
        }
    }

    /**
     * Elimina un ingrediente de la base de datos según su código.
     *
     * @param codIngrediente Código del ingrediente a eliminar
     * @throws SQLException si ocurre un error durante la operación
     */
    public void deleteIngredienteById(String codIngrediente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, codIngrediente);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto Ingrediente.
     *
     * @param resultSet Resultado de la consulta SQL
     * @return Objeto Ingrediente con los datos del resultSet
     * @throws SQLException si ocurre un error al leer el resultSet
     */
    private Ingrediente resultSetToIngrediente(ResultSet resultSet) throws SQLException {
        return new Ingrediente(
                resultSet.getInt("codIngrediente"),
                resultSet.getString("nombre"),
                resultSet.getString("descripcion")
        );
    }

}
