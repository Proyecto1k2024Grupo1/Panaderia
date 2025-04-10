package DAO;

/**
 * @author Vanesa, Silvia, Jessica
 */

import Model.Cliente;
import Model.Compra;
import Model.Dependiente;
import Model.Repartidor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {
    private static CompraDAO instance;
    private Connection connection;

    //Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO COMPRA (fecha, idCliente) VALUES (CURDATE(), ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM COMPRA";
    private static final String UPDATE_QUERY = "UPDATE COMPRA SET idCliente = ? WHERE numCompra = ?";
    private static final String UPDATE_QUERY_DEPENDIENTE = "UPDATE COMPRA SET dniDependiente = ?, descuentoDependiente = ?, fechaDependiente = CURDATE() WHERE numCompra = ?";
    private static final String UPDATE_QUERY_REPARTIDOR = "UPDATE COMPRA SET dniRepartidor = ?, fechaRepartidor = CURDATE(), horaRepartidor = CURTIME() WHERE numCompra = ?";
    private static final String DELETE_QUERY = "DELETE FROM COMPRA WHERE numCompra = ?";

    /**
     * Constructor privado para evitar la creación de instancias externas.
     * Obtiene la conexión a la base de datos.
     */
    private CompraDAO() {
        this.connection = DBConnection.getConnection();
    }


    public static CompraDAO getInstance() {
        if (instance == null) {
            instance = new CompraDAO();
        }
        return instance;
    }

    /**
     * Inserta una nueva compra en la base de datos.
     */
    public void insertCompra(Compra compra) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, compra.getCliente().getIdCliente());
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene todas las compras de la base de datos.
     */
    public List<Compra> getAllCompra() throws SQLException {
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
     * Actualiza el cliente de una compra.
     */
    public void updateCompraCliente(int numCompra, int idCliente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, idCliente);
            statement.setInt(2, numCompra);
            statement.executeUpdate();
        }
    }

    /**
     * Asigna datos del dependiente a una compra.
     */
    public void updateCompraDependiente(int numCompra, String dni, double descuento) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY_DEPENDIENTE)) {
            statement.setString(1, dni);
            statement.setDouble(2, descuento);
            statement.setInt(3, numCompra);
            statement.executeUpdate();
        }
    }

    /**
     * Asigna datos del repartidor a una compra.
     */
    public void updateCompraRepartidor(int numCompra, String dniRepartidor) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY_REPARTIDOR)) {
            statement.setString(1, dniRepartidor);
            statement.setInt(2, numCompra);
            statement.executeUpdate();
        }
    }

    /**
     * Elimina una compra por su número.
     */
    public void deleteCompraByNum(int numCompra) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, numCompra);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto Compra.
     * (Este método debería ampliarse según los atributos de Compra).
     */
    private Compra resultSetToCompra(ResultSet rs) throws SQLException {
        Compra compra = new Compra();

        compra.setNumCompra(rs.getInt("numCompra"));
        compra.setFecha(rs.getDate("fecha").toLocalDate());

        // Cliente con solo id
        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getInt("idCliente"));
        compra.setCliente(cliente);

        // Dependiente con solo dni
        Dependiente dependiente = new Dependiente();
        dependiente.setDni(rs.getString("dniDependiente"));
        compra.setDependiente(dependiente);

        compra.setDescuentoDependiente(rs.getDouble("descuentoDependiente"));
        compra.setFechaDependiente(rs.getDate("fechaDependiente").toLocalDate());

        // Repartidor (puede ser null)
        String dniRepartidor = rs.getString("dniRepartidor");
        if (dniRepartidor != null) {
            Repartidor repartidor = new Repartidor();
            repartidor.setDni(dniRepartidor);
            compra.setRepartidor(repartidor);
        }

        compra.setFechaRepartidor(rs.getDate("fechaRepartidor").toLocalDate());
        compra.setHoraRepartidor(rs.getTime("horaRepartidor").toLocalTime());

        return compra;
    }

}
