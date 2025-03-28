package Dependiente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Clases.Dependiente;

public class DependienteDAO {
    private static DependienteDAO instance;

    private Connection connection;

    //Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO DEPENDIENTE (dni, horario) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM DEPENDIENTE";
    private static final String UPDATE_QUERY = "UPDATE DEPENDIENTE SET horario = ? WHERE dni = ?";
    private static final String DELETE_QUERY = "DELETE FROM DEPENDIENTE WHERE dni = ?";

    /**
     * Método estático para obtener la única instancia de DependienteDAO.
     * @return instancia única de DependienteDAO.
     */
    private DependienteDAO(){
        this.connection = DBConnection.getConnection();
    }

    /**
     * Inserta un nuevo dependiente en la base de datos
     * @param dependiente dependiente a insertar.
     * @throws SQLException Si ocurre un error en la base de datos
     */
    public void insertDependiente(Dependiente dependiente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, dependiente.getDni());
            statement.setString(1, dependiente.getHorario());
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene todos los dependientes almacenados en la base de datos.
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
     * Actualiza los datos de un dependiente en la base de datos.
     * @param dependiente dependiente con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updateDependiente(Dependiente dependiente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, dependiente.getDni());
            statement.setString(1, dependiente.getHorario());
            statement.executeUpdate();
        }
    }

    /**
     * Elimina un dependiente de la base de datos por su DNI.
     * @param dni Identificador único del dependiente a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deleteDependienteByDni(String dni) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, dni);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto dependiente.
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto Dependiente con los datos del ResultSet.
     * @throws SQLException Por si ocurre un error en la conversión.
     */
    private Dependiente resultSetToDependiente(ResultSet resultSet) throws SQLException {
        return new Dependiente(
                resultSet.getString("dni"),
                resultSet.getString("horario"));
    }
}
