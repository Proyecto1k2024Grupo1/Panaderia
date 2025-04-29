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
    private static final String UPDATE_QUERY = "UPDATE LINEA_DE_TICKET SET cantidad = ? WHERE numCompra = ? AND numLinea = ?";
    private static final String DELETE_QUERY = "DELETE FROM LINEA_DE_TICKET WHERE numCompra = ? AND numLinea = ?";
    private static final String DELETE_QUERY_ALL = "DELETE FROM LINEA_DE_TICKET WHERE numCompra = ?";
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

    private LineaDeTicket resultSetToLineaDeTicket(ResultSet resultSet) throws SQLException {
        int codProducto = resultSet.getInt("codProducto");
        Producto producto = null;

        // Intentamos obtener el producto como Propio
        Propio p = PropioDAO.getInstance().getPropioByCodigo(codProducto);
        if (p != null) {
            producto = p;
        }

        // Si no se encuentra como Propio, intentamos obtenerlo como Ajeno
        if (producto == null) {
            Ajeno a = AjenoDAO.getInstance().getAjenoByCodigo(codProducto);
            if (a != null) {
                producto = a;
            }
        }

        // Si el producto sigue siendo null, lanzamos una excepción
        if (producto == null) {
            throw new SQLException("No se encontró el producto con código " + codProducto);
        }

        // Crear y devolver el objeto LineaDeTicket


        int numCompra = resultSet.getInt("numCompra");

        LineaDeTicket a = new LineaDeTicket(
                new Compra(numCompra),
                producto,
                resultSet.getInt("cantidad"),
                resultSet.getInt("numLinea")
        );
        return a;
    }


    public void updateLineaDeTicket(LineaDeTicket linea) throws SQLException {
        // Desactivar autocommit para manejar la transacción manualmente
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            // Establecer los parámetros de la consulta con los nuevos valores
            statement.setInt(1, linea.getCantidad());  // Actualizar la cantidad
            statement.setInt(2, linea.getNumCompra()); // Identificar la compra
            statement.setInt(3, linea.getNumLinea());  // Identificar la línea del ticket

            // Verificar el valor de la cantidad antes de ejecutar la actualización
            System.out.println("Actualizando línea: numCompra = " + linea.getNumCompra() + ", numLinea = " + linea.getNumLinea());
            System.out.println("Nueva cantidad: " + linea.getCantidad());

            // Obtener la línea antes de la actualización para ver qué cantidad tiene
            LineaDeTicket lineaRecuperada = getLineaByNumCompraYNumLinea(linea.getNumCompra(), linea.getNumLinea());
            if (lineaRecuperada != null) {
                System.out.println("Línea antes de actualizar:");
                System.out.println("Cantidad recuperada: " + lineaRecuperada.getCantidad());
            } else {
                System.out.println("No se encontró la línea antes de actualizar.");
            }

            // Ejecutar la actualización
            int rowsAffected = statement.executeUpdate();
            System.out.println("Filas afectadas: " + rowsAffected);

            // Comprobar si realmente se actualizó alguna fila
            if (rowsAffected > 0) {
                System.out.println("Actualización exitosa: " + rowsAffected + " filas afectadas.");
            } else {
                System.out.println("No se actualizó ninguna fila. Verifica si los datos coinciden.");
            }

            // Confirmar la transacción si la actualización fue exitosa
            connection.commit();
        } catch (SQLException e) {
            // En caso de error, revertir la transacción
            connection.rollback();
            System.out.println("Error al actualizar la línea de ticket: " + e.getMessage());
            throw e; // Re-throw para que el error sea manejado más arriba
        } finally {
            // Restaurar el autocommit a true para las próximas operaciones
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

    public LineaDeTicket getLineaByNumCompraYNumLinea(int numCompra, int numLinea) throws SQLException {
        LineaDeTicket linea = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_NUM_COMPRA_Y_NUM_LINEA_QUERY)) {
            statement.setInt(1, numCompra);
            statement.setInt(2, numLinea);

            // Imprimir los parámetros que se están pasando a la consulta
            System.out.println("Ejecutando consulta con numCompra = " + numCompra + " y numLinea = " + numLinea);

            ResultSet resultSet = statement.executeQuery();

            // Imprimir el contenido del ResultSet

            if (resultSet.next()) {
                linea = resultSetToLineaDeTicket(resultSet);
            } else {
                System.out.println("No se encontró ninguna línea para los parámetros dados.");
            }
        }
        return linea;
    }

    /**
     * Elimina todas las líneas de ticket asociadas a una compra específica.
     *
     * @param numCompra El número de compra del que se eliminarán todas las líneas.
     * @throws SQLException Si ocurre un error en la base de datos durante la operación.
     */
    public void deleteAllLineasDeCompra(int numCompra) throws SQLException {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY_ALL)) {
            statement.setInt(1, numCompra);

            int filasAfectadas = statement.executeUpdate();
            System.out.println("Se eliminaron " + filasAfectadas + " líneas de la compra #" + numCompra);

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();  // Hacer rollback en caso de error
            throw e;
        } finally {
            connection.setAutoCommit(true);  // Restaurar auto-commit
        }
    }




}
