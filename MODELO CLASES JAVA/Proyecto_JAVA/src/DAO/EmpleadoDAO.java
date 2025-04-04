package DAO;

import java.sql.Connection;

public abstract class EmpleadoDAO {

    Connection connection;

    protected static final String INSERT_QUERY_SUPER = "INSERT INTO EMPLEADO (dni, salario, fnac, nombre) VALUES (?, ?, ?, ?)";
    protected static final String UPDATE_QUERY_SUPER = "UPDATE EMPLEADO SET salario = ?, SET fnac = ?, SET nombre = ?, SET encargado = ? WHERE dni = ?";
    protected static final String DELETE_QUERY_SUPER = "DELETE FROM EMPLEADO WHERE dni = ?";




}
