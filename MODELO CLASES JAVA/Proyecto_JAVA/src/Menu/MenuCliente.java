package Menu;

import Model.Cliente;
import DAO.ClienteDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Vanesa, Silvia, Jessica
 * @version 1.1
 * @date 10/04/2025
 */
public class MenuCliente {

    /** Instancia del DAO para acceso a los datos de clientes */
    private static ClienteDAO clienteDAO = ClienteDAO.getInstance();

    /**
     * Método principal que muestra el menú y gestiona las operaciones del usuario.
     *
     * @param args Argumentos de línea de comandos.
     * @throws SQLException Si ocurre un error de base de datos.
     */
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar el menú
            System.out.println("********* Menú *********");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Modificar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarCliente(scanner);
                    break;
                case 2:
                    try {
                        mostrarClientes();
                    } catch (SQLException e) {
                        System.out.println("Error al mostrar los clientes: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        modificarCliente(scanner);
                    } catch (SQLException e) {
                        System.out.println("Error al modificar el cliente: " + e.getMessage());
                    }
                    break;
                case 4:
                    eliminarCliente(scanner);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }

        } while (opcion != 5);
    }

    /**
     * Permite al usuario agregar un nuevo cliente introduciendo sus datos.
     *
     * @param scanner Scanner para leer la entrada del usuario.
     * @throws SQLException Si ocurre un error al insertar el cliente.
     */
    private static void agregarCliente(Scanner scanner) throws SQLException {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el primer apellido del cliente: ");
        String apellido1 = scanner.nextLine();

        System.out.print("Ingrese el segundo apellido del cliente: ");
        String apellido2 = scanner.nextLine();

        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = scanner.nextLine();

        // Crear lista de teléfonos
        List<String> telefonos = ingresarTelefonos(scanner);

        // Crear cliente y agregarlo a la base de datos
        Cliente cliente = new Cliente(0, direccion, nombre, apellido1, apellido2, telefonos);
        try {
            clienteDAO.insertCliente(cliente);
            System.out.println("Cliente agregado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar el cliente: " + e.getMessage());
        }
    }

    /**
     * Muestra la lista de todos los clientes registrados en la base de datos.
     *
     * @throws SQLException Si ocurre un error al recuperar los datos.
     */
    private static void mostrarClientes() throws SQLException {
        List<Cliente> clientes = clienteDAO.getAllClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println("-------------");
                System.out.println(cliente.getIdCliente());
                System.out.println(cliente.obtenerNombreCompleto() + " - " + cliente.getDireccion());
                System.out.println("Teléfonos: " + String.join(", ", cliente.getTelefonos()));
            }
        }
    }

    /**
     * Permite modificar los datos de un cliente existente.
     *
     * @param scanner Scanner para leer la entrada del usuario.
     * @throws SQLException Si ocurre un error al actualizar los datos del cliente.
     */
    private static void modificarCliente(Scanner scanner) throws SQLException {
        System.out.print("Ingrese el ID del cliente a modificar: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        // Verificar si el cliente existe
        Cliente cliente = clienteDAO.getClienteById(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Cliente encontrado: " + cliente.obtenerNombreCompleto());
        System.out.print("Ingrese la nueva dirección del cliente (deje en blanco para no modificar): ");
        String nuevaDireccion = scanner.nextLine();
        if (!nuevaDireccion.isEmpty()) {
            cliente.setDireccion(nuevaDireccion);
        }

        // Modificar teléfonos
        System.out.println("¿Desea modificar los teléfonos? (sí/no)");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("sí")) {
            List<String> nuevosTelefonos = ingresarTelefonos(scanner);
            cliente.setTelefonos(nuevosTelefonos);
        }

        try {
            clienteDAO.updateCliente(cliente);
            System.out.println("Cliente modificado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al modificar el cliente: " + e.getMessage());
        }
    }

    /**
     * Permite eliminar un cliente existente a partir de su ID.
     *
     * @param scanner Scanner para leer la entrada del usuario.
     * @throws SQLException Si ocurre un error al eliminar el cliente.
     */
    private static void eliminarCliente(Scanner scanner) throws SQLException {
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        // Verificar si el cliente existe antes de eliminar
        Cliente cliente = clienteDAO.getClienteById(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        try {
            clienteDAO.deleteClienteById(idCliente);
            System.out.println("Cliente eliminado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
        }
    }



    /**
     * Permite al usuario ingresar múltiples teléfonos para un cliente.
     *
     * @param scanner Scanner para leer la entrada del usuario.
     * @return Lista de números de teléfono introducidos.
     */
    private static List<String> ingresarTelefonos(Scanner scanner) {
        List<String> telefonos = new ArrayList<>();
        System.out.print("Ingrese el número de teléfono (o 'fin' para terminar): ");
        String telefono = scanner.nextLine();
        while (!telefono.equalsIgnoreCase("fin")) {
            telefonos.add(telefono);
            System.out.print("Ingrese otro teléfono (o 'fin' para terminar): ");
            telefono = scanner.nextLine();
        }
        return telefonos;
    }
}
