package Clases;

import java.util.ArrayList;
import java.util.List;

public class Propio extends Producto {
    int codigo;
    List<Panadero> proveedor = new ArrayList<>();
    List<Ingrediente> ingredientes = new ArrayList<>();

    public Propio(List<Panadero> proveedor, List<Ingrediente> ingredientes) {
        this.proveedor = proveedor;
        this.ingredientes = ingredientes;
    }

    public Propio(int codigo) {
        super();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}