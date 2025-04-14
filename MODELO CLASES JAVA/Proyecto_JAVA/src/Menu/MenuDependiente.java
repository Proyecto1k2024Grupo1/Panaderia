package Menu;

import java.util.Scanner;
import DAO.DependienteDAO;
import Model.Dependiente;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Vanesa, Silvia, Jessica
 * @version 1.1
 * @date 10/04/2025
 */

public class MenuDependiente {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DependienteDAO dependienteDAO = DependienteDAO.getInstance();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n----- Menú Dependiente -----");
            System.out.println("1. Insertar dependiente");
            System.out.println("2. Actualizar dependiente");
            System.out.println("3. Eliminar dependiente");
            System.out.println("4. Ver todos los dependientes");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    insertarDependiente();
                    break;
                case 2:
                    actualizarDependiente();
                    break;
                case 3:
                    eliminarDependiente();
                    break;
                case 4:
                    verTodosDependientes();
                    break;
                case 5:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 5);
    }

    private static void insertarDependiente() {
        try {
            System.out.print("Introduce el DNI del dependiente: ");
            String dni = scanner.nextLine();

            System.out.print("Introduce el salario: ");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // Limpiar buffer

            System.out.print("Introduce el nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Introduce la fecha de nacimiento (yyyy-mm-dd): ");
            String fnac = scanner.nextLine();

            System.out.print("Introduce el horario: ");
            String horario = scanner.nextLine();

            Dependiente dependiente = new Dependiente(dni, salario, java.time.LocalDate.parse(fnac), nombre, horario);
            dependienteDAO.insertDependiente(dependiente);
            System.out.println("Dependiente insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar dependiente: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en los datos proporcionados: " + e.getMessage());
        }
    }

    private static void actualizarDependiente() {
        try {
            System.out.print("Introduce el DNI del dependiente a actualizar: ");
            String dni = scanner.nextLine();

            List<Dependiente> dependientes = dependienteDAO.getAllDependiente();
            Dependiente dependienteEncontrado = null;
            for (Dependiente d : dependientes) {
                if (d.getDni().equals(dni)) {
                    dependienteEncontrado = d;
                    break;
                }
            }

            if (dependienteEncontrado == null) {
                System.out.println("Dependiente no encontrado.");
                return;
            }

            System.out.print("Introduce el nuevo salario: ");
            double salario = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Introduce el nuevo nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Introduce la nueva fecha de nacimiento (yyyy-mm-dd): ");
            String fnac = scanner.nextLine();

            System.out.print("Introduce el nuevo horario: ");
            String horario = scanner.nextLine();

            dependienteEncontrado.setSalario(salario);
            dependienteEncontrado.setNombre(nombre);
            dependienteEncontrado.setFnac(java.time.LocalDate.parse(fnac));
            dependienteEncontrado.setHorario(horario);

            dependienteDAO.updateDependiente(dependienteEncontrado);
            System.out.println("Dependiente actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar dependiente: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en los datos proporcionados: " + e.getMessage());
        }
    }

    private static void eliminarDependiente() {
        try {
            System.out.print("Introduce el DNI del dependiente a eliminar: ");
            String dni = scanner.nextLine();

            dependienteDAO.deleteDependienteByDni(dni);
            System.out.println("Dependiente eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar dependiente: " + e.getMessage());
        }
    }

    private static void verTodosDependientes() {
        try {
            List<Dependiente> dependientes = dependienteDAO.getAllDependiente();
            if (dependientes.isEmpty()) {
                System.out.println("No hay dependientes registrados.");
            } else {
                System.out.println("\nLista de dependientes:");
                for (Dependiente d : dependientes) {
                    System.out.println("DNI: " + d.getDni() + ", Nombre: " + d.getNombre() + ", Salario: " + d.getSalario() + ", Horario: " + d.getHorario());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener dependientes: " + e.getMessage());
        }
    }
}
