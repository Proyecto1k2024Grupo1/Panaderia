package DAO;

import Model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO (Data Access Object) que permite interactuar con la tabla CLIENTE y TELEFONO en la base de datos.
 * Proporciona métodos para insertar, actualizar, eliminar y recuperar clientes.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @date 10/04/2025
 */
public class ClienteDAO {

    // Instancia singleton de ClienteDAO
    private static ClienteDAO instance;

    // Conexión a la base de datos
    private Connection connection;

    // Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO CLIENTE (direccion, nombre, apellido1, apellido2) VALUES (?, ?, ?, ?)";
    private static final String INSERT_TELEFONO_QUERY = "INSERT INTO TELEFONO (idCliente, numero) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM CLIENTE";
    private static final String UPDATE_QUERY = "UPDATE CLIENTE SET direccion = ?, nombre = ?, apellido1 = ?, apellido2 = ? WHERE idCliente = ?";
    private static final String DELETE_QUERY = "DELETE FROM CLIENTE WHERE idCliente = ?";
    private static final String SELECT_TELEFONOS_CLIENTE = "SELECT numero FROM TELEFONO WHERE idCliente = ?";

    /**
     * Constructor privado para aplicar el patrón Singleton.
     */
    private ClienteDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Devuelve la única instancia de ClienteDAO, creándola si aún no existe.
     *
     * @return instancia de ClienteDAO
     */
    public static synchronized ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    /**
     * Inserta un cliente y sus teléfonos en la base de datos.
     * Utiliza transacciones para asegurar que ambos insert se realicen correctamente.
     *
     * @param cliente objeto Cliente a insertar
     * @throws SQLException si ocurre un error en la base de datos
     */
    public void insertCliente(Cliente cliente) throws SQLException {
        connection.setAutoCommit(false); // Iniciar transacción manual

        try (PreparedStatement clienteStmt = connection.prepareStatement(INSERT_QUERY, PreparedStatement.RETURN_GENERATED_KEYS)) {
            // Establecer los datos del cliente en la consulta
            clienteStmt.setString(1, cliente.getDireccion());
            clienteStmt.setString(2, cliente.getNombre());
            clienteStmt.setString(3, cliente.getApellido1());
            clienteStmt.setString(4, cliente.getApellido2());

            clienteStmt.executeUpdate(); // Ejecutar inserción del cliente

            // Obtener ID autogenerado del cliente
            ResultSet rs = clienteStmt.getGeneratedKeys();
            if (rs.next()) {
                int idCliente = rs.getInt(1);

                // Insertar los teléfonos relacionados con el cliente
                try (PreparedStatement telefonoStmt = connection.prepareStatement(INSERT_TELEFONO_QUERY)) {
                    for (String telefono : cliente.getTelefonos()) {
                        telefonoStmt.setInt(1, idCliente);
                        telefonoStmt.setString(2, telefono);
                        telefonoStmt.addBatch(); // Añadir a lote
                    }
                    telefonoStmt.executeBatch(); // Ejecutar lote de inserciones
                }
            }

            connection.commit(); // Confirmar transacción
        } catch (SQLException e) {
            connection.rollback(); // Revertir cambios si falla
            throw e;
        } finally {
            connection.setAutoCommit(true); // Volver a modo automático
        }
    }

    /**
     * Recupera todos los clientes de la base de datos junto con sus números de teléfono.
     *
     * @return lista de clientes
     * @throws SQLException si ocurre un error de conexión
     */
    public List<Cliente> getAllClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Convertir fila de resultado a objeto Cliente
                Cliente cliente = resultSetToCliente(resultSet);
                // Añadir teléfonos a ese cliente
                cliente.setTelefonos(getTelefonosCliente(cliente.getIdCliente()));
                clientes.add(cliente); // Añadir cliente a la lista
            }
        }

        return clientes;
    }

    /**
     * Recupera la lista de teléfonos asociados a un cliente.
     *
     * @param idCliente ID del cliente
     * @return lista de teléfonos
     * @throws SQLException si ocurre un error de conexión
     */
    private List<String> getTelefonosCliente(int idCliente) throws SQLException {
        List<String> telefonos = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(SELECT_TELEFONOS_CLIENTE)) {
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                telefonos.add(rs.getString("numero"));
            }
        }

        return telefonos;
    }

    /**
     * Convierte un ResultSet en un objeto Cliente.
     *
     * @param resultSet fila de la base de datos
     * @return cliente con los datos correspondientes
     * @throws SQLException si hay error al leer datos
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
     * Este método no actualiza los teléfonos, pero puede ampliarse para ello.
     *
     * @param cliente cliente con datos actualizados
     * @throws SQLException si ocurre error en la actualización
     */
    public void updateCliente(Cliente cliente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, cliente.getDireccion());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getApellido1());
            statement.setString(4, cliente.getApellido2());
            statement.setInt(5, cliente.getIdCliente());

            statement.executeUpdate(); // Ejecutar actualización
        }

        // Si se desea actualizar los teléfonos, se puede hacer aquí
    }

    /**
     * Elimina un cliente por su ID de la base de datos.
     * No borra los teléfonos asociados, pero podría añadirse.
     *
     * @param id ID del cliente a eliminar
     * @throws SQLException si ocurre error en la eliminación
     */
    public void deleteClienteById(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }

        // También puedes eliminar los teléfonos asociados aquí si es necesario
    }
}
