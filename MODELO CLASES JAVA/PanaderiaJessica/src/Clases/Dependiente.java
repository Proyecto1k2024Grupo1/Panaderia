package Clases;

public class Dependiente extends Empleado {
    String dni;
    String horario;

    public Dependiente(String dni, String horario) {
        this.dni = dni;
        this.horario = horario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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