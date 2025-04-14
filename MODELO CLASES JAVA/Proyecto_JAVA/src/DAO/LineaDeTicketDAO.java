package DAO;

import Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar las operaciones CRUD de las líneas de ticket en la base de datos.
 * Implementa métodos para insertar, actualizar, eliminar y obtener líneas de ticket.
 *
 * <p>Utiliza conexión a base de datos a través de {@link DBConnection} y accede a objetos
 * {@link LineaDeTicket}, {@link Compra}, {@link Producto}, {@link Propio} y {@link Ajeno}.
 *
 * <p>Sigue el patrón Singleton para asegurar una única instancia de esta clase.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @since 10/04/2025
 */
public class LineaDeTicketDAO {

    private static LineaDeTicketDAO instance;
    private Connection connection;

    // Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO LINEA_DE_TICKET (numCompra, numLinea, codProducto, cantidad) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE LINEA_DE_TICKET SET codProducto = ?, cantidad = ? WHERE numCompra = ? AND numLinea = ?";
    private static final String DELETE_QUERY = "DELETE FROM LINEA_DE_TICKET WHERE numCompra = ? AND numLinea = ?";
    private static final String SELECT_BY_NUM_COMPRA_QUERY = "SELECT numCompra, numLinea, codProducto, cantidad FROM LINEA_DE_TICKET WHERE numCompra = ?";
    private static final String SELECT_BY_NUM_COMPRA_Y_NUM_LINEA_QUERY =
            "SELECT numCompra, numLinea, codProducto, cantidad FROM LINEA_DE_TICKET WHERE numCompra = ? AND numLinea = ?";

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
            throw e;
        } finally {
            connection.setAutoCommit(true);  // Restaurar auto-commit
        }
    }

    /**
     * Convierte un objeto ResultSet en una instancia de LineaDeTicket.
     *
     * <p>Primero intenta obtener el producto como un objeto de tipo {@link Propio} desde {@link PropioDAO}.
     * Si no se encuentra, intenta obtenerlo como {@link Ajeno} desde {@link AjenoDAO}.
     * Lanza una excepción si no se encuentra el producto.
     *
     * @param resultSet El ResultSet obtenido de la consulta SQL.
     * @return Una instancia de LineaDeTicket con los datos del ResultSet.
     * @throws SQLException Si ocurre un error al obtener los datos del ResultSet o si el producto no existe.
     */
    private LineaDeTicket resultSetToLineaDeTicket(ResultSet resultSet) throws SQLException {
        int codProducto = resultSet.getInt("codProducto");
        Producto producto = null;

        try {
            Propio p = PropioDAO.getInstance().getPropioByCodigo(codProducto);
            if (p != null) {
                producto = p;
            }
        } catch (SQLException e) {
            // Ignorado intencionalmente
        }

        try {
            Ajeno a = AjenoDAO.getInstance().getAjenoByCodigo(codProducto);
            if (a != null) {
                producto = a;
            }
        } catch (SQLException e) {
            // Ignorado intencionalmente
        }

        if (producto == null) {
            throw new SQLException("No se encontró el producto con código " + codProducto);
        }

        return new LineaDeTicket(
                new Compra(resultSet.getInt("numCompra")),
                producto,
                resultSet.getInt("cantidad"),
                resultSet.getInt("numLinea")
        );
    }

    /**
     * Actualiza los datos de una línea de ticket en la base de datos.
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
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    /**
     * Elimina una línea de ticket de la base de datos mediante los identificadores numCompra y numLinea.
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
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    /**
     * Obtiene todas las líneas de ticket para un número de compra específico.
     *
     * @param numCompra El número de compra que se usará para filtrar las líneas de ticket.
     * @return Una lista de objetos LineaDeTicket representando todas las líneas de ticket para ese número de compra.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    public List<LineaDeTicket> getAllLineasDeTicketByNumCompra(int numCompra) throws SQLException {
        List<LineaDeTicket> lineas = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_NUM_COMPRA_QUERY)) {
            statement.setInt(1, numCompra);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lineas.add(resultSetToLineaDeTicket(resultSet));
            }
        }
        return lineas;
    }

    /**
     * Obtiene una línea de ticket específica basada en el número de compra y el número de línea.
     *
     * @param numCompra El número de compra que se usará para filtrar.
     * @param numLinea El número de línea dentro de la compra.
     * @return Un objeto LineaDeTicket que corresponde al número de compra y número de línea proporcionados,
     *         o {@code null} si no se encuentra.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    public LineaDeTicket getLineaByNumCompraYNumLinea(int numCompra, int numLinea) throws SQLException {
        LineaDeTicket linea = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_NUM_COMPRA_Y_NUM_LINEA_QUERY)) {
            statement.setInt(1, numCompra);
            statement.setInt(2, numLinea);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                linea = resultSetToLineaDeTicket(resultSet);
            }
        }
        return linea;
    }

}
