/**
 * 
 */
public class Producto {

    /**
     * Default constructor
     */
    public Producto() {
    }

    /**
     * 
     */
    private int codigo;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private enum tipo{
        SALADO, DULCE, AGRIDULCE
    };

    /**
     * 
     */
    private double precio;

    /**
     * @return
     */
    public double calcularImpuesto() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @param descuento
     */
    public void aplicarDescuento(Double descuento) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String mostrarInfo() {
        // TODO implement here
        return "";
    }

}