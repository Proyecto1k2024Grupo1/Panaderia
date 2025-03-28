import java.util.ArrayList;
import java.util.List;

class Proveedor {
    int codProveedor;
    String nombre;
    List<Producto> productosAjenos = new ArrayList<>();

    public Proveedor(int codProveedor, String nombre) {
        this.codProveedor = codProveedor;
        this.nombre = nombre;
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

    public List<Producto> getProductosAjenos() {
        return productosAjenos;
    }

    public void setProductosAjenos(List<Producto> productosAjenos) {
        this.productosAjenos = productosAjenos;
    }

    void registrarSuministro(Ajeno ajeno) {
    }

    void registrarVenta(Ingrediente ingrediente) {
    }
}