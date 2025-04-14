package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un producto elaborado por panaderos de la panadería.
 * Hereda de la clase Producto e incluye una lista de panaderos (proveedores internos)
 * y los ingredientes utilizados para su elaboración.
 */
public class Propio extends Producto {

    /** Lista de panaderos responsables de la elaboración del producto */
    List<Panadero> proveedor = new ArrayList<>();

    /** Lista de ingredientes utilizados en el producto */
    List<Ingrediente> ingredientes = new ArrayList<>();

    /**
     * Constructor de la clase Propio.
     *
     * @param codigo  Código identificador del producto.
     * @param nombre  Nombre del producto.
     * @param tipo    Tipo de producto (por ejemplo: dulce, salado, etc.).
     * @param precio  Precio del producto.
     */
    public Propio(int codigo, String nombre, String tipo, double precio) {
        super(codigo, nombre, tipo, precio);
    }

    /**
     * Obtiene la lista de panaderos que elaboran el producto.
     *
     * @return Lista de panaderos.
     */
    public List<Panadero> getProveedor() {
        return proveedor;
    }

    /**
     * Establece la lista de panaderos que elaboran el producto.
     *
     * @param proveedor Lista de panaderos.
     */
    public void setProveedor(List<Panadero> proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * Obtiene la lista de ingredientes utilizados en el producto.
     *
     * @return Lista de ingredientes.
     */
    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    /**
     * Establece la lista de ingredientes utilizados en el producto.
     *
     * @param ingredientes Lista de ingredientes.
     */
    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "Propio{" +
                "proveedor=" + proveedor +
                ", ingredientes=" + ingredientes +
                ", codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                '}';
    }
}
