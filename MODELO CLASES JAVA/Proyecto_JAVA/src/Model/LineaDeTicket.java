package Model;

/**
 * Clase que representa una línea de ticket dentro de una compra.
 * Cada línea de ticket contiene información sobre un producto comprado,
 * la cantidad de productos y el número de línea dentro del ticket de compra.
 * Esta clase también permite calcular el subtotal de la línea, así como
 * gestionar la relación con la compra y el producto correspondiente.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @since 10/04/2025
 */
public class LineaDeTicket {
    private Compra compra;    // La compra a la que pertenece esta línea de ticket
    private int numLinea;     // Número de línea dentro del ticket
    private Producto producto; // El producto que se ha comprado
    private int cantidad;     // Cantidad del producto comprado

    /**
     * Constructor que inicializa los atributos básicos de la línea de ticket.
     * Este constructor permite asociar una compra, un producto y una cantidad
     * a la línea de ticket, además de determinar el número de línea dentro
     * del ticket de compra.
     *
     * @param compra   La compra a la que pertenece esta línea de ticket.
     * @param producto El producto comprado.
     * @param cantidad La cantidad de productos comprados.
     * @param numLinea El número de línea dentro del ticket.
     */
    public LineaDeTicket(Compra compra, Producto producto, int cantidad, int numLinea) {
        this.compra = compra;
        this.producto = producto;
        this.cantidad = cantidad;
        this.numLinea = numLinea;
        compra.setNumLineasActuales(compra.getNumLineasActuales() + 1); // Incrementamos el número de líneas en la compra
    }

    /**
     * Calcula el subtotal para esta línea de ticket.
     * El subtotal se calcula multiplicando la cantidad de productos por el
     * precio unitario del producto.
     *
     * @return Subtotal calculado.
     */
    public double calcularSubtotal() {
        return cantidad * producto.getPrecio();  // Calcula el subtotal multiplicando cantidad por el precio
    }

    /**
     * Devuelve el número de la compra a la que pertenece esta línea de ticket.
     * Este método permite obtener el número de la compra asociada a la línea de ticket.
     *
     * @return Número de la compra.
     */
    public int getNumCompra() {
        return compra.getNumCompra();  // Devuelve el número de la compra asociada
    }

    /**
     * Devuelve el número de línea para esta línea de ticket.
     *
     * @return Número de la línea.
     */
    public int getNumLinea() {
        return numLinea;  // Devuelve el número de línea calculado
    }

    /**
     * Devuelve el precio total de la línea de ticket.
     * El precio se calcula multiplicando el precio unitario del producto por la cantidad comprada.
     *
     * @return El precio total de la línea de ticket.
     */
    public double getPrecio() {
        return producto.getPrecio() * cantidad;  // Devuelve el precio del producto multiplicado por la cantidad
    }

    // Getters y setters

    /**
     * Obtiene la compra asociada a esta línea de ticket.
     *
     * @return La compra asociada.
     */
    public Compra getCompra() {
        return compra;
    }

    /**
     * Establece la compra asociada a esta línea de ticket.
     *
     * @param compra La compra a asociar.
     */
    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    /**
     * Obtiene el producto asociado a esta línea de ticket.
     *
     * @return El producto asociado.
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece el producto asociado a esta línea de ticket.
     *
     * @param producto El producto a asociar.
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Obtiene la cantidad del producto en esta línea de ticket.
     *
     * @return La cantidad de productos.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de productos en esta línea de ticket.
     *
     * @param cantidad La cantidad de productos a establecer.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
