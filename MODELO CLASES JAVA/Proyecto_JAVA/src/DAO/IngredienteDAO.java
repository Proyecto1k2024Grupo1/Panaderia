package DAO;
import Model.Ingrediente;

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


    private IngredienteDAO() {
        this.connection = DBConnection.getConnection();
    }


    public static synchronized IngredienteDAO getInstance() {
        if (instance == null) {
            instance = new IngredienteDAO();
        }
        return instance;
    }

    public void insertIngrediente(Ingrediente ingrediente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, ingrediente.getCodIngrediente());
            statement.setString(2, ingrediente.getNombre());
            statement.setString(3, ingrediente.getDescripcion());
            statement.executeUpdate();
        }
    }

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


    public void updateIngrediente(Ingrediente ingrediente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, ingrediente.getCodIngrediente());
            statement.setString(2, ingrediente.getNombre());
            statement.setString(3, ingrediente.getDescripcion());
            statement.executeUpdate();
        }
    }

    public void deleteIngredienteById(String codIngrediente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, codIngrediente);
            statement.executeUpdate();
        }
    }

    private Ingrediente resultSetToIngrediente(ResultSet resultSet) throws SQLException {
        return new Ingrediente(
                resultSet.getInt("codIngrediente"),
                resultSet.getString("nombre"),
                resultSet.getString("descripcion")
        );

    }

}