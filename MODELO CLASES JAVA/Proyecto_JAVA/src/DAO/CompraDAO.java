package DAO;

import java.sql.Connection;

public class CompraDAO {
    private static CompraDAO instance;
    private Connection connection;

    private static final String INSERT_QUERY = "INSERT INTO COMPRA (fecha, idCliente) VALUES (CURDATE(), ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM COMPRA";
    private static final String UPDATE_QUERY = "UPDATE COMPRA SET idCliente = ? where numCompra = ? ";
    private static final String UPDATE_QUERY_DEPENDIENTE = "UPDATE COMPRA SET dniDependiente = ?, descuentoDependiente = ?, fechaDependiente = CURDATE() where numCompra = ? ";
    private static final String UPDATE_QUERY_REPARTIDOR = "UPDATE COMPRA SET dniRepartidor = ?, fechaRepartido = CURDATE(), horaRepartidor = CURTIME() where numCompra = ? ";
    private static final String DELETE_QUERY = "DELETE FROM COMPRA WHERE numCompra = ?";

}
