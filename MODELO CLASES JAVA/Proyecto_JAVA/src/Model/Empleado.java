package Model;

import java.time.LocalDate;


public abstract class Empleado {
    String dni;
    double salario;
    LocalDate fnac;
    String nombre;
    Empleado encargado;


    public Empleado(String dni, double salario, LocalDate fnac, String nombre, Empleado encargado) {
        this.dni = dni;
        this.salario = salario;
        this.fnac = fnac;
        this.nombre = nombre;
        this.encargado = encargado;
    }

    public Empleado(String dni) {
        this.dni = dni;
    }

    public Empleado(String dni, double salario, LocalDate fnac, String nombre) {
        this.dni = dni;
        this.salario = salario;
        this.fnac = fnac;
        this.nombre = nombre;
    }

    public Empleado() {

    }

    int calcularEdad() {
        return LocalDate.now().getYear() - fnac.getYear();
    }

    void asignarEncargado(Empleado encargado) {
        this.encargado = encargado;
    }

    String mostrarInfo() {
        return nombre + ", " + dni;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFnac() {
        return fnac;
    }

    public void setFnac(LocalDate fnac) {
        this.fnac = fnac;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Empleado getEncargado() {
        return encargado;
    }

    public void setEncargado(Empleado encargado) {
        this.encargado = encargado;
    }
}
