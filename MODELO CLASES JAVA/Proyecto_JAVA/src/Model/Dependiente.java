package Model;

import java.time.LocalDate;

public class Dependiente extends Empleado {

    String horario;

    public Dependiente(String dni, double salario, LocalDate fnac, String nombre, String horario) {
        super(dni, salario, fnac, nombre);
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    void atenderCliente(Cliente cliente) {
    }

    void aplicarDescuento(Compra compra, double descuento) {
    }
}
