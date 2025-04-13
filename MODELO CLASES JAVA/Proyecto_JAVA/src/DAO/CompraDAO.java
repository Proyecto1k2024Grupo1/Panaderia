package DAO;

import Model.Cliente;
import Model.Compra;
import Model.Dependiente;
import Model.Repartidor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase CompraDAO que maneja las operaciones de acceso a datos (DAO) para la entidad Compra.
 * Implementa el patrón Singleton para garantizar que solo haya una instancia de la clase.
 * @version 1.0
 * @date 10/04/2025
 */
public class CompraDAO {
    // Consultas SQL para insertar, seleccionar, actualizar y eliminar compras
    private static final String INSERT_QUERY = "INSERT INTO COMPRA (fecha, idCliente) VALUES (CURDATE(), ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM COMPRA";
    private static final String UPDATE_QUERY = "UPDATE COMPRA SET idCliente = ? WHERE numCompra = ?";
    private static final String UPDATE_QUERY_DEPENDIENTE = "UPDATE COMPRA SET dniDependiente = ?, descuentoDependiente = ?, fechaDependiente = CURDATE() WHERE numCompra = ?";
    private static final String UPDATE_QUERY_REPARTIDOR = "UPDATE COMPRA SET dniRepartidor = ?, fechaRepartidor = CURDATE(), horaRepartidor = CURTIME() WHERE numCompra = ?";
    private static final String DELETE_QUERY = "DELETE FROM COMPRA WHERE numCompra = ?";
    private static final String SELECT_BY_NUM_COMPRA_QUERY = "SELECT * FROM COMPRA WHERE numCompra = ?";


    // Instancia única de CompraDAO (patrón Singleton)
    private static CompraDAO instance;
    private Connection connection;

    /**
     * Constructor privado para evitar la creación directa de instancias.
     * Obtiene la conexión a la base de datos a través de DBConnection.
     */
    public CompraDAO() {
        this.connection = DBConnection.getConnection(); // Obtiene la conexión a la base de datos
    }

    /**
     * Devuelve la instancia única de CompraDAO.
     * Si aún no se ha creado, se inicializa la instancia.
     *
     * @return La instancia única de CompraDAO.
     */
    public static CompraDAO getInstance() {
        if (instance == null) {
            instance = new CompraDAO(); // Si no existe, se crea una nueva instancia
        }
        return instance; // Devuelve la instancia única
    }

    /**
     * Inserta una nueva compra en la base de datos.
     *
     * @param compra Objeto Compra que contiene la información de la compra a insertar.
     * @return
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    public int insertCompra(Compra compra) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, compra.getCliente().getIdCliente()); // Asocia la compra con el cliente correspondiente
            statement.executeUpdate(); // Ejecuta la inserción
            ResultSet resultSet =  statement.getGeneratedKeys();
            return resultSet.getInt(1);
        }
    }

    /**
     * Obtiene todas las compras registradas en la base de datos.
     *
     * @return Una lista de objetos Compra que representan todas las compras en la base de datos.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    public List<Compra> getAllCompra() throws SQLException {
        List<Compra> compras = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery(); // Ejecuta la consulta para obtener todas las compras
            while (resultSet.next()) {
                compras.add(resultSetToCompra(resultSet)); // Convierte cada fila del ResultSet en un objeto Compra
            }
        }
        return compras; // Devuelve la lista de todas las compras
    }

    /**
     * Actualiza el cliente asociado a una compra en la base de datos.
     *
     * @param numCompra El número de la compra a actualizar.
     * @param idCliente El nuevo id del cliente a asociar con la compra.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    public void updateCompraCliente(int numCompra, int idCliente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, idCliente); // Establece el nuevo idCliente
            statement.setInt(2, numCompra); // Establece el número de compra que se quiere actualizar
            statement.executeUpdate(); // Ejecuta la actualización
        }
    }

    /**
     * Actualiza los datos del dependiente de una compra (dni y descuento).
     *
     * @param numCompra El número de la compra a actualizar.
     * @param dni El dni del dependiente.
     * @param descuento El descuento aplicado por el dependiente.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    public void updateCompraDependiente(int numCompra, String dni, double descuento) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY_DEPENDIENTE)) {
            statement.setString(1, dni); // Establece el dni del dependiente
            statement.setDouble(2, descuento); // Establece el descuento aplicado por el dependiente
            statement.setInt(3, numCompra); // Establece el número de compra que se quiere actualizar
            statement.executeUpdate(); // Ejecuta la actualización
        }
    }

    /**
     * Actualiza los datos del repartidor de una compra (dni y hora).
     *
     * @param numCompra El número de la compra a actualizar.
     * @param dniRepartidor El dni del repartidor.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    public void updateCompraRepartidor(int numCompra, String dniRepartidor) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY_REPARTIDOR)) {
            statement.setString(1, dniRepartidor); // Establece el dni del repartidor
            statement.setInt(2, numCompra); // Establece el número de compra que se quiere actualizar
            statement.executeUpdate(); // Ejecuta la actualización
        }
    }

    /**
     * Elimina una compra de la base de datos.
     *
     * @param numCompra El número de la compra a eliminar.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    public void deleteCompraByNum(int numCompra) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, numCompra); // Establece el número de compra a eliminar
            statement.executeUpdate(); // Ejecuta la eliminación
        }
    }

    /**
     * Convierte un ResultSet en un objeto Compra.
     * Este método se utiliza para convertir los resultados de una consulta SELECT en objetos Java.
     *
     * @param rs El ResultSet con los datos obtenidos de la consulta SQL.
     * @return Un objeto Compra con los datos extraídos del ResultSet.
     * @throws SQLException Si ocurre un error al extraer los datos del ResultSet.
     */
    private Compra resultSetToCompra(ResultSet rs) throws SQLException {
        Compra compra = new Compra(); // Crea una nueva instancia de Compra
        compra.setNumCompra(rs.getInt("numCompra")); // Establece el número de compra
        compra.setFecha(rs.getDate("fecha").toLocalDate()); // Establece la fecha de la compra
        compra.setCliente(ClienteDAO.getInstance().getClienteById(rs.getInt("idCliente")));
        compra.setDependiente(DependienteDAO.getInstance().getDependienteByDni("dniDependiente"));
        compra.setDescuentoDependiente(rs.getDouble("descuentoDependiente")); // Establece el descuento del dependiente
        compra.setFechaDependiente(rs.getDate("fechaDependiente").toLocalDate()); // Establece la fecha del dependiente
        compra.setRepartidor(RepartidorDAO.getInstance().getRepartidorByDni("dniRepartidor"));
        compra.setFechaRepartidor(rs.getDate("fechaRepartidor").toLocalDate()); // Establece la fecha del repartidor
        compra.setHoraRepartidor(rs.getTime("horaRepartidor").toLocalTime()); // Establece la hora del repartidor

        return compra; // Devuelve el objeto Compra con todos los datos cargados
    }
    /**
     * Obtiene una compra específica por su número de compra.
     *
     * @param numCompra El número de la compra a obtener.
     * @return Un objeto Compra correspondiente al número de compra proporcionado.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    public Compra obtenerCompraPorNumCompra(int numCompra) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_NUM_COMPRA_QUERY)) {
            statement.setInt(1, numCompra); // Establece el número de compra
            ResultSet resultSet = statement.executeQuery(); // Ejecuta la consulta para obtener la compra

            if (resultSet.next()) {
                return resultSetToCompra(resultSet); // Convierte el resultado en un objeto Compra
            } else {
                return null; // Si no se encuentra la compra, devuelve null
            }
        }
    }

}
