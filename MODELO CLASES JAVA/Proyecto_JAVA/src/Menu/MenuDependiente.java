package Menu;

import java.util.Scanner;
import DAO.DependienteDAO;
import Model.Dependiente;

public class MenuDependiente {
    private static Scanner scanner = new Scanner(System.in);
    private static DependienteDAO dependienteDAO = DependienteDAO.getInstance();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Insertar dependiente");
            System.out.println("2. Actualizar dependiente");
            System.out.println("3. Eliminar dependiente");
            System.out.println("4. Ver dependientes");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

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
                    verDependientes();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

    private static void insertarDependiente() {
        try {
            System.out.print("Introduce el DNI del dependiente: ");
            String dni = scanner.nextLine();

            System.out.print("Introduce el salario: ");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("Introduce la fecha de nacimiento (YYYY-MM-DD): ");
            String fnac = scanner.nextLine();

            System.out.print("Introduce el nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Introduce el horario: ");
            String horario = scanner.nextLine(); // Pide el horario

            Dependiente dependiente = new Dependiente(dni, salario, java.time.LocalDate.parse(fnac), nombre, horario);
            dependienteDAO.insertDependiente(dependiente);
            System.out.println("Dependiente insertado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar dependiente: " + e.getMessage());
        }
    }

    private static void actualizarDependiente() {
        try {
            System.out.print("Introduce el DNI del dependiente a actualizar: ");
            String dni = scanner.nextLine();

            Dependiente dependiente = dependienteDAO.getDependienteByDni(dni);
            if (dependiente == null) {
                System.out.println("No se encontró el dependiente con el DNI proporcionado.");
                return;
            }

            System.out.print("Introduce el nuevo salario: ");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("Introduce la nueva fecha de nacimiento (YYYY-MM-DD): ");
            String fnac = scanner.nextLine();

            System.out.print("Introduce el nuevo nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Introduce el nuevo horario: ");
            String horario = scanner.nextLine(); // Pide el nuevo horario

            dependiente.setSalario(salario);
            dependiente.setFnac(java.time.LocalDate.parse(fnac));
            dependiente.setNombre(nombre);
            dependiente.setHorario(horario);  // Actualiza el horario

            dependienteDAO.updateDependiente(dependiente);
            System.out.println("Dependiente actualizado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar dependiente: " + e.getMessage());
        }
    }

    private static void eliminarDependiente() {
        try {
            System.out.print("Introduce el DNI del dependiente a eliminar: ");
            String dni = scanner.nextLine();

            dependienteDAO.deleteDependienteByDni(dni);
            System.out.println("Dependiente eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar dependiente: " + e.getMessage());
        }
    }

    private static void verDependientes() {
        try {
            System.out.println("Dependientes registrados:");
            var dependientes = dependienteDAO.getAllDependiente();
            if (dependientes.isEmpty()) {
                System.out.println("No hay dependientes registrados.");
            } else {
                for (Dependiente dependiente : dependientes) {
                    System.out.println(dependiente);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al obtener dependientes: " + e.getMessage());
        }
    }
}
