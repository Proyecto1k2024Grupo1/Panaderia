package DAO;

/**
 * Clase abstracta que maneja las operaciones comunes de acceso a datos para la tabla PRODUCTO en la base de datos.
 * Esta clase es la base para otros DAOs que gestionan tipos específicos de productos. Contiene las consultas SQL
 * básicas para insertar, actualizar y eliminar productos.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @since 10/04/2025
 */
public abstract class ProductoDAO {

    // Consultas SQL predefinidas para operaciones comunes en la tabla PRODUCTO
    protected static final String INSERT_QUERY_SUPER = "INSERT INTO PRODUCTO (nombre, tipo, precio) VALUES (?, ?, ?)";
    protected static final String UPDATE_QUERY_SUPER = "UPDATE PRODUCTO SET nombre = ?, tipo = ?, precio = ? WHERE codigo = ?";
    protected static final String DELETE_QUERY_SUPER = "DELETE FROM PRODUCTO WHERE codigo = ?";


}
