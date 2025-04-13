package Model;

import java.time.LocalDate;

/**
 * Representa a un dependiente, que es un tipo de empleado con un horario específico.
 * Los dependientes pueden atender a los clientes y aplicar descuentos en las compras.
 */
public class Dependiente extends Empleado {

    private String horario;  // Horario de trabajo del dependiente

    /**
     * Constructor de la clase Dependiente, que recibe todos los parámetros necesarios
     * para crear un nuevo dependiente.
     *
     * @param dni Documento Nacional de Identidad del dependiente.
     * @param salario Salario del dependiente.
     * @param fnac Fecha de nacimiento del dependiente.
     * @param nombre Nombre del dependiente.
     * @param horario Horario de trabajo del dependiente.
     */
    public Dependiente(String dni, double salario, LocalDate fnac, String nombre, String horario) {
        super(dni, salario, fnac, nombre);  // Llama al constructor de la clase base Empleado
        this.horario = horario;  // Asigna el horario de trabajo
    }

    /**
     * Constructor vacío para la clase Dependiente, utilizado principalmente para inicializar el objeto sin parámetros.
     */
    public Dependiente() {

    }

    /**
     * Constructor que permite crear un dependiente con un DNI, pero sin la información completa.
     * Este constructor puede ser útil en ciertas situaciones donde solo se necesita el DNI.
     *
     * @param dni Documento Nacional de Identidad del dependiente.
     */
    public Dependiente(String dni) {
    }

    /**
     * Constructor alternativo que permite crear un dependiente con información adicional.
     * Este constructor no está completamente implementado.
     *
     * @param dni Documento Nacional de Identidad del dependiente.
     * @param salario Salario del dependiente.
     * @param fnac Fecha de nacimiento del dependiente.
     * @param nombre Nombre del dependiente.
     * @param encargado Nombre del encargado del dependiente.
     * @param dependiente Instancia de un dependiente (posiblemente para crear una relación con otro dependiente).
     */
    public Dependiente(String dni, double salario, LocalDate fnac, String nombre, String encargado, Dependiente dependiente) {
    }

    // Métodos getters y setters

    public String getHorario() {
        return horario;  // Devuelve el horario de trabajo del dependiente
    }

    public void setHorario(String horario) {
        this.horario = horario;  // Asigna un nuevo horario al dependiente
    }

    /**
     * Método que simula la atención de un cliente por parte del dependiente.
     * Este método está vacío, pero podría ser implementado para registrar la interacción con el cliente.
     *
     * @param cliente Cliente que será atendido.
     */
    void atenderCliente(Cliente cliente) {
    }

    /**
     * Método para aplicar un descuento a una compra realizada por un cliente.
     * Este método podría ser implementado para modificar el total de la compra según el descuento aplicado.
     *
     * @param compra Objeto de la clase Compra al que se le aplicará el descuento.
     * @param descuento Valor del descuento a aplicar.
     */
    void aplicarDescuento(Compra compra, double descuento) {
    }
}
