package Model;

import java.util.ArrayList;
import java.util.List;

public class Propio extends Producto {
    List<Panadero> proveedor = new ArrayList<>();
    List<Ingrediente> ingredientes = new ArrayList<>();

    public Propio(int codigo, String nombre, String tipo, double precio) {
        super(codigo, nombre, tipo, precio);
    }

    public List<Panadero> getProveedor() {
        return proveedor;
    }

    public void setProveedor(List<Panadero> proveedor) {
        this.proveedor = proveedor;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
