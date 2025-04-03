package Clases;

import java.util.ArrayList;
import java.util.List;

class Ingrediente {
    int codIngrediente;
    String nombre;
    String descripcion;
    List<Proveedor> proveedor = new ArrayList<>();

    String mostrarInfo() {
        return nombre;
    }
}
