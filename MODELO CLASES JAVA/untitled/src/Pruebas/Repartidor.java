package Pruebas;

import Clases.Repartidor;
import java.sql.*;

public class RepartidorDAO {

    private static RepartidorDAO instance;
    private Connection connection;

    private static final String INSERT_QUERY = "INSERT INTO REPARTIDOR (dni, vehiculo, zona) VALUES (?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE REPARTIDOR SET vehiculo = ?, zona = ? WHERE dni = ?";
    private static final String DELETE_QUERY = "DELETE FROM REPARTIDOR WHERE dni = ?";

    private RepartidorDAO() {
        this.connection = DBConnection.getConnection();
    }

    public static synchronized RepartidorDAO getInstance() {
        if (instance == null) {
            instance = new RepartidorDAO();
        }
        return instance;
    }

    // Insertar un repartidor
    public void insertRepartidor(Repartidor repartidor) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, repartidor.getDni());
            statement.setString(2, repartidor.getVehiculo());
            statement.setString(3, repartidor.getZona());
            statement.executeUpdate();
        }
    }

    // Actualizar un repartidor
    public void updateRepartidor(Repartidor repartidor) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, repartidor.getVehiculo());
            statement.setString(2, repartidor.getZona());
            statement.setString(3, repartidor.getDni());
            statement.executeUpdate();
        }
    }

    // Eliminar un repartidor
    public void deleteRepartidorByDni(String dni) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, dni);
            statement.executeUpdate();
        }
    }
}
