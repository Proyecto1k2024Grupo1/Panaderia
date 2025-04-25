package Menu;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Clase que representa el menú principal para gestionar los distintos tipos de empleados del sistema.
 * Permite acceder a los submenús correspondientes a Repartidor, Panadero y Dependiente.
 * Cada opción dirige al usuario a un menú específico según el rol del empleado.
 * Utiliza la entrada estándar para recibir las selecciones del usuario.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.1
 * @since 10/04/2025
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
                    /**
                     * Llama al menú de gestión de repartidores.
                     */
                    MenuRepartidor.main(args);
                    break;
                case 2:
                    /**
                     * Llama al menú de gestión de panaderos.
                     */
                    MenuPanadero.main(args);
                    break;
                case 3:
                    /**
                     * Llama al menú de gestión de dependientes.
                     */
                    MenuDependiente.main(args);
                    break;
                case 4:
                    /**
                     * Finaliza el programa mostrando un mensaje de despedida.
                     */
                    System.out.println("Saliendo del menú empleado...");
                    break;
                default:
                    /**
                     * Muestra un mensaje de error si la opción seleccionada no es válida.
                     */
                    System.out.println("Opción no válida. Inténtelo nuevamente.");
            }
        } while (option != 4);
    }
}
