package Menu;

import DAO.IngredienteDAO;
import Model.Ingrediente;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
/**
 * Clase que proporciona un menú interactivo para gestionar ingredientes.
 * Permite insertar, visualizar, actualizar y eliminar ingredientes almacenados en la base de datos.
 * @author Vanesa, Silvia, Jessica
 * @version 1.1
 * @date 10/04/2025
 */

public class MenuIngrediente {

    private static final Scanner scanner = new Scanner(System.in);
    private static final IngredienteDAO ingredienteDAO = IngredienteDAO.getInstance();

    /**
     * Muestra el menú principal de gestión de ingredientes.
     * Permite al usuario seleccionar entre las operaciones CRUD disponibles.
     */
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

    /**
     * Inserta un nuevo ingrediente en la base de datos.
     * Solicita al usuario el nombre y la descripción del ingrediente.
     */
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

    /**
     * Muestra por pantalla todos los ingredientes registrados en la base de datos.
     */
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

    /**
     * Actualiza un ingrediente existente.
     * Solicita el código del ingrediente a modificar y los nuevos datos.
     */
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

    /**
     * Elimina un ingrediente de la base de datos a partir de su código.
     */
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

    /**
     * Método principal que lanza el menú de ingredientes.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        mostrarMenu();
    }
}
