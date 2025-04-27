package Menu;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Clase que representa el menú principal del sistema.
 * Desde este menú se puede acceder a los distintos módulos: Cliente, Compra, Empleado, Producto, Proveedor e Ingrediente.
 * Cada opción redirige al submenú correspondiente para gestionar esa sección del sistema.
 *
 * @author Vanesa, Silvia, Jessica
 * @version 1.2
 * @since 10/04/2025
 */
public class MenuPrincipal {

    /**
     * Método principal que lanza el menú principal del sistema.
     * Permite al usuario navegar entre los distintos submenús según su elección.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     * @throws SQLException Si ocurre algún error en la comunicación con la base de datos.
     */
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {
            // Mostrar las opciones del menú principal
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Cliente");
            System.out.println("2. Compra");
            System.out.println("3. Empleado");
            System.out.println("4. Producto");
            System.out.println("5. Proveedor");
            System.out.println("6. Ingrediente");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            // Redirigir al submenú correspondiente
            switch (opcion) {
                case 1:
                    MenuCliente.main(null); // Ir al menú de clientes
                    break;
                case 2:
                    MenuCompra.main(null); // Ir al menú de compras
                    break;
                case 3:
                    MenuEmpleado.main(null); // Ir al menú de empleados
                    break;
                case 4:
                    MenuProducto.main(null); // Ir al menú de productos
                    break;
                case 5:
                    MenuProveedor.main(null); // Ir al menú de proveedores
                    break;
                case 6:
                    MenuIngrediente.main(null); // Ir al menú de ingredientes
                    break;
                case 7:
                    System.out.println("Saliendo del sistema..."); // Salida del programa
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo."); // Validación
            }
        }

        scanner.close(); // Cerrar el scanner al finalizar
    }
}
