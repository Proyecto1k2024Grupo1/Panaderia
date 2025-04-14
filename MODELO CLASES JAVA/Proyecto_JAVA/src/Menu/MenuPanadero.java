package Menu;

import Model.Panadero;
import DAO.PanaderoDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
/**
 * @author Vanesa, Silvia, Jessica
 * @version 1.1
 * @date 10/04/2025
 */

public class MenuPanadero {

    private static final PanaderoDAO panaderoDAO = PanaderoDAO.getInstance();

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n********* MENÚ PANADERO *********");
            System.out.println("1. Añadir panadero");
            System.out.println("2. Mostrar panaderos");
            System.out.println("3. Modificar panadero");
            System.out.println("4. Eliminar panadero");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> anadirPanadero(scanner);
                case 2 -> mostrarPanaderos();
                case 3 -> modificarPanadero(scanner);
                case 4 -> eliminarPanadero(scanner);
                case 5 -> System.out.println("Saliendo del menú panadero...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private static void anadirPanadero(Scanner scanner) throws SQLException {
        System.out.println("\n--- Añadir panadero ---");

        System.out.print("DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        String fechaNacimiento = scanner.nextLine();

        Panadero panadero = new Panadero(dni, salario, LocalDate.parse(fechaNacimiento), nombre);

        panaderoDAO.insertPanadero(panadero);

        System.out.println("Panadero añadido correctamente.");
    }

    private static void mostrarPanaderos() throws SQLException {
        System.out.println("\n--- Lista de panaderos ---");

        List<Panadero> panaderos = panaderoDAO.getAllPanaderos();

        if (panaderos.isEmpty()) {
            System.out.println("No hay panaderos registrados.");
        } else {
            for (Panadero p : panaderos) {
                System.out.println("-----------------------------");
                System.out.println("DNI: " + p.getDni());
                System.out.println("Nombre: " + p.getNombre());
                System.out.println("Salario: " + p.getSalario());
                System.out.println("Fecha de nacimiento: " + p.getFnac());
            }
        }
    }

    private static void modificarPanadero(Scanner scanner) throws SQLException {
        System.out.println("\n--- Modificar panadero ---");

        System.out.print("Ingrese el DNI del panadero a modificar: ");
        String dni = scanner.nextLine();

        Panadero panadero = panaderoDAO.getPanaderoByDni(dni);

        if (panadero == null) {
            System.out.println("Panadero no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (" + panadero.getNombre() + "): ");
        String nombre = scanner.nextLine();
        if (!nombre.isBlank()) {
            panadero.setNombre(nombre);
        }

        System.out.print("Nuevo salario (" + panadero.getSalario() + "): ");
        String salarioStr = scanner.nextLine();
        if (!salarioStr.isBlank()) {
            panadero.setSalario(Double.parseDouble(salarioStr));
        }

        System.out.print("Nueva fecha de nacimiento (" + panadero.getFnac() + "): ");
        String fechaNacimiento = scanner.nextLine();
        if (!fechaNacimiento.isBlank()) {
            panadero.setFnac(LocalDate.parse(fechaNacimiento));
        }

        panaderoDAO.updatePanadero(panadero);
        System.out.println("Panadero modificado correctamente.");
    }

    private static void eliminarPanadero(Scanner scanner) throws SQLException {
        System.out.println("\n--- Eliminar panadero ---");

        System.out.print("Ingrese el DNI del panadero a eliminar: ");
        String dni = scanner.nextLine();

        Panadero panadero = panaderoDAO.getPanaderoByDni(dni);

        if (panadero == null) {
            System.out.println("Panadero no encontrado.");
            return;
        }

        panaderoDAO.deletePanaderoByDni(dni);
        System.out.println("Panadero eliminado correctamente.");
    }
}
