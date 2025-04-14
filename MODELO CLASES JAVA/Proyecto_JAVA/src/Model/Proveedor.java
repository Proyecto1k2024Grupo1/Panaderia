package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un proveedor externo que suministra productos ajenos e ingredientes
 * a la panadería.
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @date 10/04/2025
 */
public class Proveedor {

    /** Código único del proveedor */
    int codProveedor;

    /** Nombre del proveedor */
    String nombre;

    /** Lista de productos ajenos suministrados por el proveedor */
    List<Producto> productosAjenos = new ArrayList<>();

    /**
     * Constructor de la clase Proveedor.
     *
     * @param codProveedor Código identificador del proveedor.
     * @param nombre       Nombre del proveedor.
     */
    public Proveedor(int codProveedor, String nombre) {
        this.codProveedor = codProveedor;
        this.nombre = nombre;
    }

    /**
     * Registra el suministro de un producto ajeno por parte del proveedor.
     *
     * @param ajeno Producto ajeno que ha sido suministrado.
     *
     * (Nota: actualmente el método no tiene implementación)
     */
    void registrarSuministro(Ajeno ajeno) {
        // Aquí se podría agregar el producto ajeno a la lista, o registrar una acción.
    }

    /**
     * Registra la venta de un ingrediente al negocio por parte del proveedor.
     *
     * @param ingrediente Ingrediente que ha sido vendido.
     *
     * (Nota: actualmente el método no tiene implementación)
     */
    void registrarVenta(Ingrediente ingrediente) {
        // Aquí se podría registrar el ingrediente vendido, si se lleva registro.
    }

    /**
     * Obtiene el código del proveedor.
     *
     * @return Código del proveedor.
     */
    public int getCodProveedor() {
        return codProveedor;
    }

    /**
     * Establece el código del proveedor.
     *
     * @param codProveedor Nuevo código para el proveedor.
     */
    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    /**
     * Obtiene el nombre del proveedor.
     *
     * @return Nombre del proveedor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del proveedor.
     *
     * @param nombre Nuevo nombre del proveedor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
