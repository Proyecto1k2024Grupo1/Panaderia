package Menu;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuPrincipal {

        public static void main(String[] args) throws SQLException {
            Scanner scanner = new Scanner(System.in);
            int opcion = 0;

            while (opcion != 6) {
                System.out.println("\n--- MENÚ PRINCIPAL ---");
                System.out.println("1. Cliente");
                System.out.println("2. Compra");
                System.out.println("3. Empleado");
                System.out.println("4. Producto");
                System.out.println("5. Proveedor");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        MenuCliente.main(null);
                        break;
                    case 2:
                        MenuCompra.main(null);
                        break;
                    case 3:
                        MenuEmpleado.main(null);
                        break;
                    case 4:
                        MenuProducto.main(null);
                        break;
                    case 5:
                        MenuProveedor.main(null);
                        break;
                    case 6:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            }

            scanner.close();
        }
    }

