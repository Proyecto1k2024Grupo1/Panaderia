package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un ingrediente. Cada ingrediente tiene un código único, nombre, descripción
 * y una lista de proveedores que suministran ese ingrediente.
 *  @author Vanesa
 *  @author Silvia
 *  @author Jessica
 *  @version 1.0
 *  @date 10/04/2025
 */
public class Ingrediente {

    private int codIngrediente; // Código único para identificar el ingrediente
    private String nombre;      // Nombre del ingrediente
    private String descripcion; // Descripción del ingrediente
    private List<Proveedor> proveedor = new ArrayList<>(); // Lista de proveedores que suministran este ingrediente

    /**
     * Constructor que permite crear un ingrediente con el código, nombre y descripción.
     *
     * @param codIngrediente Código único del ingrediente.
     * @param nombre Nombre del ingrediente.
     * @param descripcion Descripción del ingrediente.
     */
    public Ingrediente(int codIngrediente, String nombre, String descripcion) {
        this.codIngrediente = codIngrediente;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Método que devuelve la información básica del ingrediente.
     *
     * @return Nombre del ingrediente.
     */
    public String mostrarInfo() {
        return nombre;  // Devuelve el nombre del ingrediente
    }

    // Métodos getter y setter para los atributos

    public int getCodIngrediente() {
        return codIngrediente;  // Devuelve el código del ingrediente
    }

    public void setCodIngrediente(int codIngrediente) {
        this.codIngrediente = codIngrediente;  // Establece el código del ingrediente
    }

    public String getNombre() {
        return nombre;  // Devuelve el nombre del ingrediente
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;  // Establece el nombre del ingrediente
    }

    public String getDescripcion() {
        return descripcion;  // Devuelve la descripción del ingrediente
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;  // Establece la descripción del ingrediente
    }

    public List<Proveedor> getProveedor() {
        return proveedor;  // Devuelve la lista de proveedores del ingrediente
    }

    public void setProveedor(List<Proveedor> proveedor) {
        this.proveedor = proveedor;  // Establece la lista de proveedores
    }
}
