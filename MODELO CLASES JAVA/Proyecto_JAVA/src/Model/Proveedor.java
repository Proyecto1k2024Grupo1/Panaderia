package Model;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {
    int codProveedor;
    String nombre;
    List<Producto> productosAjenos = new ArrayList<>();

    void registrarSuministro(Ajeno ajeno) {
    }

    void registrarVenta(Ingrediente ingrediente) {
    }


    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Proveedor(int codProveedor, String nombre) {
        this.codProveedor = codProveedor;
        this.nombre = nombre;
    }
}
