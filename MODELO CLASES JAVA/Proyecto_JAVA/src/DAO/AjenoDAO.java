package DAO;

import Model.Ajeno;

import java.sql.PreparedStatement;

/**
 * @author Vanesa, Silvia, Jessica
 */

import Model.Ajeno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AjenoDAO extends ProductoDAO {
    private static AjenoDAO instance;

    // Conexión a la base de datos
    private Connection connection;

    //Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO AJENO (codigo) VALUES (?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM AJENO";
    private static final String UPDATE_QUERY = "UPDATE AJENO SET codigo = ?";
    private static final String DELETE_QUERY = "DELETE FROM AJENO WHERE codigo = ?";




    /**
     * Método estático para obtener la única instancia de AjenoDAO.
     * @return instancia única de AjenoDAO.
     */
    private AjenoDAO(){
        this.connection = DBConnection.getConnection();
    }

    /**
     * Inserta un nuevo producto Ajeno en la base de datos
     * @param ajeno Objeto ajeno a insertar.
     * @throws SQLException Si ocurre un error en la base de datos
     */
    public void insertAjeno(Ajeno ajeno) throws SQLException {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(INSERT_QUERY_SUPER)
        ) {
            statement2.setString(1, ajeno.getNombre());
            statement2.setString(2, ajeno.getTipo());
            statement2.setDouble(3, ajeno.getPrecio());
            statement2.executeUpdate();

            ResultSet resultSet2 = statement2.getGeneratedKeys();


            statement.setInt(1, resultSet2.getInt(1)); //Aquí insertamos el código que se genera en la clase padre.
            statement.executeUpdate();



            connection.commit();
        }
    }

    /**
     * Obtiene todos los productos ajenos almacenados en la base de datos.
     * @return Lista de objetos Ajeno.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public List<Ajeno> getAllAjeno() throws SQLException {
        List<Ajeno> ajenos = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ajenos.add(resultSetToAjeno(resultSet));
            }
        }
        return ajenos;
    }

    /**
     * Convierte un ResultSet en un objeto Ajeno.
     *
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto Ajeno con los datos del ResultSet.
     * @throws SQLException Por si ocurre un error en la conversión.
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
     * Actualiza los datos de un producto propio en la base de datos.
     * @param ajeno
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updateAjeno(Ajeno ajeno) throws SQLException {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(UPDATE_QUERY_SUPER)
        ) {
            statement2.setInt(1, ajeno.getCodigo());
            statement2.setString(2, ajeno.getNombre());
            statement2.setString(3, ajeno.getTipo());
            statement2.setDouble(4, ajeno.getPrecio());
            statement2.executeUpdate();

            statement.setInt(1,  ajeno.getCodigo());
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