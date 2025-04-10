package DAO;

import Model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vanesa, Silvia, Jessica
 */
public class ClienteDAO {

    private static ClienteDAO instance;
    private Connection connection;

    // Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO CLIENTE (direccion, nombre, apellido1, apellido2) VALUES (?, ?, ?, ?)";
    private static final String INSERT_TELEFONO_QUERY = "INSERT INTO TELEFONO (idCliente, numero) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM CLIENTE";
    private static final String UPDATE_QUERY = "UPDATE CLIENTE SET direccion = ?, nombre = ?, apellido1 = ?, apellido2 = ? WHERE idCliente = ?";
    private static final String DELETE_QUERY = "DELETE FROM CLIENTE WHERE idCliente = ?";
    private static final String SELECT_TELEFONOS_CLIENTE = "SELECT numero FROM TELEFONO WHERE idCliente = ?";

    private ClienteDAO() {
        this.connection = DBConnection.getConnection();
    }

    public static synchronized ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    public void insertCliente(Cliente cliente) throws SQLException {
        connection.setAutoCommit(false); // Iniciar transacción

        try (PreparedStatement clienteStmt = connection.prepareStatement(INSERT_QUERY, PreparedStatement.RETURN_GENERATED_KEYS)) {
            clienteStmt.setString(1, cliente.getDireccion());
            clienteStmt.setString(2, cliente.getNombre());
            clienteStmt.setString(3, cliente.getApellido1());
            clienteStmt.setString(4, cliente.getApellido2());
            clienteStmt.executeUpdate();

            ResultSet rs = clienteStmt.getGeneratedKeys();
            if (rs.next()) {
                int idCliente = rs.getInt(1);

                try (PreparedStatement telefonoStmt = connection.prepareStatement(INSERT_TELEFONO_QUERY)) {
                    for (String telefono : cliente.getTelefonos()) {
                        telefonoStmt.setInt(1, idCliente);
                        telefonoStmt.setString(2, telefono);
                        telefonoStmt.addBatch();
                    }
                    telefonoStmt.executeBatch();
                }
            }

            connection.commit();
        } catch (SQLException e) {
            connection.rollback(); // Deshacer si algo falla
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public List<Cliente> getAllClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = resultSetToCliente(resultSet);
                cliente.setTelefonos(getTelefonosCliente(cliente.getIdCliente()));
                clientes.add(cliente);
            }
        }
        return clientes;
    }

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

    private Cliente resultSetToCliente(ResultSet resultSet) throws SQLException {
        return new Cliente(
                resultSet.getInt("idCliente"),
                resultSet.getString("direccion"),
                resultSet.getString("nombre"),
                resultSet.getString("apellido1"),
                resultSet.getString("apellido2")
        );
    }

    public void updateCliente(Cliente cliente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, cliente.getDireccion());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getApellido1());
            statement.setString(4, cliente.getApellido2());
            statement.setInt(5, cliente.getIdCliente());
            statement.executeUpdate();
        }
        // Puedes agregar aquí la actualización de teléfonos si lo necesitas
    }

    public void deleteClienteById(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        // También podrías eliminar los teléfonos del cliente si lo ves necesario
    }
}
