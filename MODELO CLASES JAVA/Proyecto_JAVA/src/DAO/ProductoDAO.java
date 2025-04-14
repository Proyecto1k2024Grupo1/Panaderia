package DAO;

/**
 * Clase abstracta que maneja las operaciones comunes de acceso a datos para la tabla PRODUCTO en la base de datos.
 *
 * Contiene las consultas necesarias para insertar, actualizar y eliminar productos en la tabla PRODUCTO.
 * No contiene lógica de conexión o ejecución, ya que está pensada para ser extendida.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @since 10/04/2025
 */
public abstract class ProductoDAO {

    /**
     * Consulta SQL para insertar un nuevo producto en la tabla PRODUCTO.
     * Requiere los campos: nombre, tipo y precio.
     */
    protected static final String INSERT_QUERY_SUPER =
            "INSERT INTO PRODUCTO (nombre, tipo, precio) VALUES (?, ?, ?)";

    /**
     * Consulta SQL para actualizar un producto existente en la tabla PRODUCTO.
     * Actualiza los campos: nombre, tipo y precio, identificando el producto por su código.
     */
    protected static final String UPDATE_QUERY_SUPER =
            "UPDATE PRODUCTO SET nombre = ?, tipo = ?, precio = ? WHERE codigo = ?";

    /**
     * Consulta SQL para eliminar un producto de la tabla PRODUCTO usando su código como identificador.
     */
    protected static final String DELETE_QUERY_SUPER =
            "DELETE FROM PRODUCTO WHERE codigo = ?";
}
