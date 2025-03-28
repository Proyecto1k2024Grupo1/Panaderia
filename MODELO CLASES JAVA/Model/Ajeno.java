import java.util.ArrayList;
import java.util.List;

class Ajeno extends Producto {
    List<Proveedor> proveedor = new ArrayList<>();

    String mostrarInfo() {
        return nombre;
    }
}
