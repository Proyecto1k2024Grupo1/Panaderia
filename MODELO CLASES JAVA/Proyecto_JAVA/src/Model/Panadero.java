package Model;

import java.time.LocalDate;

public class Panadero extends Empleado {
    void prepararProducto(Propio producto) {
    }

    public Panadero(String dni, double salario, LocalDate fnac, String nombre) {
        super(dni, salario, fnac, nombre);
    }


}
