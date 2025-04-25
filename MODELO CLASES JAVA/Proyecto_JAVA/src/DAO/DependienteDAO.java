package DAO;

import Model.Dependiente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase maneja las operaciones de acceso a la base de datos relacionadas con los dependientes,
 * hereda de EmpleadoDAO para aprovechar la funcionalidad común con los empleados.
 * Implementa el patrón Singleton para asegurar que solo exista una instancia.
 *
 * Proporciona métodos para insertar, actualizar, eliminar y recuperar dependientes de la base de datos.
 * Las operaciones están divididas en dos fases cuando es necesario: la tabla EMPLEADO y la tabla DEPENDIENTE.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @since 10/04/2025
 */
public class DependienteDAO extends EmpleadoDAO {

    /**
     * Instancia única de la clase (Singleton).
     */
    private static DependienteDAO instance;

    /**
     * Conexión a la base de datos obtenida desde DBConnection.
     */
    private Connection connection;

    // Consultas SQL predefinidas

    /**
     * Consulta SQL para insertar un dependiente en la tabla DEPENDIENTE.
     */
    private static final String INSERT_QUERY = "INSERT INTO DEPENDIENTE (dni, horario) VALUES (?, ?)";

    /**
     * Consulta SQL para seleccionar todos los dependientes, incluyendo sus datos de EMPLEADO.
     */
    private static final String SELECT_ALL_QUERY = "SELECT * FROM DEPENDIENTE d JOIN EMPLEADO e ON e.dni = d.dni";

    /**
     * Consulta SQL para eliminar un dependiente por su DNI.
     */
    private static final String DELETE_QUERY = "DELETE FROM DEPENDIENTE WHERE dni = ?";

    /**
     * Consulta SQL para actualizar el horario de un dependiente.
     */
    private static final String UPDATE_QUERY = "UPDATE DEPENDIENTE SET horario = ? WHERE dni = ?";

    /**
     * Consulta SQL para buscar un dependiente por su DNI, incluyendo datos de EMPLEADO.
     */
    private static final String SELECT_BY_DNI_QUERY = "SELECT * FROM DEPENDIENTE d JOIN EMPLEADO e ON e.dni = d.dni WHERE d.dni = ?";

