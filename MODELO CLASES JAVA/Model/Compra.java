import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 
 */
public class Compra {

    /**
     * Default constructor
     */
    public Compra() {
    }

    /**
     * 
     */
    private int numCompra;

    /**
     * 
     */
    private LocalDate fecha;

    /**
     * 
     */
    private int idCliente;

    /**
     * 
     */
    private String dniDependiente;

    /**
     * 
     */
    private double descuentoDependiente;

    /**
     * 
     */
    private String fechaDependiente;

    /**
     * 
     */
    private String dniRepartidor;

    /**
     * 
     */
    private String fechaRepartidor;

    /**
     * 
     */
    private LocalTime horaRepartidor;

    /**
     * @param linea
     */
    public void registrarLinea(Linea_De_Ticket linea) {
        // TODO implement here
    }

    /**
     * @return
     */
    public double calcularTotal() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @param cliente
     */
    public void asociarCliente(Cliente cliente) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String generarFactura() {
        // TODO implement here
        return "";
    }

}