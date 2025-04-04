package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Dependiente;

public class DependienteDAO extends EmpleadoDAO {
    private static DependienteDAO instance;

    private Connection connection;

    //Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO DEPENDIENTE (dni, horario) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM DEPENDIENTE d JOIN EMPLEADO e ON e.dni = d.dni";
    private static final String DELETE_QUERY = "DELETE FROM DEPENDIENTE WHERE dni = ?";
    private static final String UPDATE_QUERY = "UPDATE DEPENDIENTE SET horario = ? WHERE dni = ?";

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
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(INSERT_QUERY_SUPER)
        ) {
            statement.setString(1, dependiente.getDni());
            statement.setString(1, dependiente.getHorario());
            statement.executeUpdate();

            statement2.setString(1, dependiente.getDni());
            statement2.setDouble(2, dependiente.getSalario());
            statement2.setDate(3, Date.valueOf(dependiente.getFnac()));
            statement2.setString(4, dependiente.getNombre());
            statement2.setString(5, dependiente.getEncargado().getDni());

            connection.commit();
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
     * Convierte un ResultSet en un objeto dependiente.
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto Dependiente con los datos del ResultSet.
     * @throws SQLException Por si ocurre un error en la conversión.
     */
    private Dependiente resultSetToDependiente(ResultSet resultSet) throws SQLException {
        return new Dependiente(
                resultSet.getString("dni"),
                resultSet.getDouble("salario"),
                resultSet.getDate("fnac").toLocalDate(),
                resultSet.getString("nombre"),
                resultSet.getString("horario")
        );
    }

    /**
     * Actualiza los datos de un dependiente en la base de datos.
     * @param dependiente dependiente con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updateDependiente(Dependiente dependiente) throws SQLException {
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY_SUPER);
             PreparedStatement statement2 = connection.prepareStatement(UPDATE_QUERY)
        ) {
            statement.setDouble(1, dependiente.getSalario());
            statement.setDate(2, Date.valueOf(dependiente.getFnac()));
            statement.setString(3, dependiente.getNombre());
            statement.setString(4, dependiente.getEncargado().getDni());
            statement.setString(5, dependiente.getDni());
            statement.executeUpdate();


            statement2.setString(1,dependiente.getHorario());
            statement2.setString(2, dependiente.getDni());

            connection.commit();
        }
    }

    /**
     * Elimina un dependiente de la base de datos por su DNI.
     * @param dni Identificador único del dependiente a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deleteDependienteByDni(String dni) throws SQLException {
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(DELETE_QUERY_SUPER)
        ) {
            statement.setString(1, dni);
            statement.executeUpdate();

            statement2.setString(1, dni);
            statement.executeUpdate();

            connection.commit();
        }
    }


}
