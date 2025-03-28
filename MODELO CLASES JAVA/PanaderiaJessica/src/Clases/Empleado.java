package Clases;

import java.time.LocalDate;

class Empleado {
    String dni;
    double salario;
    LocalDate fnac;
    String nombre;
    Empleado encargado;

    int calcularEdad() {
        return LocalDate.now().getYear() - fnac.getYear();
    }

    void asignarEncargado(Empleado encargado) {
        this.encargado = encargado;
    }

    String mostrarInfo() {
        return nombre + ", " + dni;
    }
}