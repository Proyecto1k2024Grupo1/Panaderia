import java.time.LocalDate;

class Empleado {
    String dni;
    double salario;
    LocalDate fnac;
    String nombre;
    Empleado encargado;

    public Empleado(String dni, double salario, LocalDate fnac, String nombre) {
        this.dni = dni;
        this.salario = salario;
        this.fnac = fnac;
        this.nombre = nombre;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getFnac() {
        return fnac;
    }

    public void setFnac(LocalDate fnac) {
        this.fnac = fnac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empleado getEncargado() {
        return encargado;
    }

    public void setEncargado(Empleado encargado) {
        this.encargado = encargado;
    }
}