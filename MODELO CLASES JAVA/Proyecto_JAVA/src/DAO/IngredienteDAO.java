package DAO;
import Model.Ingrediente;

/**
 * @author Vanesa, Silvia, Jessica
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDAO {
    private static IngredienteDAO instance;
    private Connection connection;

    //Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO INGREDIENTE (nombre, descripcion) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM INGREDIENTE";
    static final String UPDATE_QUERY = "UPDATE INGREDIENTE SET nombre = ?, descripcion = ? WHERE codIngrediente = ?";
    private static final String DELETE_QUERY = "DELETE FROM INGREDIENTE WHERE codIngrediente = ?";

    // Conexión a la base de datos
    private IngredienteDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Obtiene la instancia única del DAO (patrón Singleton)
     * @return Instancia única del IngredienteDAO
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
     * @param ingrediente El objeto Ingrediente a insertar.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    public void insertIngrediente(Ingrediente ingrediente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, ingrediente.getCodIngrediente());
            statement.setString(2, ingrediente.getNombre());
            statement.setString(3, ingrediente.getDescripcion());
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene todos los ingredientes desde la base de datos.
     *
     * @return Una lista de objetos Ingrediente que representan todos los ingredientes en la base de datos.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
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
     * Actualiza los detalles de un ingrediente en la base de datos.
     *
     * @param ingrediente El objeto Ingrediente con los nuevos valores a actualizar.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
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
     * Elimina un ingrediente de la base de datos mediante su código.
     *
     * @param codIngrediente El código del ingrediente a eliminar.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    public void deleteIngredienteById(String codIngrediente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, codIngrediente);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet de la base de datos en un objeto Ingrediente.
     *
     * @param resultSet El ResultSet que contiene los datos del ingrediente.
     * @return Un objeto Ingrediente con los datos extraídos del ResultSet.
     * @throws SQLException Si ocurre un error al acceder al ResultSet.
     */
    private Ingrediente resultSetToIngrediente(ResultSet resultSet) throws SQLException {
        return new Ingrediente(
                resultSet.getInt("codIngrediente"),
                resultSet.getString("nombre"),
                resultSet.getString("descripcion")
        );

    }

}