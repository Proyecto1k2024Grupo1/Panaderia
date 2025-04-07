package DAO;

/**
 * @author Vanesa, Silvia, Jessica
 */

import Model.Propio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PropioDAO extends ProductoDAO {
    private static PropioDAO instance;

    private Connection connection;

    //Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO PROPIO (codigo) VALUES (?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM PROPIO";
    private static final String UPDATE_QUERY = "UPDATE PROPIO SET codigo = ?";
    private static final String DELETE_QUERY = "DELETE FROM PROPIO WHERE codigo = ?";


    /**
     * Método estático para obtener la única instancia de AjenoDAO.
     * @return instancia única de AjenoDAO.
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
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(INSERT_QUERY_SUPER)
        ) {
            statement2.setString(1, propio.getNombre());
            statement2.setString(2, propio.getTipo());
            statement2.setDouble(3, propio.getPrecio());
            statement2.executeUpdate();

            ResultSet resultSet2 = statement2.getGeneratedKeys();

            statement.setInt(1, resultSet2.getInt(1));
            statement.executeUpdate();

            connection.commit();
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
     * Convierte un ResultSet en un objeto Propio.
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto Propio con los datos del ResultSet.
     * @throws SQLException Por si ocurre un error en la conversión.
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
     * @param propio Objeto Propio con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updatePropio(Propio propio) throws SQLException {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(UPDATE_QUERY_SUPER)
        ) {
            statement2.setInt(1, propio.getCodigo());
            statement2.setString(2, propio.getNombre());
            statement2.setString(3, propio.getTipo());
            statement2.setDouble(4, propio.getPrecio());
            statement2.executeUpdate();

            statement.setInt(1, propio.getCodigo());
            statement.executeUpdate();

            connection.commit();

        }
    }

    /**
     * Elimina un objeto Propio de la base de datos por su código.
     * @param codigo Identificador único del producto propio a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deletePropioByCodigo(int codigo) throws SQLException {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            PreparedStatement statement2 = connection.prepareStatement(DELETE_QUERY_SUPER)
        ) {
            statement.setInt(1, codigo);
            statement.executeUpdate();

            statement2.setInt(1, codigo);
            statement2.executeUpdate();

            connection.commit();
        }
    }


}
