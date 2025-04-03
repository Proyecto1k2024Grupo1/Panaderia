package Pruebas;

import Clases.Panadero;
import java.sql.*;

public class PanaderoDAO {

    private static PanaderoDAO instance;
    private Connection connection;

    private static final String INSERT_QUERY = "INSERT INTO PANADERO (dni, horario, tipoPan) VALUES (?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE PANADERO SET horario = ?, tipoPan = ? WHERE dni = ?";
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

    // Insertar un panadero
    public void insertPanadero(Panadero panadero) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, panadero.getDni());
            statement.setString(2, panadero.getHorario());
            statement.setString(3, panadero.getTipoPan());
            statement.executeUpdate();
        }
    }

    // Actualizar un panadero
    public void updatePanadero(Panadero panadero) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, panadero.getHorario());
            statement.setString(2, panadero.getTipoPan());
            statement.setString(3, panadero.getDni());
            statement.executeUpdate();
        }
    }

    // Eliminar un panadero
    public void deletePanaderoByDni(String dni) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, dni);
            statement.executeUpdate();
        }
    }
}
