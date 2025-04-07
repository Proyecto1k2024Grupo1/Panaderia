package DAO;

/**
 * @author Vanesa, Silvia, Jessica
 */

public abstract class ProductoDAO {
    protected static final String INSERT_QUERY_SUPER = "INSERT INTO PRODUCTO (nombre, tipo, precio) VALUES (?, ?, ?)";
    protected static final String UPDATE_QUERY_SUPER = "UPDATE PRODUCTO SET nombre = ?, tipo = ?, precio = ? WHERE codigo = ?";
    protected static final String DELETE_QUERY_SUPER = "DELETE FROM PRODUCTO WHERE codigo = ?";
}
