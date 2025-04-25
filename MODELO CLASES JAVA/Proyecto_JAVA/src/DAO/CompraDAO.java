package DAO;

import Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar las operaciones CRUD de las compras en la base de datos.
 * Implementa métodos para insertar, actualizar, eliminar y obtener compras.
 * Utiliza conexiones a través de la clase DBConnection y se apoya en otras DAOs para obtener entidades relacionadas.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @since 10/04/2025
 */
public class CompraDAO {

    /**
     * Instancia de LineaDeTicketDAO usada para acceder a las líneas de ticket relacionadas.
     */
    private static LineaDeTicketDAO lineaDeTicketDAO = LineaDeTicketDAO.getInstance();

    /**
     * Instancia única de CompraDAO (patrón Singleton).
     */
    private static CompraDAO instance;

    /**
     * Conexión a la base de datos.
     */
    private Connection connection;

    /**
     * Consulta SQL para insertar una compra.
     */
    private static final String INSERT_QUERY = "INSERT INTO COMPRA (numCompra, fecha, idCliente, dniDependiente) VALUES (?, ?, ?, ?)";

    /**
     * Consulta SQL para obtener todas las compras.
     */
    private static final String SELECT_ALL_QUERY = "SELECT numCompra, fecha, idCliente, dniDependiente FROM COMPRA";

    /**
     * Consulta SQL para actualizar una compra.
     */
    private static final String UPDATE_QUERY = "UPDATE COMPRA SET fecha = ?, idCliente = ?, dniDependiente = ? WHERE numCompra = ?";

    /**
     * Consulta SQL para eliminar una compra.
     */
    private static final String DELETE_QUERY = "DELETE FROM COMPRA WHERE numCompra = ?";

    /**
     * Consulta SQL para obtener una compra por su número.
     */
    private static final String SELECT_BY_NUM_COMPRA = "SELECT numCompra, fecha, idCliente, dniDependiente FROM COMPRA WHERE numCompra = ?";

    /**
     * Constructor privado del patrón Singleton.
     * Inicializa la conexión a la base de datos.
     */
    private CompraDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Devuelve la instancia única de CompraDAO.
     *
     * @return Instancia de CompraDAO.
     */
    public static synchronized CompraDAO getInstance() {
        if (instance == null) {
            instance = new CompraDAO();
        }
        return instance;
    }

    /**
     * Inserta una nueva compra en la base de datos.
     *
     * @param compra La compra que se desea insertar.
     * @return El número de compra generado si la operación fue exitosa.
     * @throws SQLException Si ocurre un error en la base de datos durante la operación.
     */
    public int insertCompra(Compra compra) throws SQLException {
        connection.setAutoCommit(false);
        int numCompraGenerado = -1;

        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, compra.getNumCompra());

            if (compra.getFecha() != null) {
                statement.setDate(2, Date.valueOf(compra.getFecha()));
            } else {
                statement.setNull(2, Types.DATE);
            }

            statement.setInt(3, compra.getCliente().getIdCliente());
            statement.setString(4, compra.getDependiente().getDni());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        numCompraGenerado = generatedKeys.getInt(1);
                    }
                }
            }

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }

        return numCompraGenerado;
    }

    /**
     * Obtiene todas las compras almacenadas en la base de datos.
     *
     * @return Una lista de objetos Compra.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    public List<Compra> getAllCompras() throws SQLException {
        List<Compra> compras = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                compras.add(resultSetToCompra(resultSet));
            }
        }
        return compras;
    }

    /**
     * Convierte un ResultSet a un objeto Compra.
     *
     * @param resultSet El ResultSet que contiene los datos de la compra.
     * @return Un objeto Compra con los datos del ResultSet.
     * @throws SQLException Si ocurre un error al procesar el ResultSet.
     */
    private Compra resultSetToCompra(ResultSet resultSet) throws SQLException {
        Cliente cliente = ClienteDAO.getInstance().getClienteById(resultSet.getInt("idCliente"));
        Dependiente dependiente = DependienteDAO.getInstance().getDependienteByDni(resultSet.getString("dniDependiente"));
        int numCompra = resultSet.getInt("numCompra");
        Date fecha = resultSet.getDate("fecha");

        List<LineaDeTicket> l = LineaDeTicketDAO.getInstance().getAllLineasDeTicketByNumCompra(numCompra);
        return new Compra(fecha != null ? fecha.toLocalDate() : null, numCompra, cliente, dependiente, l);
    }

    /**
     * Obtiene una compra específica mediante su número de compra.
     *
     * @param numCompra El número de compra a buscar.
     * @return La compra correspondiente al número proporcionado, o null si no existe.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public Compra getCompraByNumCompra(int numCompra) throws SQLException {
        Compra compra = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_NUM_COMPRA)) {
            statement.setInt(1, numCompra);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                compra = resultSetToCompra(resultSet);
            }
        }
        return compra;
    }

    /**
     * Actualiza una compra existente en la base de datos.
     *
     * @param compra La compra con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos durante la operación.
     */
    public void updateCompra(Compra compra) throws SQLException {
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            if (compra.getFecha() != null) {
                statement.setDate(1, Date.valueOf(compra.getFecha()));
            } else {
                statement.setNull(1, Types.DATE);
            }

            statement.setInt(2, compra.getCliente().getIdCliente());
            statement.setString(3, compra.getDependiente().getDni());
            statement.setInt(4, compra.getNumCompra());

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
     * Elimina una compra de la base de datos por su número de compra.
     * Primero elimina las líneas de ticket asociadas a la compra para mantener la integridad referencial.
     *
     * @param numCompra El número de compra a eliminar.
     * @throws SQLException Si ocurre un error al ejecutar la consulta de eliminación.
     */
    public void deleteCompra(int numCompra) throws SQLException {
        connection.setAutoCommit(false);
        try {
            // Primero eliminamos las líneas de ticket asociadas
            lineaDeTicketDAO.deleteAllLineasDeCompra(numCompra);

            // Luego eliminamos la compra
            try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
                statement.setInt(1, numCompra);
                statement.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

}
