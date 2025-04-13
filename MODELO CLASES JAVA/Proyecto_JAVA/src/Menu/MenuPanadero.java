package Menu;


import Model.Panadero;
import DAO.PanaderoDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuPanadero {

    private static PanaderoDAO panaderoDAO = PanaderoDAO.getInstance();

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar el menú
            System.out.println("********* Menú Panadero *********");
            System.out.println("1. Agregar panadero");
            System.out.println("2. Mostrar panaderos");
            System.out.println("3. Modificar panadero");
            System.out.println("4. Eliminar panadero");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarPanadero(scanner);
                    break;
                case 2:
                    try {
                        mostrarPanaderos();
                    } catch (SQLException e) {
                        System.out.println("Error al mostrar los panaderos: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        modificarPanadero(scanner);
                    } catch (SQLException e) {
                        System.out.println("Error al modificar el panadero: " + e.getMessage());
                    }
                    break;
                case 4:
                    eliminarPanadero(scanner);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }

        } while (opcion != 5);
    }

    // Método para agregar un panadero
    private static void agregarPanadero(Scanner scanner) throws SQLException {
        System.out.print("Ingrese el DNI del panadero: ");
        String dni = scanner.nextLine();

        System.out.print("Ingrese el nombre del panadero: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el salario del panadero: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese la fecha de nacimiento del panadero (YYYY-MM-DD): ");
        String fechaNacimiento = scanner.nextLine();

        System.out.print("Ingrese el DNI del encargado: ");
        String dniEncargado = scanner.nextLine();

        // Crear un objeto panadero y agregarlo a la base de datos
        Panadero panadero = new Panadero(dni, salario, java.time.LocalDate.parse(fechaNacimiento), nombre);
        // Necesitas obtener el encargado desde su DNI, asumiendo que existe un método para esto
        // panadero.setEncargado(new Empleado(dniEncargado));

        try {
            panaderoDAO.insertPanadero(panadero);
            System.out.println("Panadero agregado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar el panadero: " + e.getMessage());
        }
    }

    // Método para mostrar todos los panaderos
    private static void mostrarPanaderos() throws SQLException {
        List<Panadero> panaderos = panaderoDAO.getAllPanaderos();
        if (panaderos.isEmpty()) {
            System.out.println("No hay panaderos registrados.");
        } else {
            for (Panadero panadero : panaderos) {
                System.out.println(panadero.getNombre() + " - DNI: " + panadero.getDni());
                System.out.println("Salario: " + panadero.getSalario() + " | Fecha de nacimiento: " + panadero.getFnac());
            }
        }
    }

    // Método para modificar un panadero
    private static void modificarPanadero(Scanner scanner) throws SQLException {
        System.out.print("Ingrese el DNI del panadero a modificar: ");
        String dni = scanner.nextLine();

        // Verificar si el panadero existe
        Panadero panadero = panaderoDAO.getPanaderoByDni(dni);
        if (panadero == null) {
            System.out.println("Panadero no encontrado.");
            return;
        }

        System.out.println("Panadero encontrado: " + panadero.getNombre());
        System.out.print("Ingrese el nuevo salario del panadero (deje en blanco para no modificar): ");
        String nuevoSalario = scanner.nextLine();
        if (!nuevoSalario.isEmpty()) {
            panadero.setSalario(Double.parseDouble(nuevoSalario));
        }

        System.out.print("Ingrese la nueva fecha de nacimiento del panadero (YYYY-MM-DD): ");
        String nuevaFecha = scanner.nextLine();
        if (!nuevaFecha.isEmpty()) {
            panadero.setFnac(java.time.LocalDate.parse(nuevaFecha));
        }

        try {
            panaderoDAO.updatePanadero(panadero);
            System.out.println("Panadero modificado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al modificar el panadero: " + e.getMessage());
        }
    }

    // Método para eliminar un panadero
    private static void eliminarPanadero(Scanner scanner) throws SQLException {
        System.out.print("Ingrese el DNI del panadero a eliminar: ");
        String dni = scanner.nextLine();

        // Verificar si el panadero existe antes de eliminar
        Panadero panadero = panaderoDAO.getPanaderoByDni(dni);
        if (panadero == null) {
            System.out.println("Panadero no encontrado.");
            return;
        }

        try {
            panaderoDAO.deletePanaderoByDni(dni);
            System.out.println("Panadero eliminado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el panadero: " + e.getMessage());
        }
    }
}
