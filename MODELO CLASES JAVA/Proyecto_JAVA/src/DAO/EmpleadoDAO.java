package DAO;

/**
 * Clase abstracta que maneja las operaciones comunes de acceso a datos de la tabla EMPLEADO en la base de datos.
 * Esta clase es la base para otros DAOs que gestionan tipos específicos de empleados, como los dependientes.
 * Contiene las consultas SQL básicas para insertar, actualizar y eliminar empleados.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @date 10/04/2025
 */

import java.sql.Connection;

public abstract class EmpleadoDAO {

    // Conexión a la base de datos
    protected Connection connection;

    // Consultas SQL predefinidas para operaciones comunes en la tabla EMPLEADO
    protected static final String INSERT_QUERY_SUPER = "INSERT INTO EMPLEADO (dni, salario, fnac, nombre, encargado_dni) VALUES (?, ?, ?, ?, ?)";
    protected static final String UPDATE_QUERY_SUPER = "UPDATE EMPLEADO SET salario = ?, fnac = ?, nombre = ?, encargado_dni = ? WHERE dni = ?";
    protected static final String DELETE_QUERY_SUPER = "DELETE FROM EMPLEADO WHERE dni = ?";

}
