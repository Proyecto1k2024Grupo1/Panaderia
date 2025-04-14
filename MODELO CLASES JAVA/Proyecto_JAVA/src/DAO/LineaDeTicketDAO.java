package DAO;

import Model.*;

import java.sql.*;
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
    private static final String UPDATE_QUERY = "UPDATE LINEA_DE_TICKET SET codProducto = ?, cantidad = ? WHERE numCompra = ? AND numLinea = ?";
    private static final String DELETE_QUERY = "DELETE FROM LINEA_DE_TICKET WHERE numCompra = ? AND numLinea = ?";
    private static final String SELECT_BY_NUM_COMPRA_QUERY = "SELECT numCompra, numLinea, codProducto, cantidad FROM LINEA_DE_TICKET WHERE numCompra = ?";

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
     * @param resultSet El ResultSet obtenido de la consulta SQL.
     * @return Una instancia de LineaDeTicket con los datos del ResultSet.
     * @throws SQLException Si ocurre un error al obtener los datos del ResultSet.
     */
    private LineaDeTicket resultSetToLineaDeTicket(ResultSet resultSet) throws SQLException {

        // Obtener el código del producto desde el ResultSet
        int codProducto = resultSet.getInt("codProducto");
        Producto producto = null;  // Inicializamos el producto como null

        try {
            // Intentamos obtener el producto como Propio
            Propio p = PropioDAO.getInstance().getPropioByCodigo(codProducto);
            if (p != null) {
                // Si encontramos el producto en la tabla PROPIO, asignamos el objeto
                producto = p;
            }
        } catch (SQLException e) {
            // Si ocurre un error al intentar obtener un producto propio, lo ignoramos (o lo manejamos de otra forma)
        }

        try {
            // Intentamos obtener el producto como Ajeno
            Ajeno a = AjenoDAO.getInstance().getAjenoByCodigo(codProducto);
            if (a != null) {
                // Si encontramos el producto en la tabla AJENO, asignamos el objeto
                producto = a;
            }
        } catch (SQLException e) {
            // Si ocurre un error al intentar obtener un producto ajeno, lo ignoramos (o lo manejamos de otra forma)
        }

        // Si no se encontró ningún producto, lanzar una excepción o manejarlo según sea necesario
        if (producto == null) {
            throw new SQLException("No se encontró el producto con código " + codProducto);
        }

        // Devolver la línea de ticket con el producto adecuado
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
            connection.rollback();  // Hacer rollback en caso de error
            throw e;
        } finally {
            connection.setAutoCommit(true);  // Restaurar auto-commit
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
            connection.rollback();  // Hacer rollback en caso de error
            throw e;
        } finally {
            connection.setAutoCommit(true);  // Restaurar auto-commit
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
            statement.setInt(1, numCompra);  // Establece el valor del parámetro numCompra en la consulta
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lineas.add(resultSetToLineaDeTicket(resultSet));
            }
        }
        return lineas;
    }
}
