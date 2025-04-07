package Model;

import java.time.LocalDate;

public class Panadero extends Empleado {
    public Panadero(String dni, double salario, LocalDate fnac, String nombre, String horario) {
    }

    public Panadero(String dniSupervisor) {
    }

    void prepararProducto(Propio producto) {
    }

    public Panadero(String dni, double salario, LocalDate fnac, String nombre) {
        super(dni, salario, fnac, nombre);
    }


}
