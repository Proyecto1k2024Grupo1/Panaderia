package DAO;

import Model.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import  java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private static ClienteDAO instance;
    private Connection connection;

    private static final String INSERT_QUERY = "INSERT INTO CLIENTE (direccion, nombre, apellido1, apellido2 ) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM CLIENTE";
    private static final String UPDATE_QUERY = "UPDATE CLIENTE SET direccion = ?, nombre = ?, apellido1 = ?, apellido2 = ? where idCliente = ? ";
    private static final String DELETE_QUERY = "DELETE FROM CLIENTE WHERE idCliente = ?";



    private ClienteDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la única instancia de PersonaDAO.
     * @return instancia única de PersonaDAO.
     */
    public static synchronized ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    public void insertCliente(Cliente cliente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, cliente.getDireccion());
            statement.setString(2, cliente.getNombre());
            statement.setString(3,cliente.getApellido1());
            statement.setString(4, cliente.getApellido2());
        }
    }
    public List<Cliente> getAllClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            clientes.add(resultSetToCliente(resultSet));
        }
    }
        return clientes;
    }
    private Cliente resultSetToCliente(ResultSet resultSet) throws SQLException {
        return new Cliente(
                resultSet.getInt("idCliente"),
                resultSet.getString("direccion"),
                resultSet.getString("nombre"),
                resultSet.getString("apellido1"),
                resultSet.getString("apellido2"));
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
    }
    public void deleteClienteById(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }


}
