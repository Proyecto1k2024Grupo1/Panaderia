package DAO;

import Model.LineaDeTicket;
import Model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar las operaciones CRUD de las líneas de ticket en la base de datos.
 * Implementa métodos para insertar, actualizar, eliminar y obtener líneas de ticket.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @date 10/04/2025
 */
public class LineaDeTicketDAO {

    private static LineaDeTicketDAO instance;
    private Connection connection;

    // Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO LINEA_DE_TICKET (numCompra, numLinea, codProducto, cantidad) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT numCompra, numLinea, codProducto, cantidad FROM LINEA_DE_TICKET";  // Mejor especificar columnas
    private static final String UPDATE_QUERY = "UPDATE LINEA_DE_TICKET SET codProducto = ?, cantidad = ? WHERE numCompra = ? AND numLinea = ?";
    private static final String DELETE_QUERY = "DELETE FROM LINEA_DE_TICKET WHERE numCompra = ? AND numLinea = ?";

    /**
     * Constructor privado para evitar la instanciación externa de esta clase.
     * Establece la conexión con la base de datos a través de la clase DBConnection.
     */
    private LineaDeTicketDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la única instancia de LineaDeTicketDAO.
     * Este método sigue el patrón Singleton, asegurando que solo haya una instancia de esta clase.
     *
     * @return La instancia única de LineaDeTicketDAO.
     */
    public static synchronized LineaDeTicketDAO getInstance() {
        if (instance == null) {
            instance = new LineaDeTicketDAO();
        }
        return instance;
    }

    /**
     * Inserta una nueva línea de ticket en la base de datos.
     * Este método ejecuta una transacción que se confirma si la inserción es exitosa,
     * y se revierte en caso de error.
     *
     * @param linea La línea de ticket a insertar.
     * @throws SQLException Si ocurre un error en la base de datos durante la operación.
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
        } catch (SQLException e) {
            connection.rollback();  // Hacer rollback en caso de error
            throw e;  // Re-lanzar la excepción para manejarla en la capa superior
        } finally {
            connection.setAutoCommit(true);  // Restaurar auto-commit
        }
    }

    /**
     * Obtiene todas las líneas de ticket almacenadas en la base de datos.
     * Este método ejecuta una consulta SELECT que obtiene todas las líneas de ticket.
     *
     * @return Una lista de objetos LineaDeTicket representando todas las líneas de ticket en la base de datos.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
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
     * Convierte un objeto ResultSet en una instancia de LineaDeTicket.
     * Este método mapea cada columna del ResultSet a los atributos del objeto LineaDeTicket.
     *
     * @param resultSet El ResultSet obtenido de la consulta SQL.
     * @return Una instancia de LineaDeTicket con los datos del ResultSet.
     * @throws SQLException Si ocurre un error al obtener los datos del ResultSet.
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
     * Este método ejecuta una transacción para actualizar la línea de ticket. Si ocurre un error,
     * la transacción se revierte.
     *
     * @param linea La línea de ticket con los nuevos datos a actualizar.
     * @throws SQLException Si ocurre un error en la base de datos durante la operación.
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
        } catch (SQLException e) {
            connection.rollback();  // Hacer rollback en caso de error
            throw e;  // Re-lanzar la excepción para manejo posterior
        } finally {
            connection.setAutoCommit(true);  // Restaurar auto-commit
        }
    }

    /**
     * Elimina una línea de ticket de la base de datos mediante los identificadores numCompra y numLinea.
     * Este método ejecuta una transacción para eliminar la línea de ticket. Si ocurre un error,
     * la transacción se revierte.
     *
     * @param numCompra El identificador único de la compra a la que pertenece la línea de ticket.
     * @param numLinea El identificador único de la línea dentro de la compra.
     * @throws SQLException Si ocurre un error en la base de datos durante la operación.
     */
    public void deleteLineaDeTicket(int numCompra, int numLinea) throws SQLException {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, numCompra);
            statement.setInt(2, numLinea);

            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();  // Hacer rollback en caso de error
            throw e;  // Re-lanzar la excepción para manejo posterior
        } finally {
            connection.setAutoCommit(true);  // Restaurar auto-commit
        }
    }
}
