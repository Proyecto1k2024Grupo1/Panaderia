package DAO;

import Model.Compra;
import Model.Dependiente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {
    private static CompraDAO instance;
    private Connection connection;

    private static final String INSERT_QUERY = "INSERT INTO COMPRA (fecha, idCliente) VALUES (CURDATE(), ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM COMPRA";
    private static final String UPDATE_QUERY = "UPDATE COMPRA SET idCliente = ? where numCompra = ? ";
    private static final String UPDATE_QUERY_DEPENDIENTE = "UPDATE COMPRA SET dniDependiente = ?, descuentoDependiente = ?, fechaDependiente = CURDATE() where numCompra = ? ";
    private static final String UPDATE_QUERY_REPARTIDOR = "UPDATE COMPRA SET dniRepartidor = ?, fechaRepartido = CURDATE(), horaRepartidor = CURTIME() where numCompra = ? ";
    private static final String DELETE_QUERY = "DELETE FROM COMPRA WHERE numCompra = ?";

    /**
     * Método estático para obtener la única instancia de DependienteDAO.
     * @return instancia única de DependienteDAO.
     */
    private CompraDAO(){
        this.connection = DBConnection.getConnection();
    }


    public void insertCompra(Compra compra) throws SQLException {

        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
        ) {
            statement.setInt(1, compra.getCliente().getIdCliente());
            statement.executeUpdate();

        }
    }

    /**
     * Obtiene todos los dependientes almacenados en la base de datos.
     * @return Lista de objetos dependientes.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public List<Compra> getAllCompra() throws SQLException {
        List<Compra> Compras = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Compras.add(resultSetToCompra(resultSet));
            }
        }
        return Compras;
    }

    /**
     * Convierte un ResultSet en un objeto dependiente.
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto Dependiente con los datos del ResultSet.
     * @throws SQLException Por si ocurre un error en la conversión.
     */
    private Compra resultSetToCompra(ResultSet resultSet) throws SQLException {
        return new Compra(
                resultSet.getInt("numCompra")
        );
    }

    /**
     * Actualiza los datos de un dependiente en la base de datos.
     * @param dependiente dependiente con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updateDependiente(Dependiente dependiente) throws SQLException {
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY_SUPER);
             PreparedStatement statement2 = connection.prepareStatement(UPDATE_QUERY)
        ) {
            statement.setDouble(1, dependiente.getSalario());
            statement.setDate(2, Date.valueOf(dependiente.getFnac()));
            statement.setString(3, dependiente.getNombre());
            statement.setString(4, dependiente.getEncargado().getDni());
            statement.setString(5, dependiente.getDni());
            statement.executeUpdate();


            statement2.setString(1,dependiente.getHorario());
            statement2.setString(2, dependiente.getDni());
            statement2.executeUpdate();

            connection.commit();
        }
    }

    /**
     * Elimina un dependiente de la base de datos por su DNI.
     * @param dni Identificador único del dependiente a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deleteDependienteByDni(String dni) throws SQLException {
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(DELETE_QUERY_SUPER)
        ) {
            statement.setString(1, dni);
            statement.executeUpdate();

            statement2.setString(1, dni);
            statement2.executeUpdate();

            connection.commit();
        }
    }
}
