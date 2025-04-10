package DAO;

/**
 * Clase DAO para gestionar las operaciones relacionadas con las compras en la base de datos.
 * Proporciona métodos para insertar, actualizar, eliminar y recuperar información de compras.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @date 10/04/2025
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

    private static final String INSERT_QUERY = "INSERT INTO COMPRA (fecha, idCliente) VALUES (CURDATE(), ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM COMPRA";
    private static final String UPDATE_QUERY = "UPDATE COMPRA SET idCliente = ? WHERE numCompra = ?";
    private static final String UPDATE_QUERY_DEPENDIENTE = "UPDATE COMPRA SET dniDependiente = ?, descuentoDependiente = ?, fechaDependiente = CURDATE() WHERE numCompra = ?";
    private static final String UPDATE_QUERY_REPARTIDOR = "UPDATE COMPRA SET dniRepartidor = ?, fechaRepartidor = CURDATE(), horaRepartidor = CURTIME() WHERE numCompra = ?";
    private static final String DELETE_QUERY = "DELETE FROM COMPRA WHERE numCompra = ?";

    private CompraDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Obtiene la instancia singleton de CompraDAO.
     *
     * @return instancia única de CompraDAO
     */
    public static CompraDAO getInstance() {
        if (instance == null) {
            instance = new CompraDAO();
        }
        return instance;
    }

    /**
     * Inserta una nueva compra en la base de datos y devuelve el número de compra generado.
     *
     * @param compra objeto Compra a insertar
     * @return número de compra generado
     * @throws SQLException si ocurre un error durante la operación
     */
    public int insertCompra(Compra compra) throws SQLException {
        int numCompra = -1;
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, compra.getCliente().getIdCliente());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                numCompra = rs.getInt(1);
            }
        }
        return numCompra;
    }

    /**
     * Recupera todas las compras almacenadas en la base de datos.
     *
     * @return lista de objetos Compra
     * @throws SQLException si ocurre un error durante la operación
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
     * Actualiza el cliente asociado a una compra específica.
     *
     * @param numCompra número de la compra a actualizar
     * @param idCliente nuevo ID del cliente
     * @throws SQLException si ocurre un error durante la operación
     */
    public void updateCompraCliente(int numCompra, int idCliente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, idCliente);
            statement.setInt(2, numCompra);
            statement.executeUpdate();
        }
    }

    /**
     * Asigna un dependiente, el descuento aplicado y la fecha al registro de una compra.
     *
     * @param numCompra número de la compra
     * @param dni DNI del dependiente
     * @param descuento descuento aplicado por el dependiente
     * @throws SQLException si ocurre un error durante la operación
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
     * Asigna un repartidor a una compra y registra la fecha y hora de entrega.
     *
     * @param numCompra número de la compra
     * @param dniRepartidor DNI del repartidor
     * @throws SQLException si ocurre un error durante la operación
     */
    public void updateCompraRepartidor(int numCompra, String dniRepartidor) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY_REPARTIDOR)) {
            statement.setString(1, dniRepartidor);
            statement.setInt(2, numCompra);
            statement.executeUpdate();
        }
    }

    /**
     * Elimina una compra de la base de datos utilizando su número de compra.
     *
     * @param numCompra número de la compra a eliminar
     * @throws SQLException si ocurre un error durante la operación
     */
    public void deleteCompraByNum(int numCompra) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, numCompra);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto Compra. Este método también maneja valores nulos en campos opcionales.
     *
     * @param rs ResultSet con los datos de la compra
     * @return objeto Compra construido a partir del ResultSet
     * @throws SQLException si ocurre un error al leer el ResultSet
     */
    private Compra resultSetToCompra(ResultSet rs) throws SQLException {
        Compra compra = new Compra();

        compra.setNumCompra(rs.getInt("numCompra"));

        Date fechaCompra = rs.getDate("fecha");
        if (fechaCompra != null) {
            compra.setFecha(fechaCompra.toLocalDate());
        }

        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getInt("idCliente"));
        compra.setCliente(cliente);

        Dependiente dependiente = new Dependiente();
        dependiente.setDni(rs.getString("dniDependiente"));
        compra.setDependiente(dependiente);

        compra.setDescuentoDependiente(rs.getDouble("descuentoDependiente"));

        Date fechaDep = rs.getDate("fechaDependiente");
        if (fechaDep != null) {
            compra.setFechaDependiente(fechaDep.toLocalDate());
        }

        String dniRepartidor = rs.getString("dniRepartidor");
        if (dniRepartidor != null) {
            Repartidor repartidor = new Repartidor();
            repartidor.setDni(dniRepartidor);
            compra.setRepartidor(repartidor);
        }

        Date fechaRep = rs.getDate("fechaRepartidor");
        if (fechaRep != null) {
            compra.setFechaRepartidor(fechaRep.toLocalDate());
        }

        Time horaRep = rs.getTime("horaRepartidor");
        if (horaRep != null) {
            compra.setHoraRepartidor(horaRep.toLocalTime());
        }

        return compra;
    }
}
