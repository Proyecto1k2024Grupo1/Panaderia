package DAO;

import Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar las operaciones CRUD de las compras en la base de datos.
 * Implementa métodos para insertar, actualizar, eliminar y obtener compras.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @date 10/04/2025
 */
public class CompraDAO {
    private static LineaDeTicketDAO lineaDeTicketDAO = LineaDeTicketDAO.getInstance();
    private static CompraDAO instance;
    private Connection connection;

    private static final String INSERT_QUERY = "INSERT INTO COMPRA (numCompra, fecha, idCliente, dniDependiente) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT numCompra, fecha, idCliente, dniDependiente FROM COMPRA";
    private static final String UPDATE_QUERY = "UPDATE COMPRA SET fecha = ?, idCliente = ?, dniDependiente = ? WHERE numCompra = ?";
    private static final String DELETE_QUERY = "DELETE FROM COMPRA WHERE numCompra = ?";
    private static final String SELECT_BY_NUM_COMPRA = "SELECT numCompra, fecha, idCliente, dniDependiente FROM COMPRA WHERE numCompra = ?";

    private CompraDAO() {
        this.connection = DBConnection.getConnection();
    }

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
     * @throws SQLException Si ocurre un error en la base de datos durante la operación.
     */
    public int insertCompra(Compra compra) throws SQLException {
        // Desactivar autocommit para la transacción
        connection.setAutoCommit(false);

        // Declarar la variable para el numCompra generado
        int numCompraGenerado = -1;

        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, compra.getNumCompra());

            // Manejar fecha nula
            if (compra.getFecha() != null) {
                statement.setDate(2, Date.valueOf(compra.getFecha()));  // Ajuste para el tipo de dato fecha
            } else {
                statement.setNull(2, Types.DATE);  // Establecer como NULL si la fecha es nula
            }

            statement.setInt(3, compra.getCliente().getIdCliente());
            statement.setString(4, compra.getDependiente().getDni());

            // Ejecutar la inserción
            int affectedRows = statement.executeUpdate();

            // Verificar si se generaron claves
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        // Obtener el numCompra generado
                        numCompraGenerado = generatedKeys.getInt(1);
                    }
                }
            }

            // Confirmar la transacción
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();  // Hacer rollback en caso de error
            throw e;
        } finally {
            connection.setAutoCommit(true);  // Restaurar auto-commit
        }

        // Devolver el numCompra generado
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
        return new Compra(fecha != null ? fecha.toLocalDate() : null, numCompra, cliente, dependiente, l);  // Manejar null en la fecha
    }

    /**
     * Obtiene una compra específica mediante su número de compra.
     *
     * @param numCompra El número de compra a buscar.
     * @return La compra correspondiente al número proporcionado.
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

            // Manejar fecha nula
            if (compra.getFecha() != null) {
                statement.setDate(1, Date.valueOf(compra.getFecha()));
            } else {
                statement.setNull(1, Types.DATE);  // Establecer como NULL si la fecha es nula
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
     *
     * @param numCompra El número de compra a eliminar.
     * @throws SQLException Si ocurre un error al ejecutar la consulta de eliminación.
     */
    public void deleteCompra(int numCompra) throws SQLException {
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, numCompra);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
