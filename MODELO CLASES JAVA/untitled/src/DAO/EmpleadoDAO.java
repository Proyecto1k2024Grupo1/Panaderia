package DAO;

public abstract class EmpleadoDAO {
    protected static final String INSERT_QUERY_SUPER = "INSERT INTO EMPLEADO (dni, salario, fnac, nombre) VALUES (?, ?, ?, ?)";
    protected static final String UPDATE_QUERY_SUPER = "UPDATE EMPLEADO SET salario = ?, SET fnac = ?, SET nombre = ?, SET encargado = ? WHERE dni = ?";
    protected static final String DELETE_QUERY_SUPER = "DELETE FROM EMPLEADO WHERE dni = ?";

}
