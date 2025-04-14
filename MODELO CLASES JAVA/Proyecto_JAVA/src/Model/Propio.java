package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un producto elaborado por panaderos de la panadería.
 * Hereda de la clase Producto e incluye una lista de panaderos (proveedores internos)
 * y los ingredientes utilizados para su elaboración.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @since 10/04/2025
 */
public class Propio extends Producto {

    /** Lista de panaderos responsables de la elaboración del producto */
    List<Panadero> proveedor = new ArrayList<>();

    /** Lista de ingredientes utilizados en el producto */
    List<Ingrediente> ingredientes = new ArrayList<>();

    /**
     * Constructor de la clase Propio.
     * Este constructor inicializa un producto de tipo "Propio" con su código, nombre, tipo y precio.
     *
     * @param codigo  Código identificador del producto.
     * @param nombre  Nombre del producto.
     * @param tipo    Tipo de producto (por ejemplo: dulce, salado, etc.).
     * @param precio  Precio del producto.
     */
    public Propio(int codigo, String nombre, String tipo, double precio) {
        super(codigo, nombre, tipo, precio);  // Llama al constructor de la clase base Producto
    }

    /**
     * Obtiene la lista de panaderos que elaboran el producto.
     * Esta lista representa los panaderos (proveedores internos) que están encargados de la fabricación del producto.
     *
     * @return Lista de panaderos.
     */
    public List<Panadero> getProveedor() {
        return proveedor;  // Devuelve la lista de panaderos encargados de elaborar el producto
    }

    /**
     * Establece la lista de panaderos que elaboran el producto.
     * Este método permite asignar los panaderos responsables de la elaboración del producto.
     *
     * @param proveedor Lista de panaderos.
     */
    public void setProveedor(List<Panadero> proveedor) {
        this.proveedor = proveedor;  // Establece la lista de panaderos encargados de elaborar el producto
    }

    /**
     * Obtiene la lista de ingredientes utilizados en el producto.
     * Esta lista contiene los ingredientes necesarios para la elaboración del producto "Propio".
     *
     * @return Lista de ingredientes.
     */
    public List<Ingrediente> getIngredientes() {
        return ingredientes;  // Devuelve la lista de ingredientes utilizados en el producto
    }

    /**
     * Establece la lista de ingredientes utilizados en el producto.
     * Este método permite asignar los ingredientes que componen el producto "Propio".
     *
     * @param ingredientes Lista de ingredientes.
     */
    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;  // Establece la lista de ingredientes utilizados en el producto
    }

    /**
     * Método toString que devuelve una representación en cadena de texto del producto "Propio".
     * Incluye información sobre los panaderos responsables y los ingredientes utilizados.
     *
     * @return Cadena con la información del producto.
     */
    @Override
    public String toString() {
        return "Propio{" +
                "proveedor=" + proveedor +  // Muestra los panaderos encargados de la elaboración
                ", ingredientes=" + ingredientes +  // Muestra los ingredientes utilizados en el producto
                ", codigo=" + codigo +  // Muestra el código del producto
                ", nombre='" + nombre + '\'' +  // Muestra el nombre del producto
                ", tipo='" + tipo + '\'' +  // Muestra el tipo del producto
                ", precio=" + precio +  // Muestra el precio del producto
                '}';
    }
}
