package Model;

/**
 * Clase que representa una línea de ticket dentro de una compra.
 * Cada línea de ticket contiene información sobre un producto comprado,
 * la cantidad de productos y el número de línea dentro del ticket de compra.
 * Esta clase también permite calcular el subtotal de la línea, así como
 * gestionar la relación con la compra y el producto correspondiente.
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
     * @param numCompra Número de la compra.
     * @param numLinea Número de línea en el ticket.
     * @param codProducto Código del producto.
     * @param cantidad Cantidad del producto.
     */
    public LineaDeTicket(int numCompra, int numLinea, int codProducto, int cantidad) {
        // Aquí podrías inicializar la compra y el producto si tienes acceso a estos objetos
    }

    /**
     * Añade un producto a la línea de ticket.
     * Este método permite asociar un producto y su cantidad a la línea de ticket.
     * Sin embargo, se debe implementar la lógica para el manejo de los productos.
     *
     * @param cantidad Cantidad de productos a añadir.
     * @param producto Nombre del producto.
     */
    void anadirProducto(int cantidad, String producto) {
        // Aquí puedes implementar la lógica para añadir un producto a la línea de ticket
    }

    /**
     * Calcula el subtotal para esta línea de ticket.
     * El subtotal se calcula multiplicando la cantidad de productos por el
     * precio unitario del producto.
     *
     * @param producto Producto con el cual calcular el subtotal.
     * @return Subtotal calculado.
     */
    double calcularSubtotal(Producto producto) {
        return cantidad * producto.precio;  // Calcula el subtotal multiplicando cantidad por el precio
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
     * El número de línea se calcula en base al número de líneas actuales de la compra,
     * incrementando en uno el valor de las líneas.
     *
     * @return Número de la línea.
     */
    public int getNumLinea() {
        int lineas = compra.getNumLineasActuales();
        lineas++;  // Incrementa el número de líneas
        compra.setNumLineasActuales(lineas);  // Actualiza el número de líneas actuales en la compra
        return lineas;  // Devuelve el número de línea incrementado
    }
}
