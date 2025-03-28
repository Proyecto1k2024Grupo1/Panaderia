package Ajeno;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Clases.Ajeno;

public class AjenoDao {

    private static AjenoDao instance;

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
    private AjenoDao(){
        this.connection = DBConnection.getConnection();
    }

    /**
     * Inserta un nuevo producto ajeno en la base de datos
     * @param ajeno Objeto ajeno a insertar.
     * @throws SQLException Si ocurre un error en la base de datos
     */
    public void insertPropio(Ajeno ajeno) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, ajeno.getCodigo());
            statement.executeUpdate();
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
     * Actualiza los datos de un producto ajeno en la base de datos.
     * @param ajeno Objeto ajeno con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updateAjeno(Ajeno ajeno) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, ajeno.getCodigo());
            statement.executeUpdate();
        }
    }

    /**
     * Elimina un objeto Ajeno de la base de datos por su código.
     * @param codigo Identificador único del producto propio a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deleteAjenoByCodigo(int codigo) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, codigo);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto Ajeno.
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto Ajeno con los datos del ResultSet.
     * @throws SQLException Por si ocurre un error en la conversión.
     */
    private Ajeno resultSetToAjeno(ResultSet resultSet) throws SQLException {
        return new Ajeno(
                resultSet.getInt("codigo"));
    }
}
