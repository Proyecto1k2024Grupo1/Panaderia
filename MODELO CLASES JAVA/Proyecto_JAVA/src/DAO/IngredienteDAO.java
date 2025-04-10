package DAO;
import Model.Ingrediente;

/**
 * Clase que maneja las operaciones de acceso a datos de la tabla INGREDIENTE en la base de datos.
 * Permite realizar las operaciones básicas: insertar, obtener todos, actualizar y eliminar ingredientes.
 * Esta clase sigue el patrón Singleton para garantizar que solo haya una instancia de la misma.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @date 10/04/2025
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDAO {
    // Instancia única de IngredienteDAO (patrón Singleton)
    private static IngredienteDAO instance;

    // Conexión a la base de datos
    private Connection connection;

    // Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO INGREDIENTE (nombre, descripcion) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM INGREDIENTE";
    static final String UPDATE_QUERY = "UPDATE INGREDIENTE SET nombre = ?, descripcion = ? WHERE codIngrediente = ?";
    private static final String DELETE_QUERY = "DELETE FROM INGREDIENTE WHERE codIngrediente = ?";

    /**
     * Constructor privado para inicializar la conexión a la base de datos.
     */
    private IngredienteDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Obtiene la única instancia de IngredienteDAO (patrón Singleton).
     *
     * @return La instancia única de IngredienteDAO.
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
     * @param ingrediente El ingrediente a insertar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void insertIngrediente(Ingrediente ingrediente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, ingrediente.getNombre());
            statement.setString(2, ingrediente.getDescripcion());
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene todos los ingredientes almacenados en la base de datos.
     *
     * @return Lista de objetos Ingrediente.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public List<Ingrediente> getAllIngredientes() throws SQLException {
        List<Ingrediente> ingredientes = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ingredientes.add(resultSetToIngrediente(resultSet));
            }
        }
        return ingredientes;
    }

    /**
     * Actualiza los datos de un ingrediente en la base de datos.
     *
     * @param ingrediente El ingrediente con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updateIngrediente(Ingrediente ingrediente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, ingrediente.getNombre());
            statement.setString(2, ingrediente.getDescripcion());
            statement.setInt(3, ingrediente.getCodIngrediente());  // El código de ingrediente debe ser el último parámetro
            statement.executeUpdate();
        }
    }

    /**
     * Elimina un ingrediente de la base de datos por su código de ingrediente.
     *
     * @param codIngrediente El código del ingrediente a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deleteIngredienteById(int codIngrediente) throws SQLException {  // Cambié el tipo de String a int porque el código de ingrediente parece ser numérico
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, codIngrediente);  // Asumí que 'codIngrediente' es de tipo int
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto Ingrediente.
     *
     * @param resultSet El ResultSet obtenido de la consulta SQL.
     * @return Un objeto Ingrediente con los datos extraídos del ResultSet.
     * @throws SQLException Si ocurre un error en la conversión.
     */
    private Ingrediente resultSetToIngrediente(ResultSet resultSet) throws SQLException {
        return new Ingrediente(
                resultSet.getInt("codIngrediente"),
                resultSet.getString("nombre"),
                resultSet.getString("descripcion")
        );
    }
}
