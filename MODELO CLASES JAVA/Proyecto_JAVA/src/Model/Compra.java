package Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una compra realizada por un cliente, incluyendo detalles como las líneas de productos,
 * el dependiente que la procesó, el repartidor que la entregó y cualquier descuento aplicado.
 */
public class Compra {

    // Atributos de la clase Compra
    private int numCompra;                  // Número de la compra
    private LocalDate fecha;                 // Fecha de la compra
    private Cliente cliente;                 // Cliente que realiza la compra
    private Dependiente dependiente;         // Dependiente que atendió la compra
    private double descuentoDependiente;     // Descuento otorgado por el dependiente
    private LocalDate fechaDependiente;      // Fecha en la que el dependiente aplicó el descuento
    private Repartidor repartidor;           // Repartidor que entregará la compra
    private LocalDate fechaRepartidor;       // Fecha de la entrega por parte del repartidor
    private LocalTime horaRepartidor;        // Hora en que el repartidor hará la entrega
    private List<LineaDeTicket> lineas;      // Lista de líneas de productos de la compra

    private int numLineasActuales = 0;       // Número de líneas de productos actuales

    /**
     * Constructor vacío para la clase Compra.
     * Se usa principalmente para crear instancias sin parámetros o para pruebas.
     */
    public Compra() {

    }

    /**
     * Registra una nueva línea de ticket en la compra.
     *
     * @param linea Objeto de tipo LineaDeTicket que representa la línea de la compra.
     */
    void registrarLinea(LineaDeTicket linea) {
        lineas.add(linea); // Añade la línea a la lista de líneas de la compra
    }

    /**
     * Calcula el total de la compra sumando el precio de las líneas de ticket.
     * Este método debe ser implementado en función de la lógica de precios.
     *
     * @return El total de la compra.
     */
    double calcularTotal() {
        return 0;  // Este método debe ser implementado según el cálculo real.
    }

    /**
     * Asocia un cliente a la compra.
     *
     * @param cliente Cliente que realiza la compra.
     */
    void asociarCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Constructor para crear una nueva compra especificando el número de compra.
     *
     * @param numCompra Número único de la compra.
     */
    public Compra(int numCompra) {
        this.numCompra = numCompra;
    }

    // Métodos getters y setters

    public int getNumCompra() {
        return numCompra;
    }

    public void setNumCompra(int numCompra) {
        this.numCompra = numCompra;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Dependiente getDependiente() {
        return dependiente;
    }

    public void setDependiente(Dependiente dependiente) {
        this.dependiente = dependiente;
    }

    public double getDescuentoDependiente() {
        return descuentoDependiente;
    }

    public void setDescuentoDependiente(double descuentoDependiente) {
        this.descuentoDependiente = descuentoDependiente;
    }

    public LocalDate getFechaDependiente() {
        return fechaDependiente;
    }

    public void setFechaDependiente(LocalDate fechaDependiente) {
        this.fechaDependiente = fechaDependiente;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public LocalDate getFechaRepartidor() {
        return fechaRepartidor;
    }

    public void setFechaRepartidor(LocalDate fechaRepartidor) {
        this.fechaRepartidor = fechaRepartidor;
    }

    public LocalTime getHoraRepartidor() {
        return horaRepartidor;
    }

    public void setHoraRepartidor(LocalTime horaRepartidor) {
        this.horaRepartidor = horaRepartidor;
    }

    public List<LineaDeTicket> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaDeTicket> lineas) {
        this.lineas = lineas;
    }

    public int getNumLineasActuales() {
        return numLineasActuales;
    }

    public void setNumLineasActuales(int numLineasActuales) {
        this.numLineasActuales = numLineasActuales;
    }
}
