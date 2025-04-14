package Menu;

import DAO.IngredienteDAO;
import Model.Ingrediente;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
/**
 * @author Vanesa, Silvia, Jessica
 * @version 1.1
 * @date 10/04/2025
 */

public class MenuIngrediente {

    private static final Scanner scanner = new Scanner(System.in);
    private static final IngredienteDAO ingredienteDAO = IngredienteDAO.getInstance();

    public static void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n------ Menú Ingredientes ------");
            System.out.println("1. Insertar Ingrediente");
            System.out.println("2. Mostrar Todos los Ingredientes");
            System.out.println("3. Actualizar Ingrediente");
            System.out.println("4. Eliminar Ingrediente");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    insertarIngrediente();
                    break;
                case 2:
                    mostrarTodosIngredientes();
                    break;
                case 3:
                    actualizarIngrediente();
                    break;
                case 4:
                    eliminarIngrediente();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }

    private static void insertarIngrediente() {
        System.out.print("Ingrese el nombre del ingrediente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción del ingrediente: ");
        String descripcion = scanner.nextLine();

        Ingrediente ingrediente = new Ingrediente(0, nombre, descripcion);
        try {
            ingredienteDAO.insertIngrediente(ingrediente);
            System.out.println("Ingrediente insertado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el ingrediente: " + e.getMessage());
        }
    }

    private static void mostrarTodosIngredientes() {
        try {
            List<Ingrediente> ingredientes = ingredienteDAO.getAllIngredientes();
            if (ingredientes.isEmpty()) {
                System.out.println("No hay ingredientes registrados.");
            } else {
                System.out.println("------ Lista de Ingredientes ------");
                for (Ingrediente ingrediente : ingredientes) {
                    System.out.println("Código: " + ingrediente.getCodIngrediente() +
                            " | Nombre: " + ingrediente.getNombre() +
                            " | Descripción: " + ingrediente.getDescripcion());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los ingredientes: " + e.getMessage());
        }
    }

    private static void actualizarIngrediente() {
        System.out.print("Ingrese el código del ingrediente a actualizar: ");
        int codIngrediente = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        System.out.print("Ingrese el nuevo nombre del ingrediente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la nueva descripción del ingrediente: ");
        String descripcion = scanner.nextLine();

        Ingrediente ingrediente = new Ingrediente(codIngrediente, nombre, descripcion);
        try {
            ingredienteDAO.updateIngrediente(ingrediente);
            System.out.println("Ingrediente actualizado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el ingrediente: " + e.getMessage());
        }
    }

    private static void eliminarIngrediente() {
        System.out.print("Ingrese el código del ingrediente a eliminar: ");
        int codIngrediente = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        try {
            ingredienteDAO.deleteIngredienteById(String.valueOf(codIngrediente));
            System.out.println("Ingrediente eliminado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el ingrediente: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        mostrarMenu();
    }
}
