package DAO;

import Model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO (Data Access Object) que permite interactuar con la tabla CLIENTE y TELEFONO en la base de datos.
 * Proporciona métodos para insertar, actualizar, eliminar y recuperar clientes.
 * La clase gestiona las operaciones relacionadas con los clientes y sus números de teléfono en la base de datos.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @date 10/04/2025
 */
public class ClienteDAO {

    private static ClienteDAO instance;
    private Connection connection;

    // Queries definidas como constantes finales
    private static final String INSERT_QUERY = "INSERT INTO CLIENTE (direccion, nombre, apellido1, apellido2) VALUES (?, ?, ?, ?)";
    private static final String INSERT_TELEFONO_QUERY = "INSERT INTO TELEFONO (idCliente, numTelefono) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM CLIENTE";
    private static final String SELECT_CLIENTE_BY_ID_QUERY = "SELECT * FROM CLIENTE WHERE idCliente = ?"; // Query para obtener cliente por ID
    private static final String UPDATE_QUERY = "UPDATE CLIENTE SET direccion = ?, nombre = ?, apellido1 = ?, apellido2 = ? WHERE idCliente = ?";
    private static final String DELETE_QUERY = "DELETE FROM CLIENTE WHERE idCliente = ?";
    private static final String DELETE_TELEFONOS_QUERY = "DELETE FROM TELEFONO WHERE idCliente = ?";
    private static final String SELECT_TELEFONOS_CLIENTE = "SELECT numTelefono FROM TELEFONO WHERE idCliente = ?";

    /**
     * Constructor privado para inicializar la conexión a la base de datos.
     * Solo se puede acceder a través del método getInstance().
     */
    private ClienteDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Obtiene la única instancia del ClienteDAO (Patrón Singleton).
     * Este patrón asegura que solo haya una instancia de ClienteDAO en la aplicación.
     *
     * @return La instancia de ClienteDAO.
     */
    public static synchronized ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    /**
     * Inserta un cliente y sus teléfonos en la base de datos.
     * Primero se inserta el cliente y luego los teléfonos asociados a ese cliente.
     * Utiliza transacciones para garantizar la consistencia de los datos.
     *
     * @param cliente El objeto cliente que se desea insertar.
     * @throws SQLException Si ocurre un error al insertar el cliente o los teléfonos.
     */
    public void insertCliente(Cliente cliente) throws SQLException {
        connection.setAutoCommit(false); // Iniciar transacción manual

        try (PreparedStatement clienteStmt = connection.prepareStatement(INSERT_QUERY, PreparedStatement.RETURN_GENERATED_KEYS)) {
            // Establecer los datos del cliente
            clienteStmt.setString(1, cliente.getDireccion());
            clienteStmt.setString(2, cliente.getNombre());
            clienteStmt.setString(3, cliente.getApellido1());
            clienteStmt.setString(4, cliente.getApellido2());

            clienteStmt.executeUpdate();

            // Obtener ID del cliente
            ResultSet rs = clienteStmt.getGeneratedKeys();
            if (rs.next()) {
                int idCliente = rs.getInt(1);
                // Insertar los teléfonos asociados
                insertTelefonos(idCliente, cliente.getTelefonos());
            }

            connection.commit(); // Confirmar transacción
        } catch (SQLException e) {
            connection.rollback(); // Revertir si falla
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    /**
     * Inserta los teléfonos asociados a un cliente en la base de datos.
     * Utiliza un batch para insertar todos los teléfonos de forma eficiente.
     *
     * @param idCliente El ID del cliente.
     * @param telefonos Lista de números de teléfono a asociar al cliente.
     * @throws SQLException Si ocurre un error al insertar los teléfonos.
     */
    private void insertTelefonos(int idCliente, List<String> telefonos) throws SQLException {
        try (PreparedStatement telefonoStmt = connection.prepareStatement(INSERT_TELEFONO_QUERY)) {
            for (String telefono : telefonos) {
                telefonoStmt.setInt(1, idCliente);
                telefonoStmt.setString(2, telefono);
                telefonoStmt.addBatch(); // Añadir a lote
            }
            telefonoStmt.executeBatch(); // Ejecutar el lote
        }
    }

    /**
     * Recupera todos los clientes, incluyendo sus teléfonos asociados.
     * Utiliza una consulta SQL para obtener todos los clientes y luego recupera sus teléfonos.
     *
     * @return Una lista de objetos Cliente, cada uno con sus teléfonos asociados.
     * @throws SQLException Si ocurre un error al recuperar los clientes o los teléfonos.
     */
    public List<Cliente> getAllClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = resultSetToCliente(resultSet);
                cliente.setTelefonos(getTelefonosCliente(cliente.getIdCliente())); // Obtener teléfonos
                clientes.add(cliente);
            }
        }

