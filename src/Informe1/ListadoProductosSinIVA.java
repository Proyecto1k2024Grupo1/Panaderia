package Informe1;

public class ListadoProductosSinIVA {

    private ProductoSinIVA[] productos;
    private int contador; // Para llevar el control de cuántos productos se han agregado

    // Constructor
    public ListadoProductosSinIVA(int capacidad) {
        this.productos = new ProductoSinIVA[capacidad]; // Array con capacidad fija
        this.contador = 0; // Iniciar el contador en 0
    }

    // Método para agregar productos al array
    public void agregarProducto(ProductoSinIVA producto) {
        if (contador < productos.length) {
            productos[contador] = producto;
            contador++;
        } else {
            System.out.println("No se puede agregar más productos, el array está lleno.");
        }
    }

    // Método para imprimir listado en formato XML
    public void imprimirListadoXML() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("<productos>");
        for (int i = 0; i < contador; i++) {
            resultado.append(productos[i].toXML());
        }
        resultado.append("</productos>");
        System.out.println(resultado.toString());
    }

    // Método para imprimir listado en formato JSON
    public void imprimirListadoJSON() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("{ \"productos\": [");
        for (int i = 0; i < contador; i++) {
            resultado.append(productos[i].toJSON());
            if (i < contador - 1) {
                resultado.append(", ");
            }
        }
        resultado.append("] }");
        System.out.println(resultado.toString());
    }

    // Método para obtener la lista de productos
    public ProductoSinIVA[] getProductos() {
        return productos;
    }

    // Método para obtener el número de productos agregados
    public int getNumeroDeProductos() {
        return contador;
    }
}
