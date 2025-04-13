package DAO;

/**
 * Esta clase maneja las operaciones de acceso a la base de datos relacionadas con los dependientes,
 * hereda de EmpleadoDAO para aprovechar la funcionalidad común con los empleados.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @date 10/04/2025
 */

import Model.Dependiente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DependienteDAO extends EmpleadoDAO {
    private static DependienteDAO instance;
    private Connection connection;

    // Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO DEPENDIENTE (dni, horario) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM DEPENDIENTE d JOIN EMPLEADO e ON e.dni = d.dni";
    private static final String DELETE_QUERY = "DELETE FROM DEPENDIENTE WHERE dni = ?";
    private static final String UPDATE_QUERY = "UPDATE DEPENDIENTE SET horario = ? WHERE dni = ?";
    private static final String SELECT_BY_DNI_QUERY = "SELECT * FROM DEPENDIENTE d JOIN EMPLEADO e ON e.dni = d.dni WHERE d.dni = ?";

    /**
     * Constructor privado para evitar instanciación directa y asegurar el patrón Singleton.
     */
    private DependienteDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la única instancia de DependienteDAO.
     * Utiliza el patrón Singleton para asegurar que sólo existe una instancia.
     *
     * @return instancia única de DependienteDAO.
     */
    public static DependienteDAO getInstance() {
        if (instance == null) {
            instance = new DependienteDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo dependiente en la base de datos, tanto en la tabla EMPLEADO como en DEPENDIENTE.
     * Si ocurre un error, realiza un rollback para mantener la base de datos consistente.
     *
     * @param dependiente El objeto dependiente que se va a insertar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void insertDependiente(Dependiente dependiente) throws SQLException {
        connection.setAutoCommit(false);
        try (
                PreparedStatement statementSuper = connection.prepareStatement(INSERT_QUERY_SUPER);
                PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)
        ) {
            // Primero insertar en EMPLEADO
            statementSuper.setString(1, dependiente.getDni());
            statementSuper.setDouble(2, dependiente.getSalario());
            statementSuper.setDate(3, Date.valueOf(dependiente.getFnac()));
            statementSuper.setString(4, dependiente.getNombre());
            statementSuper.setString(5, dependiente.getEncargado() != null ? dependiente.getEncargado().getDni() : null);
            statementSuper.executeUpdate();

            // Luego insertar en DEPENDIENTE
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
     * Obtiene todos los dependientes almacenados en la base de datos.
     *
     * @return Lista de objetos dependientes.
     * @throws SQLException Si ocurre un error en la base de datos.
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
     * Este método es usado para mapear los resultados de la consulta a objetos en Java.
     *
     * @param resultSet El ResultSet obtenido de la consulta SQL.
     * @return Un objeto Dependiente con los datos mapeados.
     * @throws SQLException Si ocurre un error durante la conversión.
     */
    private Dependiente resultSetToDependiente(ResultSet resultSet) throws SQLException {
        String dniSupervisor = resultSet.getString("encargado");

        // Crear un objeto Dependiente con los datos obtenidos del ResultSet
        Dependiente dependiente = new Dependiente(
                resultSet.getString("dni"),
                resultSet.getDouble("salario"),
                resultSet.getDate("fnac").toLocalDate(),
                resultSet.getString("nombre"),
                resultSet.getString("horario")
        );

        // Si existe un supervisor, asignarlo al dependiente
        if (dniSupervisor != null) {
            dependiente.setEncargado(new Dependiente(dniSupervisor));
        }

        return dependiente;
    }

    /**
     * Actualiza los datos de un dependiente en la base de datos, tanto en la tabla EMPLEADO como en DEPENDIENTE.
     * Si ocurre un error, realiza un rollback para mantener la base de datos consistente.
     *
     * @param dependiente El objeto dependiente con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
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
     * Elimina un dependiente de la base de datos por su DNI, tanto de la tabla DEPENDIENTE como de EMPLEADO.
     * Si ocurre un error, realiza un rollback para mantener la base de datos consistente.
     *
     * @param dni El DNI del dependiente a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
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
     * Obtiene un dependiente a partir de su DNI almacenado en la base de datos.
     *
     * @param dni El DNI del dependiente que se desea obtener.
     * @return Un objeto dependiente si se encuentra en la base de datos, o null si no existe.
     * @throws SQLException Si ocurre un error en la base de datos.
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
