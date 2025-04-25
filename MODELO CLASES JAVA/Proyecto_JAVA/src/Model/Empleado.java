package Model;

import java.time.LocalDate;

/**
 * Clase abstracta que representa a un empleado. Los empleados tienen un DNI, salario, fecha de nacimiento, nombre y pueden tener un encargado.
 * Esta clase también permite calcular la edad del empleado y asignar un encargado.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @since 10/04/2025
 */
public abstract class Empleado {

    private String dni;         // Documento Nacional de Identidad del empleado
    private double salario;     // Salario del empleado
    private LocalDate fnac;     // Fecha de nacimiento del empleado
    private String nombre;      // Nombre del empleado
    private Empleado encargado; // Empleado que es el encargado del actual (puede ser nulo)

    /**
     * Constructor que permite crear un empleado con todos los atributos definidos, incluyendo el encargado.
     *
     * @param dni Documento Nacional de Identidad del empleado.
     * @param salario Salario del empleado.
     * @param fnac Fecha de nacimiento del empleado.
     * @param nombre Nombre del empleado.
     * @param encargado Empleado que es el encargado de este empleado (puede ser null).
     */
    public Empleado(String dni, double salario, LocalDate fnac, String nombre, Empleado encargado) {
        this.dni = dni;
        this.salario = salario;
        this.fnac = fnac;
        this.nombre = nombre;
        this.encargado = encargado;
    }

    /**
     * Constructor que permite crear un empleado solo con el DNI.
     * Este constructor puede ser útil para instanciar un empleado sin los demás detalles.
     *
     * @param dni Documento Nacional de Identidad del empleado.
     */
    public Empleado(String dni) {
        this.dni = dni;
    }
    public Empleado(String dni, String nombre){
        this.dni = dni;
        this.nombre = nombre;
    }
    /**
     * Constructor que permite crear un empleado con todos los atributos, pero sin encargado.
     *
     * @param dni Documento Nacional de Identidad del empleado.
     * @param salario Salario del empleado.
     * @param fnac Fecha de nacimiento del empleado.
     * @param nombre Nombre del empleado.
     */
    public Empleado(String dni, double salario, LocalDate fnac, String nombre) {
        this.dni = dni;
        this.salario = salario;
        this.fnac = fnac;
        this.nombre = nombre;
    }

    /**
     * Constructor vacío que permite crear un empleado sin valores iniciales.
     * Este constructor puede ser útil para la creación de instancias vacías que se completarán más tarde.
     */
    public Empleado() {
    }

    /**
     * Método para calcular la edad del empleado basado en su fecha de nacimiento.
     *
     * @return La edad del empleado.
     */
    int calcularEdad() {
        return LocalDate.now().getYear() - fnac.getYear();  // Calcula la edad restando el año de nacimiento del año actual
    }

    /**
     * Método para asignar un encargado a este empleado.
     *
     * @param encargado El empleado que será asignado como encargado.
     */
    void asignarEncargado(Empleado encargado) {
        this.encargado = encargado;  // Asigna un nuevo encargado al empleado
    }

    /**
     * Método para mostrar información básica del empleado, como su nombre y DNI.
     *
     * @return Cadena que contiene el nombre y DNI del empleado.
     */
    String mostrarInfo() {
        return nombre + ", " + dni;  // Devuelve una cadena con el nombre y el DNI del empleado
    }

    // Métodos getter y setter para cada atributo

    /**
     * Obtiene el nombre del empleado.
     *
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;  // Devuelve el nombre del empleado
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre El nombre del empleado a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;  // Establece el nombre del empleado
    }

    /**
     * Obtiene la fecha de nacimiento del empleado.
     *
     * @return La fecha de nacimiento del empleado.
     */
    public LocalDate getFnac() {
        return fnac;  // Devuelve la fecha de nacimiento del empleado
    }

    /**
     * Establece la fecha de nacimiento del empleado.
     *
     * @param fnac La fecha de nacimiento del empleado a establecer.
     */
    public void setFnac(LocalDate fnac) {
        this.fnac = fnac;  // Establece la fecha de nacimiento del empleado
    }

    /**
     * Obtiene el salario del empleado.
     *
     * @return El salario del empleado.
     */
    public double getSalario() {
        return salario;  // Devuelve el salario del empleado
    }

    /**
     * Establece el salario del empleado.
     *
     * @param salario El salario del empleado a establecer.
     */
    public void setSalario(double salario) {
        this.salario = salario;  // Establece el salario del empleado
    }

    /**
     * Obtiene el DNI del empleado.
     *
     * @return El DNI del empleado.
     */
    public String getDni() {
        return dni;  // Devuelve el DNI del empleado
    }

    /**
     * Establece el DNI del empleado.
     *
     * @param dni El DNI del empleado a establecer.
     */
    public void setDni(String dni) {
        this.dni = dni;  // Establece el DNI del empleado
    }

    /**
     * Obtiene el encargado de este empleado.
     *
     * @return El empleado encargado de este empleado.
     */
    public Empleado getEncargado() {
        return encargado;  // Devuelve el encargado de este empleado
    }

    /**
     * Establece el encargado de este empleado.
     *
     * @param encargado El encargado del empleado a establecer.
     */
    public void setEncargado(Empleado encargado) {
        this.encargado = encargado;  // Establece el encargado del empleado
    }

    /**
     * Representa al empleado como una cadena de texto.
     *
     * @return Una representación en forma de cadena del empleado.
     */
    @Override
    public String toString() {
        return "Empleado{" +
                "dni='" + dni + '\'' +
                ", salario=" + salario +
                ", fnac=" + fnac +
                ", nombre='" + nombre + '\'' +
                ", encargado=" + encargado +
                '}';
    }
}
