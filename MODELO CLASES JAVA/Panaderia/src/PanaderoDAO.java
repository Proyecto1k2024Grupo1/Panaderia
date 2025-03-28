import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PanaderoDAO {
    private static PanaderoDAO instance;
    private Connection connection;

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

    public void insertPanadero(Panadero panadero) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, panadero.getDni());
            statement.executeUpdate();
        }
    }

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


    public void updatePanadero(Panadero panadero) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, panadero.getDni());
            statement.executeUpdate();
        }
    }

    public void deletePanaderoByDni(String dni) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, dni);
            statement.executeUpdate();
        }
    }

    private Panadero resultSetToPanadero(ResultSet resultSet) throws SQLException {
        return new Panadero(
                resultSet.getString("dni"),
                resultSet.getDouble("salario"),
                resultSet.getDate("fnac").toLocalDate(),
                resultSet.getString("nombre")
        );

    }



}