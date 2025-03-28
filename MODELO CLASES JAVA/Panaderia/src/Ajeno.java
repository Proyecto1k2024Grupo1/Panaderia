import java.util.ArrayList;
import java.util.List;

class Ajeno extends Producto {
    List<Proveedor> proveedor = new ArrayList<>();

    public Ajeno(int codigo, String nombre, String tipo, double precio) {
        super(codigo, nombre, tipo, precio);
    }

    public List<Proveedor> getProveedor() {
        return proveedor;
    }

    public void setProveedor(List<Proveedor> proveedor) {
        this.proveedor = proveedor;
    }

    String mostrarInfo() {
        return nombre;
    }
}