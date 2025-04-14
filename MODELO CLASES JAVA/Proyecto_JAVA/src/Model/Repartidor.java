package Model;

import java.time.LocalDate;

/**
 * Representa a un repartidor de la panadería.
 * Hereda de la clase Empleado e incluye información adicional como la matrícula
 * del vehículo utilizado para las entregas.
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @date 10/04/2025
 */
public class Repartidor extends Empleado {

    /** Matrícula del vehículo utilizado por el repartidor */
    String matricula;

    /**
     * Constructor por defecto. Llama al constructor vacío de la clase Empleado.
     */
    public Repartidor() {
        super();
    }

    /**
     * Constructor que podría asociar un supervisor al repartidor.
     * (Actualmente sin implementación real)
     *
     * @param dniSupervisor DNI del supervisor asignado.
     */
    public Repartidor(String dniSupervisor) {
        // Falta implementación para asociar el supervisor
    }

    /**
     * Método para realizar una entrega a domicilio.
     *
     * @param compra Compra que se va a entregar.
     * @param fecha  Fecha en que se realiza la entrega.
     * @param hora   Hora aproximada de la entrega.
     *
     * (Nota: actualmente no implementado)
     */
    void realizarEntrega(Compra compra, LocalDate fecha, String hora) {
        // Aquí se podría registrar la entrega con los datos proporcionados
    }

    /**
     * Constructor completo para crear un repartidor.
     *
     * @param dni       DNI del repartidor.
     * @param salario   Salario asignado al repartidor.
     * @param fnac      Fecha de nacimiento del repartidor.
     * @param nombre    Nombre del repartidor.
     * @param matricula Matrícula del vehículo asignado al repartidor.
     */
    public Repartidor(String dni, double salario, LocalDate fnac, String nombre, String matricula) {
        super(dni, salario, fnac, nombre);
        this.matricula = matricula;
    }

    /**
     * Obtiene la matrícula del vehículo del repartidor.
     *
     * @return Matrícula del vehículo.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula del vehículo del repartidor.
     *
     * @param matricula Nueva matrícula.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Repartidor{" +
                "matricula='" + matricula + '\'' +
                '}';
    }
}
