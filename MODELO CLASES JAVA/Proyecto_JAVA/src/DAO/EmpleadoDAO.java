package DAO;

import java.sql.Connection;

/**
 * Clase DAO (Data Access Object) para gestionar los productos ajenos en la base de datos.
 * @author Vanesa, Silvia, Jessica
 */

public abstract class EmpleadoDAO {

    Connection connection;

    protected static final String INSERT_QUERY_SUPER = "INSERT INTO EMPLEADO (dni, salario, fnac, nombre, encargado) VALUES (?, ?, ?, ?, ?)";
    protected static final String UPDATE_QUERY_SUPER = "UPDATE EMPLEADO SET salario = ?, fnac = ?, nombre = ?, encargado = ? WHERE dni = ?";
    protected static final String DELETE_QUERY_SUPER = "DELETE FROM EMPLEADO WHERE dni = ?";

}
