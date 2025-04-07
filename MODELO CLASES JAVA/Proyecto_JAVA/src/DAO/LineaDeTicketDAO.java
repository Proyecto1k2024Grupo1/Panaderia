package DAO;

/**
 * @author Vanesa, Silvia, Jessica
 */

import Model.LineaDeTicket;
import Model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LineaDeTicketDAO {


    private static LineaDeTicketDAO instance;
    private Connection connection;

    // Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO LINEA_DE_TICKET (numCompra, numLinea, codProducto, cantidad) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM LINEA_DE_TICKET";
    private static final String UPDATE_QUERY = "UPDATE LINEA_DE_TICKET SET codProducto = ?, cantidad = ? WHERE numCompra = ? AND numLinea = ?";
    private static final String DELETE_QUERY = "DELETE FROM LINEA_DE_TICKET WHERE numCompra = ? AND numLinea = ?";

    /**
     * Método estático para obtener la única instancia de LineaDeTicketDAO.
     *
     * @return instancia única de LineaDeTicketDAO.
     */
    private LineaDeTicketDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Inserta una nueva línea de ticket en la base de datos
     *
     * @param linea De Ticket a insertar.
     * @throws SQLException Si ocurre un error en la base de datos
     */
    public void insertLineaDeTicket(LineaDeTicket linea) throws SQLException {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, linea.getNumCompra());
            statement.setInt(2, linea.getNumLinea());
            statement.setInt(3, linea.getProducto().getCodigo());
            statement.setInt(4, linea.getCantidad());

            statement.executeUpdate();
            connection.commit();
        }
    }

    /**
     * Obtiene todas las líneas de ticket almacenadas en la base de datos.
     *
     * @return Lista de objetos LineaDeTicket.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public List<LineaDeTicket> getAllLineasDeTicket() throws SQLException {
        List<LineaDeTicket> lineas = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lineas.add(resultSetToLineaDeTicket(resultSet));
            }
        }
        return lineas;
    }

    /**
     * Convierte un ResultSet en un objeto LineaDeTicket.
     *
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto LineaDeTicket con los datos del ResultSet.
     * @throws SQLException Por si ocurre un error en la conversión.
     */
    private LineaDeTicket resultSetToLineaDeTicket(ResultSet resultSet) throws SQLException {
        return new LineaDeTicket(
                resultSet.getInt("numCompra"),
                resultSet.getInt("numLinea"),
                resultSet.getInt("codProducto"),
                resultSet.getInt("cantidad")
        );
    }

    /**
     * Actualiza los datos de una línea de ticket en la base de datos.
     *
     * @param linea Línea de Ticket a actualizar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updateLineaDeTicket(LineaDeTicket linea) throws SQLException {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, linea.getProducto().getCodigo());
            statement.setInt(2, linea.getCantidad());
            statement.setInt(3, linea.getNumCompra());
            statement.setInt(4, linea.getNumLinea());

            statement.executeUpdate();
            connection.commit();
        }
    }

    /**
     * Elimina una línea de ticket de la base de datos por su numCompra y numLinea.
     *
     * @param numCompra Identificador único de la compra.
     * @param numLinea  Identificador único de la línea dentro de la compra.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deleteLineaDeTicket(int numCompra, int numLinea) throws SQLException {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, numCompra);
            statement.setInt(2, numLinea);

            statement.executeUpdate();
            connection.commit();
        }
    }


}
