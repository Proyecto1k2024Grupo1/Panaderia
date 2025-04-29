package Model;

import DAO.LineaDeTicketDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una compra realizada por un cliente.
 * Contiene información sobre el cliente, el dependiente que atendió la compra,
 * el repartidor que realizó la entrega, y las líneas de la compra.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @since 10/04/2025
 */
public class Compra {

    private int numCompra; // Número único de la compra
    private LocalDate fecha; // Fecha de la compra
    private Cliente cliente; // Cliente que realizó la compra
    private Dependiente dependiente; // Dependiente que atendió la compra
    private double total;
    //Opcionales
    private double descuentoDependiente; // Descuento otorgado por el dependiente
    private LocalDate fechaDependiente; // Fecha en la que se aplicó el descuento
    private Repartidor repartidor; // Repartidor que entregó la compra
    private LocalDate fechaRepartidor; // Fecha en que el repartidor realizó la entrega
    private LocalTime horaRepartidor; // Hora en que el repartidor realizó la entrega

    private List<LineaDeTicket> lineas; // Lista de líneas que componen la compra
    private int numLineasActuales; // Número de líneas registradas en la compra



    /**
     * Constructor de la clase Compra con el número de compra.
     * Inicializa la lista de líneas de la compra y el contador de líneas actuales.
     *
     * @param numCompra Número único de la compra.
     */
    public Compra(int numCompra) {
        lineas = new ArrayList<>(); // Inicializa la lista de líneas de la compra
        numLineasActuales = 0; // Inicializa el número de líneas actuales a 0
        this.numCompra = numCompra;
    }

    /**
     * Constructor vacío de la clase Compra.
     */
    public Compra() {

    }

    /**
     * Constructor de la clase Compra con todos los parámetros necesarios.
     *
     * @param fecha Fecha de la compra.
     * @param numCompra Número único de la compra.
     * @param cliente Cliente que realizó la compra.
     * @param dependiente Dependiente que atendió la compra.
     */
    public Compra(LocalDate fecha, int numCompra, Cliente cliente, Dependiente dependiente, double total) {
        this.fecha = fecha;
        this.numCompra = numCompra;
        this.cliente = cliente;
        this.dependiente = dependiente;
        this.total = total;
        this.lineas = new ArrayList<>();
        numLineasActuales = 0;
    }

    /**
     * Registra una nueva línea en la compra.
     * Incrementa el número de líneas actuales de la compra.
     *
     * @param linea La línea de ticket a registrar.
     */
    public void registrarLinea(LineaDeTicket linea) {
        lineas.add(linea); // Agrega la línea a la lista de líneas
        numLineasActuales++; // Incrementa el número de líneas actuales
    }


    // Getters y setters

    /**
     * Obtiene el número de la compra.
     *
     * @return El número de la compra.
     */
    public int getNumCompra() {
        return numCompra;
    }

    /**
     * Establece el número de la compra.
     *
     * @param numCompra El número de la compra a establecer.
     */
    public void setNumCompra(int numCompra) {

        this.numCompra = numCompra;
    }

    /**
     * Obtiene la fecha de la compra.
     *
     * @return La fecha de la compra.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la compra.
     *
     * @param fecha La fecha de la compra a establecer.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el cliente que realizó la compra.
     *
     * @return El cliente que realizó la compra.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente que realizó la compra.
     *
     * @param cliente El cliente que realizó la compra.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene el dependiente que atendió la compra.
     *
     * @return El dependiente que atendió la compra.
     */
    public Dependiente getDependiente() {
        return dependiente;
    }

    /**
     * Establece el dependiente que atendió la compra.
     *
     * @param dependiente El dependiente que atendió la compra.
     */
    public void setDependiente(Dependiente dependiente) {
        this.dependiente = dependiente;
    }

    /**
     * Obtiene el descuento otorgado por el dependiente.
     *
     * @return El descuento otorgado por el dependiente.
     */
    public double getDescuentoDependiente() {
        return descuentoDependiente;
    }

    /**
     * Establece el descuento otorgado por el dependiente.
     *
     * @param descuentoDependiente El descuento otorgado por el dependiente.
     */
    public void setDescuentoDependiente(double descuentoDependiente) {
        this.descuentoDependiente = descuentoDependiente;
    }

    /**
     * Obtiene la fecha en la que se aplicó el descuento por el dependiente.
     *
     * @return La fecha en la que se aplicó el descuento.
     */
    public LocalDate getFechaDependiente() {
        return fechaDependiente;
    }

    /**
     * Establece la fecha en la que se aplicó el descuento por el dependiente.
     *
     * @param fechaDependiente La fecha en la que se aplicó el descuento.
     */
    public void setFechaDependiente(LocalDate fechaDependiente) {
        this.fechaDependiente = fechaDependiente;
    }

    /**
     * Obtiene el repartidor que entregó la compra.
     *
     * @return El repartidor que entregó la compra.
     */
    public Repartidor getRepartidor() {
        return repartidor;
    }

    /**
     * Establece el repartidor que entregó la compra.
     *
     * @param repartidor El repartidor que entregó la compra.
     */
    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    /**
     * Obtiene la fecha en la que el repartidor realizó la entrega.
     *
     * @return La fecha en la que el repartidor realizó la entrega.
     */
    public LocalDate getFechaRepartidor() {
        return fechaRepartidor;
    }

    /**
     * Establece la fecha en la que el repartidor realizó la entrega.
     *
     * @param fechaRepartidor La fecha en la que el repartidor realizó la entrega.
     */
    public void setFechaRepartidor(LocalDate fechaRepartidor) {
        this.fechaRepartidor = fechaRepartidor;
    }

    /**
     * Obtiene la hora en la que el repartidor realizó la entrega.
     *
     * @return La hora en la que el repartidor realizó la entrega.
     */
    public LocalTime getHoraRepartidor() {
        return horaRepartidor;
    }

    /**
     * Establece la hora en la que el repartidor realizó la entrega.
     *
     * @param horaRepartidor La hora en la que el repartidor realizó la entrega.
     */
    public void setHoraRepartidor(LocalTime horaRepartidor) {
        this.horaRepartidor = horaRepartidor;
    }

    /**
     * Obtiene la lista de líneas de la compra.
     *
     * @return La lista de líneas de la compra.
     */
    public List<LineaDeTicket> getLineas() {
        return lineas;
    }

    /**
     * Establece la lista de líneas de la compra.
     *
     * @param lineas La lista de líneas de la compra.
     */
    public void setLineas(List<LineaDeTicket> lineas) {
        this.lineas = lineas;
    }

    /**
     * Obtiene el número de líneas registradas en la compra.
     *
     * @return El número de líneas registradas en la compra.
     */
    public int getNumLineasActuales() {
        return numLineasActuales;
    }

    /**
     * Establece el número de líneas registradas en la compra.
     *
     * @param numLineasActuales El número de líneas a registrar.
     */
    public void setNumLineasActuales(int numLineasActuales) {
        this.numLineasActuales = numLineasActuales;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
