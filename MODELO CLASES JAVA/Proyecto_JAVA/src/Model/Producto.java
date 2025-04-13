package Model;

/**
 * Clase que representa un producto en el sistema.
 * Un producto tiene un código único, un nombre, un tipo y un precio.
 * Además, se pueden calcular impuestos sobre el precio y aplicar descuentos.
 */
public class Producto {
    int codigo;     // Código único del producto
    String nombre;  // Nombre del producto
    String tipo;    // Tipo de producto (por ejemplo, dulce, salado, etc.)
    double precio;  // Precio del producto

    /**
     * Constructor que inicializa un producto con los valores proporcionados.
     *
     * @param codigo Código único del producto.
     * @param nombre Nombre del producto.
     * @param tipo Tipo de producto (por ejemplo, dulce, salado, etc.).
     * @param precio Precio del producto.
     */
    public Producto(int codigo, String nombre, String tipo, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public Producto(int codProducto) {
        this.codigo = codProducto;
    }

    /**
     * Devuelve el código único del producto.
     *
     * @return Código del producto.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Establece el código único del producto.
     *
     * @param codigo Código del producto.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre Nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el tipo de producto.
     *
     * @return Tipo de producto.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo del producto.
     *
     * @param tipo Tipo del producto.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve el precio del producto.
     *
     * @return Precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio Precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Calcula el impuesto para el producto.
     * Este método calcula un impuesto sobre el precio del producto usando una tasa de IVA del 21%.
     *
     * @return El monto del impuesto calculado.
     */
    double calcularImpuesto() {
        final double tasaImpuesto = 0.21;  // 21% de IVA, por ejemplo
        return precio * tasaImpuesto;
    }

    /**
     * Aplica un descuento al precio del producto.
     * El descuento debe estar entre 0 y 100%, y si es válido, se aplica al precio del producto.
     *
     * @param descuento Porcentaje de descuento a aplicar (entre 0 y 100%).
     */
    void aplicarDescuento(double descuento) {
        if (descuento > 0 && descuento <= 100) {
            precio = precio - (precio * descuento / 100);  // Aplica el descuento
        } else {
            System.out.println("Descuento no válido.");
        }
    }
}
