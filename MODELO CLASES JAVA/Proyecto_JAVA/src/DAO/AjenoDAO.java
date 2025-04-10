package DAO;

import Model.Ajeno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para la gestión de productos del tipo "Ajeno" en la base de datos.
 * Esta clase extiende de ProductoDAO, lo que permite gestionar también la parte común de los productos.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @since 2025-04-10
 */
public class AjenoDAO extends ProductoDAO {
    // Instancia única para implementar el patrón Singleton
    private static AjenoDAO instance;

    // Conexión con la base de datos
    private Connection connection;

    // Sentencias SQL para operaciones básicas
    private static final String INSERT_QUERY = "INSERT INTO AJENO (codigo) VALUES (?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM AJENO JOIN PRODUCTO ON AJENO.codigo = PRODUCTO.codigo";
    private static final String UPDATE_QUERY = "UPDATE AJENO SET codigo = ? WHERE codigo = ?";
    private static final String DELETE_QUERY = "DELETE FROM AJENO WHERE codigo = ?";

    /**
     * Constructor privado que inicializa la conexión.
     * Se usa solo dentro del patrón Singleton.
     */
    private AjenoDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Devuelve la única instancia de la clase AjenoDAO.
     * Si no existe, la crea.
     *
     * @return instancia única de AjenoDAO.
     */
    public static AjenoDAO getInstance() {
        if (instance == null) {
            instance = new AjenoDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo producto Ajeno en la base de datos.
     * Primero inserta los datos comunes en la tabla PRODUCTO (superclase),
     * luego inserta el código en la tabla AJENO (subclase).
     *
     * @param ajeno Objeto Ajeno a insertar.
     * @throws SQLException si ocurre un error durante la operación.
     */
    public void insertAjeno(Ajeno ajeno) throws SQLException {
        connection.setAutoCommit(false); // Se inicia la transacción

        try (
                PreparedStatement statementSuper = connection.prepareStatement(INSERT_QUERY_SUPER, PreparedStatement.RETURN_GENERATED_KEYS);
                PreparedStatement statementAjeno = connection.prepareStatement(INSERT_QUERY)
        ) {
            // Insertar en tabla PRODUCTO
            statementSuper.setString(1, ajeno.getNombre());
            statementSuper.setString(2, ajeno.getTipo());
            statementSuper.setDouble(3, ajeno.getPrecio());
            statementSuper.executeUpdate();

            // Obtener el código generado automáticamente
            ResultSet keys = statementSuper.getGeneratedKeys();
            if (keys.next()) {
                int codigoGenerado = keys.getInt(1);

                // Insertar en tabla AJENO con el código
                statementAjeno.setInt(1, codigoGenerado);
                statementAjeno.executeUpdate();

                connection.commit(); // Confirmar transacción
            } else {
                connection.rollback(); // Deshacer cambios si no hay clave generada
                throw new SQLException("No se pudo obtener la clave generada para el producto ajeno.");
            }
        }
    }

    /**
     * Recupera todos los productos de tipo Ajeno de la base de datos.
     *
     * @return Lista de objetos Ajeno.
     * @throws SQLException si ocurre un error durante la consulta.
     */
    public List<Ajeno> getAllAjeno() throws SQLException {
        List<Ajeno> ajenos = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();

            // Se transforma cada fila en un objeto Ajeno
            while (resultSet.next()) {
                ajenos.add(resultSetToAjeno(resultSet));
            }
        }

        return ajenos;
    }

    /**
     * Convierte un resultado de la base de datos (ResultSet) en un objeto Ajeno.
     *
     * @param rs ResultSet obtenido de la base de datos.
     * @return Objeto Ajeno con los datos.
     * @throws SQLException si ocurre un error al acceder a los datos.
     */
    private Ajeno resultSetToAjeno(ResultSet rs) throws SQLException {
        return new Ajeno(
                rs.getInt("codigo"),
                rs.getString("nombre"),
                rs.getString("tipo"),
                rs.getDouble("precio")
        );
    }

    /**
     * Actualiza los datos de un producto ajeno.
     * Se actualiza tanto en la tabla PRODUCTO como en la tabla AJENO.
     *
     * @param ajeno Objeto Ajeno con los nuevos datos.
     * @throws SQLException si ocurre un error durante la actualización.
     */
    public void updateAjeno(Ajeno ajeno) throws SQLException {
        connection.setAutoCommit(false);

        try (
                PreparedStatement statementSuper = connection.prepareStatement(UPDATE_QUERY_SUPER);
                PreparedStatement statementAjeno = connection.prepareStatement(UPDATE_QUERY)
        ) {
            // Actualizar tabla PRODUCTO
            statementSuper.setString(1, ajeno.getNombre());
            statementSuper.setString(2, ajeno.getTipo());
            statementSuper.setDouble(3, ajeno.getPrecio());
            statementSuper.setInt(4, ajeno.getCodigo());
            statementSuper.executeUpdate();

            // Actualizar tabla AJENO (aunque solo se guarda el código)
            statementAjeno.setInt(1, ajeno.getCodigo());
            statementAjeno.setInt(2, ajeno.getCodigo());
            statementAjeno.executeUpdate();

            connection.commit();
        }
    }

    /**
     * Elimina un producto ajeno de la base de datos por su código.
     * Elimina primero de la tabla AJENO, luego de PRODUCTO.
     *
     * @param codigo Código del producto ajeno a eliminar.
     * @throws SQLException si ocurre un error durante la eliminación.
     */
    public void deleteAjenoByCodigo(int codigo) throws SQLException {
        connection.setAutoCommit(false);

        try (
                PreparedStatement statementAjeno = connection.prepareStatement(DELETE_QUERY);
                PreparedStatement statementSuper = connection.prepareStatement(DELETE_QUERY_SUPER)
        ) {
            // Eliminar de tabla AJENO
            statementAjeno.setInt(1, codigo);
            statementAjeno.executeUpdate();

            // Eliminar de tabla PRODUCTO
            statementSuper.setInt(1, codigo);
            statementSuper.executeUpdate();

            connection.commit();
        }
    }
}
