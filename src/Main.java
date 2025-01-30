import Informe1.ListadoProductosSinIVA;
import Informe1.ProductoSinIVA;

public class Main {
    public static void main(String[] args) {
        // Crear el listado con una capacidad máxima de 5 productos
        ListadoProductosSinIVA listado = new ListadoProductosSinIVA(5);

        // Crear algunos productos
        ProductoSinIVA producto1 = new ProductoSinIVA("Pan", 1.20, 1.00);
        ProductoSinIVA producto2 = new ProductoSinIVA("Baguette", 1.50, 1.25);
        ProductoSinIVA producto3 = new ProductoSinIVA("Croissant", 2.00, 1.70);
        ProductoSinIVA producto4 = new ProductoSinIVA("Torta", 3.00, 2.50);
        ProductoSinIVA producto5 = new ProductoSinIVA("Muffin", 1.80, 1.50);

        // Agregar productos al listado
        listado.agregarProducto(producto1);
        listado.agregarProducto(producto2);
        listado.agregarProducto(producto3);
        listado.agregarProducto(producto4);
        listado.agregarProducto(producto5);

        // Imprimir listado en formato XML
        System.out.println("Listado en formato XML:");
        listado.imprimirListadoXML();

        // Imprimir listado en formato JSON
        System.out.println("\nListado en formato JSON:");
        listado.imprimirListadoJSON();
    }
}
