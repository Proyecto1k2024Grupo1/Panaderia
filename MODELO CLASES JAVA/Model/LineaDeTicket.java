class LineaDeTicket {
    Compra compra;
    int numLinea;
    Producto producto;
    int cantidad;

    void anadirProducto(int cantidad, String producto) {
    }

    double calcularSubtotal(Producto producto) {
        return cantidad * producto.precio;
    }
}
