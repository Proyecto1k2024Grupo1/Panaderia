package Menu;

import DAO.ProveedorDAO;
import Model.Proveedor;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProveedorMenu {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ProveedorDAO proveedorDAO = ProveedorDAO.getInstance();

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer
            switch (opcion) {
                case 1:
                    insertarProveedor();
                    break;
                case 2:
                    verProveedores();
                    break;
                case 3:
                    actualizarProveedor();
                    break;
                case 4:
                    eliminarProveedor();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú de Proveedores ---");
        System.out.println("1. Insertar nuevo proveedor");
        System.out.println("2. Ver todos los proveedores");
        System.out.println("3. Actualizar proveedor");
        System.out.println("4. Eliminar proveedor");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static void insertarProveedor() {
        System.out.print("Ingrese el nombre del proveedor: ");
        String nombre = scanner.nextLine();

        Proveedor proveedor = new Proveedor(0, nombre); // El código será generado por la base de datos
        try {
            proveedorDAO.insertProveedor(proveedor);
            System.out.println("Proveedor insertado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar proveedor: " + e.getMessage());
        }
    }

    private static void verProveedores() {
        try {
            List<Proveedor> proveedores = proveedorDAO.getAllProveedores();
            if (proveedores.isEmpty()) {
                System.out.println("No hay proveedores registrados.");
            } else {
                System.out.println("\n--- Proveedores ---");
                for (Proveedor proveedor : proveedores) {
                    System.out.println("ID: " + proveedor.getCodProveedor() + " | Nombre: " + proveedor.getNombre());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener proveedores: " + e.getMessage());
        }
    }

    private static void actualizarProveedor() {
        System.out.print("Ingrese el ID del proveedor a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer
        System.out.print("Ingrese el nuevo nombre del proveedor: ");
        String nombre = scanner.nextLine();

        Proveedor proveedor = new Proveedor(id, nombre);
        try {
            proveedorDAO.updateProveedor(proveedor);
            System.out.println("Proveedor actualizado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar proveedor: " + e.getMessage());
        }
    }

    private static void eliminarProveedor() {
        System.out.print("Ingrese el ID del proveedor a eliminar: ");
        int id = scanner.nextInt();

        try {
            proveedorDAO.deleteProveedorById(id);
            System.out.println("Proveedor eliminado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar proveedor: " + e.getMessage());
        }
    }
}
