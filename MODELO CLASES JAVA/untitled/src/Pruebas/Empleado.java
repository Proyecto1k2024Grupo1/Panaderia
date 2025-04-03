package Pruebas;

import Clases.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    private static EmpleadoDAO instance;
    private Connection connection;

    private static final String INSERT_QUERY = "INSERT INTO EMPLEADO (dni, salario, fnac, nombre, encargado) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM EMPLEADO";
    private static final String UPDATE_QUERY = "UPDATE EMPLEADO SET dni = ?, salario = ?, fnac = ?, nombre = ?, encargado = ? WHERE dni = ?";
    private static final String DELETE_QUERY = "DELETE FROM EMPLEADO WHERE dni = ?";

    private EmpleadoDAO() {
        this.connection = DBConnection.getConnection();
    }

    public static synchronized EmpleadoDAO getInstance() {
        if (instance == null) {
            instance = new EmpleadoDAO();
        }
        return instance;
    }

    // Insertar un empleado
    public void insertEmpleado(Empleado empleado) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, empleado.getDni());
            statement.setDouble(2, empleado.getSalario());
            statement.setDate(3, Date.valueOf(empleado.getFnac()));
            statement.setString(4, empleado.getNombre());
            statement.setString(5, empleado.getEncargado() != null ? empleado.getEncargado().getDni() : null);
            statement.executeUpdate();
        }
    }

    // Obtener todos los empleados
    public List<Empleado> getAllEmpleados() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String dni = resultSet.getString("dni");
                Empleado empleado = cargarEmpleadoEspecifico(dni);
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    private Empleado cargarEmpleadoEspecifico(String dni) throws SQLException {
        // Este método deberá buscar al empleado en las tablas específicas según el tipo.
        return null; // Aquí iría la lógica de determinar el tipo y cargar los datos específicos.
    }

    // Actualizar un empleado
    public void updateEmpleado(Empleado empleado) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, empleado.getDni());
            statement.setDouble(2, empleado.getSalario());
            statement.setDate(3, Date.valueOf(empleado.getFnac()));
            statement.setString(4, empleado.getNombre());
            statement.setString(5, empleado.getEncargado() != null ? empleado.getEncargado().getDni() : null);
            statement.setString(6, empleado.getDni());
            statement.executeUpdate();
        }
    }

    // Eliminar un empleado
    public void deleteEmpleadoByDni(String dni) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, dni);
            statement.executeUpdate();
        }
    }
}