    /**
     * Constructor privado para evitar instanciación directa y asegurar el patrón Singleton.
     */
    private DependienteDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Devuelve la instancia única de DependienteDAO.
     * Si aún no se ha creado, se instancia en ese momento.
     *
     * @return Instancia única de DependienteDAO.
     */
    public static DependienteDAO getInstance() {
        if (instance == null) {
            instance = new DependienteDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo dependiente en la base de datos.
     * Realiza primero la inserción en la tabla EMPLEADO, y luego en la tabla DEPENDIENTE.
     * Usa transacciones para garantizar la integridad en caso de error.
     *
     * @param dependiente El objeto dependiente a insertar.
     * @throws SQLException Si ocurre un error de base de datos o si la transacción falla.
     */
    public void insertDependiente(Dependiente dependiente) throws SQLException {
        connection.setAutoCommit(false);
        try (
                PreparedStatement statementSuper = connection.prepareStatement(INSERT_QUERY_SUPER);
                PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)
        ) {
            // Insertar en EMPLEADO
            statementSuper.setString(1, dependiente.getDni());
            statementSuper.setDouble(2, dependiente.getSalario());
            statementSuper.setDate(3, Date.valueOf(dependiente.getFnac()));
            statementSuper.setString(4, dependiente.getNombre());
            statementSuper.setString(5, dependiente.getEncargado() != null ? dependiente.getEncargado().getDni() : null);
            statementSuper.executeUpdate();

            // Insertar en DEPENDIENTE
            statement.setString(1, dependiente.getDni());
            statement.setString(2, dependiente.getHorario());
            statement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

    /**
     * Recupera todos los dependientes de la base de datos.
     * Realiza una consulta JOIN con la tabla EMPLEADO para obtener los datos completos.
     *
     * @return Lista de objetos Dependiente encontrados en la base de datos.
     * @throws SQLException Si ocurre un error durante la consulta.
     */
    public List<Dependiente> getAllDependiente() throws SQLException {
        List<Dependiente> dependientes = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                dependientes.add(resultSetToDependiente(resultSet));
            }
        }
        return dependientes;
    }

    /**
     * Convierte un objeto ResultSet en un objeto Dependiente.
     * Extrae los campos de la consulta SQL y los asigna al objeto Dependiente correspondiente.
     * Si el campo encargado no es nulo, se asigna también como supervisor.
     *
     * @param resultSet El ResultSet con los datos obtenidos de la base de datos.
     * @return Un objeto Dependiente con los valores mapeados.
     * @throws SQLException Si ocurre un error al acceder a los datos del ResultSet.
     */
    private Dependiente resultSetToDependiente(ResultSet resultSet) throws SQLException {
        String dniSupervisor = resultSet.getString("encargado");

        Dependiente dependiente = new Dependiente(
                resultSet.getString("dni"),
                resultSet.getDouble("salario"),
                resultSet.getDate("fnac").toLocalDate(),
                resultSet.getString("nombre"),
                resultSet.getString("horario")
        );

        if (dniSupervisor != null) {
            dependiente.setEncargado(new Dependiente(dniSupervisor));
        }

        return dependiente;
    }

    /**
     * Actualiza la información de un dependiente en la base de datos.
     * Primero actualiza la tabla EMPLEADO, y luego actualiza el horario en la tabla DEPENDIENTE.
     * Utiliza transacciones para evitar inconsistencias.
     *
     * @param dependiente El objeto Dependiente con los datos actualizados.
     * @throws SQLException Si ocurre un error durante la transacción.
     */
    public void updateDependiente(Dependiente dependiente) throws SQLException {
        connection.setAutoCommit(false);
        try (
                PreparedStatement statementSuper = connection.prepareStatement(UPDATE_QUERY_SUPER);
                PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)
        ) {
            statementSuper.setDouble(1, dependiente.getSalario());
            statementSuper.setDate(2, Date.valueOf(dependiente.getFnac()));
            statementSuper.setString(3, dependiente.getNombre());
            statementSuper.setString(4, dependiente.getEncargado() != null ? dependiente.getEncargado().getDni() : null);
            statementSuper.setString(5, dependiente.getDni());
            statementSuper.executeUpdate();

            statement.setString(1, dependiente.getHorario());
            statement.setString(2, dependiente.getDni());
            statement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

    /**
     * Elimina un dependiente de la base de datos según su DNI.
     * Elimina primero de la tabla DEPENDIENTE y luego de EMPLEADO.
     * Usa transacciones para mantener la consistencia si ocurre un error.
     *
     * @param dni El DNI del dependiente que se desea eliminar.
     * @throws SQLException Si ocurre un error durante la eliminación.
     */
    public void deleteDependienteByDni(String dni) throws SQLException {
        connection.setAutoCommit(false);
        try (
                PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
                PreparedStatement statementSuper = connection.prepareStatement(DELETE_QUERY_SUPER)
        ) {
            statement.setString(1, dni);
            statement.executeUpdate();

            statementSuper.setString(1, dni);
            statementSuper.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

    /**
     * Recupera un dependiente específico a partir de su DNI.
     * Realiza un JOIN con la tabla EMPLEADO para obtener toda su información.
     *
     * @param dni El DNI del dependiente a buscar.
     * @return El objeto Dependiente correspondiente, o null si no se encuentra.
     * @throws SQLException Si ocurre un error en la consulta.
     */
    public Dependiente getDependienteByDni(String dni) throws SQLException {
        Dependiente dependiente = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_DNI_QUERY)) {
            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                dependiente = resultSetToDependiente(resultSet);
            }
        }
        return dependiente;
    }
}
