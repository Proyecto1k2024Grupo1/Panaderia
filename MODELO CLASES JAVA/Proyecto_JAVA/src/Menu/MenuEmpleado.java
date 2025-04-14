package Menu;

import java.sql.SQLException;
import java.util.Scanner;
/**
 * Clase que representa el menú principal para gestionar los distintos tipos de empleados del sistema.
 * Permite acceder a los submenús correspondientes a Repartidor, Panadero y Dependiente.
 * @author Vanesa, Silvia, Jessica
 * @version 1.1
 * @date 10/04/2025
 */

public class MenuEmpleado {

    /** Scanner para la entrada de datos por consola */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Método principal que ejecuta el menú de gestión de empleados.
     * Permite al usuario acceder a submenús específicos o salir del sistema.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     * @throws SQLException Si ocurre un error en las operaciones con la base de datos.
     */
    public static void main(String[] args) throws SQLException {
        int option;
        do {
            System.out.println("\n----- Menú Empleado -----");
            System.out.println("1. Menú Repartidor");
            System.out.println("2. Menú Panadero");
            System.out.println("3. Menú Dependiente");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    MenuRepartidor.main(args); // Llamamos al menú de repartidor
                    break;
                case 2:
                    MenuPanadero.main(args); // Llamamos al menú de panadero
                    break;
                case 3:
                    MenuDependiente.main(args); // Llamamos al menú de dependiente
                    break;
                case 4:
                    System.out.println("Saliendo del menú empleado...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo nuevamente.");
            }
        } while (option != 4);
    }
}
