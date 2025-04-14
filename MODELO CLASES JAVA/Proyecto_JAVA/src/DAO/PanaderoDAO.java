package DAO;

import Model.Panadero;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar las operaciones CRUD de los panaderos en la base de datos.
 * Esta clase extiende de EmpleadoDAO y proporciona métodos para insertar, actualizar,
 * eliminar y obtener panaderos. Utiliza transacciones para garantizar la integridad de los datos.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @since 10/04/2025
 */

public class PanaderoDAO extends EmpleadoDAO {
    private static PanaderoDAO instance;
    private Connection connection;

    // Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO PANADERO (dni) VALUES (?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM PANADERO p JOIN EMPLEADO e ON e.dni = p.dni";
    private static final String DELETE_QUERY = "DELETE FROM PANADERO WHERE dni = ?";
    private static final String SELECT_BY_DNI_QUERY = "SELECT * FROM PANADERO p JOIN EMPLEADO e ON e.dni = p.dni WHERE p.dni = ?";  // Consulta SQL final para obtener por DNI

    /**
     * Constructor privado para evitar la instanciación externa de esta clase.
     * Establece la conexión con la base de datos a través de la clase DBConnection.
     */
    private PanaderoDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la única instancia de PanaderoDAO.
     * Este método sigue el patrón Singleton, asegurando que solo haya una instancia de esta clase.
     *
     * @return La instancia única de PanaderoDAO.
     */
    public static synchronized PanaderoDAO getInstance() {
        if (instance == null) {
            instance = new PanaderoDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo panadero en la base de datos.
     * Este método ejecuta una transacción que incluye la inserción de datos en las tablas
     * correspondientes, utilizando dos sentencias SQL para insertar los datos del panadero
     * y su información adicional como su salario y fecha de nacimiento.
     *
     * @param panadero El panadero a insertar en la base de datos.
     * @throws SQLException Si ocurre un error en la base de datos durante la operación.
     */
    public void insertPanadero(Panadero panadero) throws SQLException {
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(INSERT_QUERY_SUPER)) {

            statement2.setString(1, panadero.getDni());
            statement2.setDouble(2, panadero.getSalario());
            statement2.setDate(3, Date.valueOf(panadero.getFnac()));
            statement2.setString(4, panadero.getNombre());
            statement2.setString(5, panadero.getEncargado() != null ? panadero.getEncargado().getDni() : null);
            statement2.executeUpdate();

            statement.setString(1, panadero.getDni());
            statement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;  // Vuelve a lanzar la excepción después de hacer rollback
        }
    }

    /**
     * Obtiene todos los panaderos almacenados en la base de datos.
     * Este método ejecuta una consulta SELECT para recuperar los datos de todos los panaderos
     * y los convierte en objetos Panadero.
     *
     * @return Una lista de objetos Panadero representando todos los panaderos en la base de datos.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    public List<Panadero> getAllPanaderos() throws SQLException {
        List<Panadero> personas = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                personas.add(resultSetToPanadero(resultSet));
            }
        }
        return personas;
    }

    /**
     * Obtiene un panadero por su DNI.
     * Este método ejecuta una consulta SELECT utilizando el DNI para recuperar los datos del panadero
     * y lo convierte en un objeto Panadero.
     *
     * @param dni El DNI del panadero a obtener.
     * @return El objeto Panadero correspondiente al DNI proporcionado.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    public Panadero getPanaderoByDni(String dni) throws SQLException {
        Panadero panadero = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_DNI_QUERY)) {
            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                panadero = resultSetToPanadero(resultSet);
            }
        }
        return panadero;
    }

    /**
     * Convierte un objeto ResultSet en una instancia de Panadero.
     * Este método mapea cada columna del ResultSet a los atributos del objeto Panadero.
     *
     * @param resultSet El ResultSet obtenido de la consulta SQL.
     * @return Una instancia de Panadero con los datos del ResultSet.
     * @throws SQLException Si ocurre un error al obtener los datos del ResultSet.
     */
    private Panadero resultSetToPanadero(ResultSet resultSet) throws SQLException {
        return new Panadero(
                resultSet.getString("dni"),
                resultSet.getDouble("salario"),
                resultSet.getDate("fnac").toLocalDate(),
                resultSet.getString("nombre")
        );
    }

    /**
     * Actualiza los datos de un panadero en la base de datos.
     * Este método ejecuta una transacción que incluye la actualización de los datos del panadero
     * en las tablas correspondientes.
     *
     * @param panadero El panadero con los nuevos datos a actualizar.
     * @throws SQLException Si ocurre un error en la base de datos durante la operación.
     */
    public void updatePanadero(Panadero panadero) throws SQLException {
        connection.setAutoCommit(false);
        try (
             PreparedStatement statement2 = connection.prepareStatement(UPDATE_QUERY_SUPER)) {

            statement2.setDouble(1, panadero.getSalario());
            statement2.setDate(2, Date.valueOf(panadero.getFnac()));
            statement2.setString(3, panadero.getNombre());
            statement2.setString(4, panadero.getEncargado() != null ? panadero.getEncargado().getDni() : null);
            statement2.setString(5, panadero.getDni());
            statement2.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;  // Vuelve a lanzar la excepción después de hacer rollback
        }
    }

    /**
     * Elimina un panadero de la base de datos mediante su DNI.
     * Este método ejecuta una transacción para eliminar los registros del panadero y su información asociada
     * de las tablas correspondientes.
     *
     * @param dni El DNI del panadero a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos durante la operación.
     */
    public void deletePanaderoByDni(String dni) throws SQLException {
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(DELETE_QUERY_SUPER)) {

            statement.setString(1, dni);
            statement.executeUpdate();

            statement2.setString(1, dni);
            statement2.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;  // Vuelve a lanzar la excepción después de hacer rollback
        }
    }
}
