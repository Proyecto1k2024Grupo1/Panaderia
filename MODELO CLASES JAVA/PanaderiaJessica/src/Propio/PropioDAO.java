package Propio;

import Clases.Propio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PropioDAO {
    private static PropioDAO instance;

    private Connection connection;

    //Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO PROPIO (codigo) VALUES (?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM PROPIO";
    private static final String UPDATE_QUERY = "UPDATE PROPIO SET codigo = ?";
    private static final String DELETE_QUERY = "DELETE FROM PROPIO WHERE codigo = ?";

    /**
     * Método estático para obtener la única instancia de PropioDAO.
     * @return instancia única de PropioDAO.
     */
    private PropioDAO(){
        this.connection = DBConnection.getConnection();
    }

    /**
     * Inserta un nuevo producto propio en la base de datos
     * @param propio Objeto propio a insertar.
     * @throws SQLException Si ocurre un error en la base de datos
     */
    public void insertPropio(Propio propio) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, propio.getCodigo());
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene todos los productos propios almacenados en la base de datos.
     * @return Lista de objetos Propio.
     * @throws SQLException Si ocurre un error en la base de datos.
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
     * Actualiza los datos de un producto propio en la base de datos.
     * @param propio Objeto Propio con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updatePropio(Propio propio) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, propio.getCodigo());
            statement.executeUpdate();
        }
    }

    /**
     * Elimina un objeto Propio de la base de datos por su código.
     * @param codigo Identificador único del producto propio a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deletePropioByCodigo(int codigo) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, codigo);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto Propio.
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto Propio con los datos del ResultSet.
     * @throws SQLException Por si ocurre un error en la conversión.
     */
    private Propio resultSetToPropio(ResultSet resultSet) throws SQLException {
        return new Propio(
                resultSet.getInt("codigo"));
    }
}
