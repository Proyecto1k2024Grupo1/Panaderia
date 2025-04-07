package DAO;

/**
 * @author Vanesa, Silvia, Jessica
 */

import Model.Proveedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {


        private static ProveedorDAO instance;
        private Connection connection;

        //Consultas SQL predefinidas
        private static final String INSERT_QUERY = "INSERT INTO PROVEEDOR (nombre) VALUES (?)";
        private static final String SELECT_ALL_QUERY = "SELECT * FROM PROVEEDOR";
        private static final String UPDATE_QUERY = "UPDATE PROVEEDOR SET nombre = ? where codProveedor = ? ";
        private static final String DELETE_QUERY = "DELETE FROM PROVEEDOR WHERE codProveedor = ?";



        private ProveedorDAO() {
            this.connection = DBConnection.getConnection();
        }

        /**
         * Método estático para obtener la única instancia de PersonaDAO.
         * @return instancia única de PersonaDAO.
         */
        public static synchronized ProveedorDAO getInstance() {
            if (instance == null) {
                instance = new ProveedorDAO();
            }
            return instance;
        }

        public void insertProveedor(Proveedor proveedor) throws SQLException {
            try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
                statement.setString(1, proveedor.getNombre());

            }
        }
        public List<Proveedor> getAllPersonas() throws SQLException {
            List<Proveedor> proveedores = new ArrayList<>();
            try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    proveedores.add(resultSetToProveedor(resultSet));
                }
            }
            return proveedores;
        }
        private Proveedor resultSetToProveedor(ResultSet resultSet) throws SQLException {
            return new Proveedor(
                    resultSet.getInt("codProveedor"),
                    resultSet.getString("nombre")
                    );
        }
        public void updateProveedor(Proveedor proveedor) throws SQLException {
            try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
                statement.setString(1, proveedor.getNombre());

                statement.executeUpdate();
            }
        }
        public void deleteProveedorById(int id) throws SQLException {
            try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        }




}
