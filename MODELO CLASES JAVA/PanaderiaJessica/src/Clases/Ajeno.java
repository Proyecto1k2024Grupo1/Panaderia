package Clases;

import java.util.ArrayList;
import java.util.List;

public class Ajeno extends Producto {
    int codigo;
    List<Proveedor> proveedor = new ArrayList<>();

    public Ajeno(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    String mostrarInfo() {
        return nombre;
    }
}