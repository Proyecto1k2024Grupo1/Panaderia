package DAO;

import java.sql.Connection;

/**
 * Clase DAO (Data Access Object) abstracta para gestionar operaciones comunes de los empleados en la base de datos.
 * Esta clase sirve como clase base para otras clases DAO específicas, como DependienteDAO o RepartidorDAO.
 * Contiene la conexión a la base de datos y las consultas SQL comunes a todos los empleados.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @since 10/04/2025
 */
public abstract class EmpleadoDAO {

    /**
     * Conexión a la base de datos utilizada por las subclases DAO.
     */
    Connection connection;

    /**
     * Consulta SQL para insertar un nuevo empleado en la tabla EMPLEADO.
     * Se insertan los campos: dni, salario, fecha de nacimiento, nombre y encargado.
     */
    protected static final String INSERT_QUERY_SUPER =
            "INSERT INTO EMPLEADO (dni, salario, fnac, nombre, encargado) VALUES (?, ?, ?, ?, ?)";

    /**
     * Consulta SQL para actualizar los datos de un empleado existente en la tabla EMPLEADO.
     * Se actualizan: salario, fecha de nacimiento, nombre y encargado, usando el dni como clave.
     */
    protected static final String UPDATE_QUERY_SUPER =
            "UPDATE EMPLEADO SET salario = ?, fnac = ?, nombre = ?, encargado = ? WHERE dni = ?";

    /**
     * Consulta SQL para eliminar un empleado de la tabla EMPLEADO a partir de su dni.
     */
    protected static final String DELETE_QUERY_SUPER =
            "DELETE FROM EMPLEADO WHERE dni = ?";
}
