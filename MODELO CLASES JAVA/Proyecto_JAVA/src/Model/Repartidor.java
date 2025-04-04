package Model;

import java.time.LocalDate;

public class Repartidor extends Empleado {
    String matricula;

    void realizarEntrega(Compra compra, LocalDate fecha, String hora) {
    }


    public Repartidor(String dni, double salario, LocalDate fnac, String nombre, String matricula) {
        super(dni, salario, fnac, nombre);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
