package Menu;

import DAO.RepartidorDAO;
import Model.Repartidor;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que proporciona un menú interactivo para la gestión de repartidores.
 * Permite insertar, actualizar, eliminar y visualizar repartidores registrados en el sistema.
 *
 * @author Vanesa, Silvia, Jessica
 * @version 1.1
 * @date 10/04/2025
 */

public class MenuRepartidor {

    private static final Scanner scanner = new Scanner(System.in);
    private static final RepartidorDAO repartidorDAO = RepartidorDAO.getInstance();

    /**
     * Método principal que lanza el menú interactivo de gestión de repartidores.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n----- Menú Repartidor -----");
            System.out.println("1. Insertar repartidor");
            System.out.println("2. Actualizar repartidor");
            System.out.println("3. Eliminar repartidor");
            System.out.println("4. Ver todos los repartidores");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    insertarRepartidor();
                    break;
                case 2:
                    actualizarRepartidor();
                    break;
                case 3:
                    eliminarRepartidor();
                    break;
                case 4:
                    verTodosRepartidores();
                    break;
                case 5:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo nuevamente.");
            }
        } while (option != 5);
    }

    /**
     * Inserta un nuevo repartidor solicitando los datos al usuario.
     * Valida los datos y maneja posibles excepciones de entrada y base de datos.
     */
    private static void insertarRepartidor() {
        try {
            System.out.print("Ingrese el DNI del repartidor: ");
            String dni = scanner.nextLine();
            System.out.print("Ingrese la matrícula del repartidor: ");
            String matricula = scanner.nextLine();
            System.out.print("Ingrese el salario del repartidor: ");
            double salario = scanner.nextDouble();
            scanner.nextLine();  // Limpiar el buffer
            System.out.print("Ingrese el nombre del repartidor: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la fecha de nacimiento (yyyy-mm-dd): ");
            String fechaNacimiento = scanner.nextLine();

            // Crear el objeto Repartidor
            Repartidor repartidor = new Repartidor(dni, salario, java.time.LocalDate.parse(fechaNacimiento), nombre, matricula);

            // Insertar en la base de datos
            repartidorDAO.insertRepartidor(repartidor);
            System.out.println("Repartidor insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el repartidor: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en los datos proporcionados: " + e.getMessage());
        }
    }

    /**
     * Actualiza los datos de un repartidor existente identificado por su DNI.
     * Solicita nuevos valores al usuario para actualizar el registro.
     */
    private static void actualizarRepartidor() {
        try {
            System.out.print("Ingrese el DNI del repartidor a actualizar: ");
            String dni = scanner.nextLine();

            // Obtener los datos actuales del repartidor
            List<Repartidor> repartidores = repartidorDAO.getAllRepartidores();
            Repartidor repartidorEncontrado = null;
            for (Repartidor repartidor : repartidores) {
                if (repartidor.getDni().equals(dni)) {
                    repartidorEncontrado = repartidor;
                    break;
                }
            }

            if (repartidorEncontrado == null) {
                System.out.println("Repartidor no encontrado.");
                return;
            }

            System.out.print("Ingrese el nuevo salario: ");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer
            System.out.print("Ingrese el nuevo nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la nueva fecha de nacimiento (yyyy-mm-dd): ");
            String fechaNacimiento = scanner.nextLine();
            System.out.print("Ingrese la nueva matrícula: ");
            String matricula = scanner.nextLine();

            // Actualizar los datos del repartidor
            repartidorEncontrado.setSalario(salario);
            repartidorEncontrado.setNombre(nombre);
            repartidorEncontrado.setFnac(java.time.LocalDate.parse(fechaNacimiento));
            repartidorEncontrado.setMatricula(matricula);

            // Actualizar en la base de datos
            repartidorDAO.updateRepartidor(repartidorEncontrado);
            System.out.println("Repartidor actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el repartidor: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en los datos proporcionados: " + e.getMessage());
        }
    }

    /**
     * Elimina un repartidor identificado por su DNI.
     * Solicita el DNI al usuario y realiza la eliminación.
     */
    private static void eliminarRepartidor() {
        try {
            System.out.print("Ingrese el DNI del repartidor a eliminar: ");
            String dni = scanner.nextLine();

            // Eliminar el repartidor
            repartidorDAO.deleteRepartidorByDni(dni);
            System.out.println("Repartidor eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el repartidor: " + e.getMessage());
        }
    }

    /**
     * Muestra una lista con todos los repartidores registrados en la base de datos.
     */
    private static void verTodosRepartidores() {
        try {
            List<Repartidor> repartidores = repartidorDAO.getAllRepartidores();
            if (repartidores.isEmpty()) {
                System.out.println("No hay repartidores registrados.");
            } else {
                System.out.println("\nLista de repartidores:");
                for (Repartidor repartidor : repartidores) {
                    System.out.println("DNI: " + repartidor.getDni() + ", Nombre: " + repartidor.getNombre() + ", Salario: " + repartidor.getSalario() + ", Matrícula: " + repartidor.getMatricula());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los repartidores: " + e.getMessage());
        }
    }
}
