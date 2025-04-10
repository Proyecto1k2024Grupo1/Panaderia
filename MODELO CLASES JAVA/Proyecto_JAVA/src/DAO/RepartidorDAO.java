package DAO;

/**
 * Clase que maneja las operaciones de acceso a datos para los repartidores en la base de datos.
 * Esta clase extiende EmpleadoDAO para compartir funcionalidades comunes entre empleados y repartidores.
 * Proporciona métodos para insertar, actualizar, eliminar y obtener repartidores.
 *
 * @author Vanesa, Silvia, Jessica
 * @version 1.1
 * @date 10/04/2025
 */

import Model.Repartidor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepartidorDAO extends EmpleadoDAO {

    private static RepartidorDAO instance;

    // Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO REPARTIDOR (dni, matricula) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM REPARTIDOR r JOIN EMPLEADO e ON e.dni = r.dni";
    private static final String DELETE_QUERY = "DELETE FROM REPARTIDOR WHERE dni = ?";
    private static final String UPDATE_QUERY = "UPDATE REPARTIDOR SET matricula = ? WHERE dni = ?";
    private static final String INSERT_QUERY_SUPER = "INSERT INTO EMPLEADO (dni, salario, fnac, nombre, dni_supervisor) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY_SUPER = "UPDATE EMPLEADO SET salario = ?, fnac = ?, nombre = ?, dni_supervisor = ? WHERE dni = ?";

    /**
     * Constructor privado para evitar la creación de instancias fuera de la clase.
     * Inicializa la conexión a la base de datos.
     */
    private RepartidorDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la única instancia de RepartidorDAO (patrón Singleton).
     * @return La única instancia de RepartidorDAO.
     */
    public static synchronized RepartidorDAO getInstance() {
        if (instance == null) {
            instance = new RepartidorDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo repartidor en la base de datos, incluyendo los datos en las tablas EMPLEADO y REPARTIDOR.
     * Utiliza transacciones para asegurar que ambos registros se insertan correctamente.
     * @param repartidor El repartidor a insertar.
     * @throws SQLException Si ocurre un error durante la inserción.
     */
    public void insertRepartidor(Repartidor repartidor) throws SQLException {
        connection.setAutoCommit(false); // Comienza la transacción

        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(INSERT_QUERY_SUPER)) {

            // Inserción en la tabla REPARTIDOR
            statement.setString(1, repartidor.getDni());
            statement.setString(2, repartidor.getMatricula());
            statement.executeUpdate();

            // Inserción en la tabla EMPLEADO
            statement2.setString(1, repartidor.getDni());
            statement2.setDouble(2, repartidor.getSalario());
            statement2.setDate(3, Date.valueOf(repartidor.getFnac()));
            statement2.setString(4, repartidor.getNombre());
            statement2.setString(5, repartidor.getEncargado() != null ? repartidor.getEncargado().getDni() : null);
            statement2.executeUpdate();

            connection.commit(); // Si ambas inserciones fueron exitosas, realiza la confirmación
        } catch (SQLException e) {
            connection.rollback(); // Si ocurre un error, deshace los cambios realizados
            throw e; // Lanza la excepción para que se pueda manejar en otro lugar
        }
    }

    /**
     * Obtiene todos los repartidores almacenados en la base de datos.
     * @return Lista de repartidores.
     * @throws SQLException Si ocurre un error al recuperar los datos.
     */
    public List<Repartidor> getAllRepartidores() throws SQLException {
        List<Repartidor> repartidores = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                repartidores.add(resultSetToRepartidor(resultSet));
            }
        }
        return repartidores;
    }

    /**
     * Convierte un ResultSet en un objeto Repartidor.
     * @param resultSet El resultado de la consulta SQL.
     * @return Un objeto Repartidor que contiene los datos extraídos del ResultSet.
     * @throws SQLException Si ocurre un error al extraer los datos del ResultSet.
     */
    private Repartidor resultSetToRepartidor(ResultSet resultSet) throws SQLException {
        // Obtener el dni del supervisor (si existe)
        String dniSupervisor = resultSet.getString("dni_supervisor");

        // Crear un objeto Repartidor
        Repartidor repartidor = new Repartidor(
                resultSet.getString("dni"),
                resultSet.getDouble("salario"),
                resultSet.getDate("fnac").toLocalDate(),
                resultSet.getString("nombre"),
                resultSet.getString("horario")
        );

        // Si el dniSupervisor no es null, asignamos el supervisor al repartidor
        if (dniSupervisor != null) {
            repartidor.setEncargado(new Repartidor(dniSupervisor));  // Ajusta esto según la lógica de tu clase
        }

        return repartidor;
    }

    /**
     * Actualiza los datos de un repartidor en la base de datos.
     * Utiliza transacciones para garantizar que ambas tablas (REPARTIDOR y EMPLEADO) se actualicen correctamente.
     * @param repartidor El repartidor con los nuevos datos.
     * @throws SQLException Si ocurre un error durante la actualización.
     */
    public void updateRepartidor(Repartidor repartidor) throws SQLException {
        connection.setAutoCommit(false); // Comienza la transacción
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY_SUPER);
             PreparedStatement statement2 = connection.prepareStatement(UPDATE_QUERY)) {

            // Actualización en la tabla EMPLEADO
            statement.setDouble(1, repartidor.getSalario());
            statement.setDate(2, Date.valueOf(repartidor.getFnac()));
            statement.setString(3, repartidor.getNombre());
            statement.setString(4, repartidor.getEncargado() != null ? repartidor.getEncargado().getDni() : null);
            statement.setString(5, repartidor.getDni());
            statement.executeUpdate();

            // Actualización en la tabla REPARTIDOR
            statement2.setString(1, repartidor.getMatricula());
            statement2.setString(2, repartidor.getDni());
            statement2.executeUpdate();

            connection.commit(); // Si ambas actualizaciones fueron exitosas, realiza la confirmación
        } catch (SQLException e) {
            connection.rollback(); // Si ocurre un error, deshace los cambios realizados
            throw e; // Lanza la excepción para que se pueda manejar en otro lugar
        }
    }

    /**
     * Elimina un repartidor de la base de datos utilizando su DNI.
     * Utiliza transacciones para eliminar los registros tanto en la tabla REPARTIDOR como en EMPLEADO.
     * @param dni El DNI del repartidor a eliminar.
     * @throws SQLException Si ocurre un error durante la eliminación.
     */
    public void deleteRepartidorByDni(String dni) throws SQLException {
        connection.setAutoCommit(false); // Comienza la transacción
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(DELETE_QUERY_SUPER)) {

            // Eliminar de la tabla REPARTIDOR
            statement.setString(1, dni);
            statement.executeUpdate();

            // Eliminar de la tabla EMPLEADO
            statement2.setString(1, dni);
            statement2.executeUpdate();

            connection.commit(); // Si ambas eliminaciones fueron exitosas, realiza la confirmación
        } catch (SQLException e) {
            connection.rollback(); // Si ocurre un error, deshace los cambios realizados
            throw e; // Lanza la excepción para que se pueda manejar en otro lugar
        }
    }
}
