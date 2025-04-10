package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un cliente con información personal como nombre, apellidos, dirección y teléfonos.
 * También permite registrar compras y actualizar la dirección del cliente.
 */
public class Cliente {

    // Atributos de la clase Cliente
    private int idCliente;             // Identificador único del cliente
    private String direccion;          // Dirección del cliente
    private String nombre;             // Nombre del cliente
    private String apellido1;          // Primer apellido del cliente
    private String apellido2;          // Segundo apellido del cliente
    private List<String> telefonos;    // Lista de teléfonos asociados al cliente

    /**
     * Constructor vacío para la clase Cliente.
     * Se usa principalmente para crear instancias sin parámetros o para pruebas.
     */
    public Cliente() {
        this.telefonos = new ArrayList<>();
    }

    /**
     * Constructor para crear un nuevo cliente con los detalles proporcionados.
     *
     * @param idCliente Identificador único del cliente.
     * @param direccion Dirección del cliente.
     * @param nombre Nombre del cliente.
     * @param apellido1 Primer apellido del cliente.
     * @param apellido2 Segundo apellido del cliente.
     */
    public Cliente(int idCliente, String direccion, String nombre, String apellido1, String apellido2) {
        this.idCliente = idCliente;
        this.direccion = direccion;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefonos = new ArrayList<>();
    }

    /**
     * Constructor para crear un nuevo cliente con todos los detalles, incluyendo una lista de teléfonos.
     *
     * @param idCliente Identificador único del cliente.
     * @param direccion Dirección del cliente.
     * @param nombre Nombre del cliente.
     * @param apellido1 Primer apellido del cliente.
     * @param apellido2 Segundo apellido del cliente.
     * @param telefonos Lista de teléfonos asociados al cliente.
     */
    public Cliente(int idCliente, String direccion, String nombre, String apellido1, String apellido2, List<String> telefonos) {
        this.idCliente = idCliente;
        this.direccion = direccion;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefonos = telefonos;
    }

    /**
     * Registra una compra realizada por el cliente.
     *
     * @param compra Objeto de tipo Compra que representa la compra realizada por el cliente.
     */
    void registrarCompra(Compra compra) {
        // Implementar la lógica para registrar una compra.
    }

    /**
     * Actualiza la dirección del cliente.
     *
     * @param nuevaDireccion Nueva dirección para el cliente.
     */
    void actualizarDireccion(String nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }

    /**
     * Obtiene el nombre completo del cliente (nombre + apellidos).
     *
     * @return Nombre completo del cliente.
     */
    String obtenerNombreCompleto() {
        return nombre + " " + apellido1 + " " + apellido2;
    }

    // Métodos getters y setters

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<String> telefonos) {
        this.telefonos = telefonos;
    }
}
