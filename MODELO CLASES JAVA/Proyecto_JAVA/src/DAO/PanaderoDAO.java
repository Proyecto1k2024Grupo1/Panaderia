package DAO;

import Model.Panadero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PanaderoDAO extends EmpleadoDAO{
    private static PanaderoDAO instance;
    private Connection connection;

    //Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO PANADERO (dni) VALUES (?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM PANADERO";
    static final String UPDATE_QUERY = "UPDATE PANADERO SET dni = ? WHERE dni = ?";
    private static final String DELETE_QUERY = "DELETE FROM PANADERO WHERE dni = ?";


    private PanaderoDAO() {
        this.connection = DBConnection.getConnection();
    }


    public static synchronized PanaderoDAO getInstance() {
        if (instance == null) {
            instance = new PanaderoDAO();
        }
        return instance;
    }

    /**
     *  Inserta un nuevo Panadero en la base de datos
     * @param panadero Objeto panadero a insertar
     * @throws SQLException Si ocurre un error en la base de datos
     */
    public void insertPanadero(Panadero panadero) throws SQLException {
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(INSERT_QUERY_SUPER)
        ) {
            statement.setString(1, panadero.getDni());
            statement.executeUpdate();

            statement2.setString(1, panadero.getDni());
            statement2.setDouble(2, panadero.getSalario());
            statement2.setDate(3, Date.valueOf(panadero.getFnac()));
            statement2.setString(4, panadero.getNombre());
            statement2.setString(5, panadero.getEncargado().getDni());
            statement2.executeUpdate();

            connection.commit();
        }
    }

    /**
     *  Todos los panaderos  almacenados en la base de datos
     * @return Lista de objetos Panadero
     * @throws SQLException Si ocurre un error en la base de datos
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
     *  Convierte un ResultSet en un objeto Panadero
     * @param resultSet Resultado de la consulta SQL
     * @return Objeto Panadero con los datos del ResultSet
     * @throws SQLException Si ocurre un error en la base de datos
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
     * Actualiza los datos del panadero en la base de datos
     * @param panadero
     * @throws SQLException Si ocurre un error en la base de datos
     */
    public void updatePanadero(Panadero panadero) throws SQLException {
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(UPDATE_QUERY_SUPER)
        ) {
            statement.setString(1, panadero.getDni());
            statement.executeUpdate();


            statement2.setDouble(1, panadero.getSalario());
            statement2.setDate(2, Date.valueOf(panadero.getFnac()));
            statement2.setString(3, panadero.getNombre());
            statement2.setString(4, panadero.getEncargado().getDni());
            statement2.setString(5, panadero.getDni());
            statement2.executeUpdate();

            connection.commit();

        }
    }

    /**
     * Elimina un objeto Panadero de la base de datos por su dni
     * @param dni Identificador único del panadero a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos
     */
    public void deletePanaderoByDni(String dni) throws SQLException {
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(DELETE_QUERY_SUPER)
        ) {
            statement.setString(1, dni);
            statement.executeUpdate();


            statement2.setString(1, dni);
            statement2.executeUpdate();

            connection.commit();

        }
    }

}




