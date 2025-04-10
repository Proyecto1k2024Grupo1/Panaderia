package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un producto de tipo "Ajeno" que extiende la clase Producto.
 * Un producto ajeno tiene un nombre, tipo, precio y una lista de proveedores que lo suministran.
 */
public class Ajeno extends Producto {

    // Lista de proveedores del producto ajeno
    private List<Proveedor> proveedor = new ArrayList<>();

    /**
     * Constructor para crear un nuevo producto ajeno.
     *
     * @param codigo Código único del producto.
     * @param nombre Nombre del producto.
     * @param tipo Tipo del producto (ejemplo: dulce, salado, etc.).
     * @param precio Precio del producto.
     */
    public Ajeno(int codigo, String nombre, String tipo, double precio) {
        super(codigo, nombre, tipo, precio); // Llamada al constructor de la clase padre (Producto)
    }

    /**
     * Obtiene la lista de proveedores del producto ajeno.
     *
     * @return Lista de proveedores del producto ajeno.
     */
    public List<Proveedor> getProveedor() {
        return proveedor;
    }

    /**
     * Establece la lista de proveedores del producto ajeno.
     *
     * @param proveedor Lista de proveedores a asignar al producto ajeno.
     */
    public void setProveedor(List<Proveedor> proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * Muestra información básica sobre el producto ajeno, en este caso solo el nombre.
     *
     * @return Nombre del producto ajeno.
     */
    public String mostrarInfo() {
        // Se podría extender para mostrar más detalles sobre el producto.
        return nombre;
    }

}
