package Model;

import java.time.LocalDate;

/**
 * Clase que representa a un panadero, que es un tipo de empleado en la panadería.
 * Los panaderos tienen la responsabilidad de preparar productos específicos y
 * se pueden asignar horarios de trabajo. Además, un panadero puede tener un supervisor.
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @date 10/04/2025
 */
public class Panadero extends Empleado {

    /**
     * Constructor que recibe información básica del panadero.
     * Este constructor inicializa un panadero con su DNI, salario, fecha de nacimiento,
     * nombre y horario de trabajo.
     *
     * @param dni Número de identificación del panadero.
     * @param salario Salario del panadero.
     * @param fnac Fecha de nacimiento del panadero.
     * @param nombre Nombre completo del panadero.
     * @param horario Horario de trabajo del panadero.
     */
    public Panadero(String dni, double salario, LocalDate fnac, String nombre, String horario) {
        super(dni, salario, fnac, nombre);  // Llama al constructor de la clase base Empleado
        // En este caso falta inicializar el atributo 'horario' o implementarlo de alguna manera
    }

    /**
     * Constructor para un panadero con un supervisor.
     * Este constructor inicializa un panadero solo con el DNI del supervisor.
     *
     * @param dniSupervisor Número de identificación del supervisor del panadero.
     */
    public Panadero(String dniSupervisor) {
        super(dniSupervisor);  // Llama al constructor de la clase base con solo el dni
        // Aquí falta definir cómo se maneja la relación con el supervisor.
    }

    /**
     * Método que permite al panadero preparar un producto propio (del tipo 'Propio').
     * Este método se utiliza para que el panadero prepare un producto específico que
     * está relacionado con la categoría de productos "Propios".
     *
     * @param producto El producto del tipo 'Propio' que se va a preparar.
     */
    void prepararProducto(Propio producto) {
        // Aquí puedes definir la lógica para preparar el producto 'Propio'
    }

    /**
     * Constructor básico de la clase Panadero.
     * Este constructor inicializa un panadero con su DNI, salario, fecha de nacimiento y nombre.
     *
     * @param dni Número de identificación del panadero.
     * @param salario Salario del panadero.
     * @param fnac Fecha de nacimiento del panadero.
     * @param nombre Nombre completo del panadero.
     */
    public Panadero(String dni, double salario, LocalDate fnac, String nombre) {
        super(dni, salario, fnac, nombre);  // Llama al constructor de la clase base Empleado
    }
}