        return clientes;
    }

    /**
     * Recupera un cliente por su ID, incluyendo sus teléfonos asociados.
     * Utiliza una consulta SQL para obtener el cliente por ID y luego recupera sus teléfonos.
     *
     * @param idCliente El ID del cliente a recuperar.
     * @return El objeto Cliente con sus teléfonos asociados, o null si no se encuentra.
     * @throws SQLException Si ocurre un error al recuperar el cliente o sus teléfonos.
     */
    public Cliente getClienteById(int idCliente) throws SQLException {
        Cliente cliente = null;

        try (PreparedStatement stmt = connection.prepareStatement(SELECT_CLIENTE_BY_ID_QUERY)) {
            stmt.setInt(1, idCliente);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                // Convertir el ResultSet a objeto Cliente
                cliente = resultSetToCliente(resultSet);
                // Obtener los teléfonos asociados al cliente
                cliente.setTelefonos(getTelefonosCliente(idCliente));
            }
        }

        return cliente; // Retorna el cliente si lo encuentra, o null si no
    }

    /**
     * Recupera los teléfonos asociados a un cliente.
     * Utiliza una consulta SQL para obtener todos los teléfonos del cliente.
     *
     * @param idCliente El ID del cliente cuyos teléfonos se desean recuperar.
     * @return Una lista de números de teléfono asociados al cliente.
     * @throws SQLException Si ocurre un error al recuperar los teléfonos.
     */
    private List<String> getTelefonosCliente(int idCliente) throws SQLException {
        List<String> telefonos = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(SELECT_TELEFONOS_CLIENTE)) {
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                telefonos.add(rs.getString("numTelefono"));
            }
        }

        return telefonos;
    }

    /**
     * Convierte un ResultSet en un objeto Cliente.
     * Este método mapea los valores del ResultSet a un objeto Cliente.
     *
     * @param resultSet El ResultSet que contiene los datos del cliente.
     * @return El objeto Cliente correspondiente.
     * @throws SQLException Si ocurre un error al convertir el ResultSet.
     */
    private Cliente resultSetToCliente(ResultSet resultSet) throws SQLException {
        return new Cliente(
                resultSet.getInt("idCliente"),
                resultSet.getString("direccion"),
                resultSet.getString("nombre"),
                resultSet.getString("apellido1"),
                resultSet.getString("apellido2")
        );
    }

    /**
     * Actualiza los datos de un cliente en la base de datos.
     * Primero actualiza los datos básicos del cliente y luego actualiza sus teléfonos.
     *
     * @param cliente El objeto cliente con los datos actualizados.
     * @throws SQLException Si ocurre un error al actualizar el cliente o los teléfonos.
     */
    public void updateCliente(Cliente cliente) throws SQLException {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, cliente.getDireccion());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getApellido1());
            statement.setString(4, cliente.getApellido2());
            statement.setInt(5, cliente.getIdCliente());

            statement.executeUpdate();

            // Eliminar teléfonos existentes
            deleteTelefonos(cliente.getIdCliente());

            // Insertar los nuevos teléfonos
            insertTelefonos(cliente.getIdCliente(), cliente.getTelefonos());

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    /**
     * Elimina los teléfonos asociados a un cliente de la base de datos.
     *
     * @param idCliente El ID del cliente cuyos teléfonos se deben eliminar.
     * @throws SQLException Si ocurre un error al eliminar los teléfonos.
     */
    private void deleteTelefonos(int idCliente) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(DELETE_TELEFONOS_QUERY)) {
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
        }
    }

    /**
     * Elimina un cliente y sus teléfonos asociados de la base de datos.
     * Primero elimina los teléfonos asociados al cliente y luego elimina el cliente.
     *
     * @param id El ID del cliente a eliminar.
     * @throws SQLException Si ocurre un error al eliminar el cliente o sus teléfonos.
     */
    public void deleteClienteById(int id) throws SQLException {
        connection.setAutoCommit(false);

        try {
            deleteTelefonos(id); // Eliminar teléfonos

            try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }

            connection.commit(); // Confirmar transacción
        } catch (SQLException e) {
            connection.rollback(); // Revertir si ocurre un error
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
