package DAO;

/**
 * @author Vanesa, Silvia, Jessica
 */

import java.sql.Connection;

public abstract class EmpleadoDAO {
    // Conexión a la base de datos
    Connection connection;

    //Consultas SQL predefinidas
    protected static final String INSERT_QUERY_SUPER = "INSERT INTO EMPLEADO (dni, salario, fnac, nombre, encargado_dni) VALUES (?, ?, ?, ?, ?)";
    protected static final String UPDATE_QUERY_SUPER = "UPDATE EMPLEADO SET salario = ?, fnac = ?, nombre = ?, encargado_dni = ? WHERE dni = ?";
    protected static final String DELETE_QUERY_SUPER = "DELETE FROM EMPLEADO WHERE dni = ?";

}
