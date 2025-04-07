package DAO;


import Model.Repartidor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepartidorDAO extends EmpleadoDAO{

    private static RepartidorDAO instance;

    //Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO REPARTIDOR (dni, matricula) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM REPARTIDOR r JOIN EMPLEADO e on e.dni = r.dni";
    private static final String DELETE_QUERY = "DELETE FROM REPARTIDOR WHERE dni = ?";
    private static final String UPDATE_QUERY = "UPDATE REPARTIDOR SET matricula = ? WHERE dni = ?";

    private RepartidorDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la única instancia de RepartidorDAO.
     * @return instancia única de RepartidorDAO.
     */
    public static synchronized RepartidorDAO getInstance() {
        if (instance == null) {
            instance = new RepartidorDAO();
        }
        return instance;
    }


    public void insertRepartidor(Repartidor repartidor) throws SQLException {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
             PreparedStatement statement2 = connection.prepareStatement(INSERT_QUERY_SUPER)

        ) {
            statement.setString(1, repartidor.getDni());
            statement.setString(2,repartidor.getMatricula());
            statement.executeUpdate();

            statement2.setString(1, repartidor.getDni());
            statement2.setDouble(2,repartidor.getSalario());
            statement2.setDate(3, Date.valueOf(repartidor.getFnac()));
            statement2.setString(4, repartidor.getNombre());
            statement2.setString(5,repartidor.getEncargado().getDni());

            connection.commit();
        }
    }

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

    private Repartidor resultSetToRepartidor(ResultSet resultSet) throws SQLException {
        return new Repartidor(
                resultSet.getString("dni"),
                resultSet.getDouble("salario"),
                resultSet.getDate("fnac").toLocalDate(),
                resultSet.getString("nombre"),
                resultSet.getString("matricula")
        );
    }

    public void updateRepartidor(Repartidor repartidor) throws SQLException {
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY_SUPER);
             PreparedStatement statement2 = connection.prepareStatement(UPDATE_QUERY)
        ) {
            statement.setDouble(1, repartidor.getSalario());
            statement.setDate(2,Date.valueOf(repartidor.getFnac()));
            statement.setString(3, repartidor.getNombre());
            statement.setString(4, repartidor.getEncargado().getDni());
            statement.setString(5, repartidor.getDni());
            statement.executeUpdate();



            statement2.setString(1,repartidor.getMatricula());
            statement2.setString(2,repartidor.getDni());

            connection.commit();

        }
    }

    public void deleteRepartidorByDni(String dni) throws SQLException {
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

