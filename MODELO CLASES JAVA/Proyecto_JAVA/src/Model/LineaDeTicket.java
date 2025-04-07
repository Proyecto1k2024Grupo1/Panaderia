package Model;

public class LineaDeTicket {
    Compra compra;
    int numLinea;
    Producto producto;
    int cantidad;

    public LineaDeTicket(int numCompra, int numLinea, int codProducto, int cantidad) {
    }

    void anadirProducto(int cantidad, String producto) {
    }

    double calcularSubtotal(Producto producto) {
        return cantidad * producto.precio;
    }

    public int getNumCompra() {
        return compra.getNumCompra();
    }


    public int getNumLinea() {
        int lineas = compra.getNumLineasActuales();
        lineas++;
        compra.setNumLineasActuales(lineas);
        return lineas;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public void setNumLinea(int numLinea) {
        this.numLinea = numLinea;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}
