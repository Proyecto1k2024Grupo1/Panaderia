import java.util.ArrayList;
import java.util.List;

class Ingrediente {
    int codIngrediente;
    String nombre;
    String descripcion;
    List<Proveedor> proveedor = new ArrayList<>();

    public Ingrediente(int codIngrediente, String nombre, String descripcion) {
        this.codIngrediente = codIngrediente;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    String mostrarInfo() {
        return nombre;
    }

    public int getCodIngrediente() {
        return codIngrediente;
    }

    public void setCodIngrediente(int codIngrediente) {
        this.codIngrediente = codIngrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Proveedor> getProveedor() {
        return proveedor;
    }

    public void setProveedor(List<Proveedor> proveedor) {
        this.proveedor = proveedor;
    }
}