package Model;

import java.time.LocalDate;

/**
 * Representa a un repartidor de la panadería.
 * Hereda de la clase Empleado e incluye información adicional como la matrícula
 * del vehículo utilizado para las entregas.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @since 10/04/2025
 */
public class Repartidor extends Empleado {

    /** Matrícula del vehículo utilizado por el repartidor */
    String matricula;

    /**
     * Constructor por defecto. Llama al constructor vacío de la clase Empleado.
     */
    public Repartidor() {
        super();  // Llama al constructor vacío de la clase base Empleado
    }

    /**
     * Constructor que podría asociar un supervisor al repartidor.
     * (Actualmente sin implementación real)
     *
     * @param dniSupervisor DNI del supervisor asignado al repartidor.
     */
    public Repartidor(String dniSupervisor) {
        // Falta implementación para asociar el supervisor
    }

    /**
     * Método para realizar una entrega a domicilio.
     * Este método permite registrar la entrega de una compra en una fecha y hora específicas.
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
     * Este constructor permite inicializar un repartidor con su DNI, salario, fecha de nacimiento,
     * nombre y matrícula del vehículo.
     *
     * @param dni       DNI del repartidor.
     * @param salario   Salario asignado al repartidor.
     * @param fnac      Fecha de nacimiento del repartidor.
     * @param nombre    Nombre del repartidor.
     * @param matricula Matrícula del vehículo asignado al repartidor.
     */
    public Repartidor(String dni, double salario, LocalDate fnac, String nombre, String matricula) {
        super(dni, salario, fnac, nombre);  // Llama al constructor de la clase base Empleado
        this.matricula = matricula;  // Inicializa la matrícula del vehículo
    }

    /**
     * Obtiene la matrícula del vehículo del repartidor.
     * Este método devuelve la matrícula asignada al vehículo del repartidor.
     *
     * @return Matrícula del vehículo.
     */
    public String getMatricula() {
        return matricula;  // Devuelve la matrícula del vehículo
    }

    /**
     * Establece la matrícula del vehículo del repartidor.
     * Este método permite modificar la matrícula asignada al repartidor.
     *
     * @param matricula Nueva matrícula del vehículo.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;  // Establece la nueva matrícula
    }

    @Override
    public String toString() {
        return "Repartidor{" +
                "matricula='" + matricula + '\'' +
                '}';  // Devuelve una representación en cadena del repartidor
    }
}
