package Menu;

import DAO.*;
import Model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que gestiona el menú de opciones para operar con las compras del sistema.
 * Permite visualizar compras, crear nuevas, ver detalles, eliminar y modificar compras.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.0
 * @since 10/04/2025
 */
public class MenuCompra {

    /**
     * Método principal que ejecuta el menú de compras.
     * Permite al usuario interactuar con el sistema a través de la consola.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        CompraDAO compraDAO = CompraDAO.getInstance();
        LineaDeTicketDAO lineaDAO = LineaDeTicketDAO.getInstance();
        int opcion;
        Compra compra = new Compra();

        // Bucle principal del menú
        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Mostrar todas las compras");
            System.out.println("2. Crear nueva compra");
            System.out.println("3. Ver detalles de la compra");
            System.out.println("4. Eliminar compra");
            System.out.println("5. Modificar compra");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");

            // Validar entrada numérica
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Mostrar todas las compras registradas
                    mostrarTodasLasCompras(compraDAO);
                    break;

                case 2:
                    // Crear una nueva compra
                    crearNuevaCompra(scanner, compraDAO, lineaDAO);
                    break;

                case 3:
                    // Ver detalles de una compra específica
                    verDetallesCompra(scanner, compraDAO, lineaDAO);
                    break;

                case 4:
                    // Eliminar una compra
                    eliminarCompra(scanner, lineaDAO);
                    // Falta un break aquí en el código original
                    break;

                case 5:
                    // Modificar una compra existente
                    modificarCompra(scanner, compraDAO, lineaDAO);
                    break;

                case 6:
                    // Salir del programa
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
                    break;
            }
        }
        scanner.close();
    }

    /**
     * Muestra todas las compras registradas en el sistema.
     *
     * @param compraDAO Instancia de CompraDAO para acceder a las compras.
     * @throws SQLException Si ocurre un error al consultar la base de datos.
     */
    private static void mostrarTodasLasCompras(CompraDAO compraDAO) throws SQLException {
        List<Compra> compras = compraDAO.getAllCompras();
        if (compras.isEmpty()) {
            System.out.println("No hay compras registradas.");
        } else {
            System.out.println("\n--- Lista de Compras ---");
            for (Compra c : compras) {
                System.out.println("Número de compra: " + c.getNumCompra());
                System.out.println("Fecha de la compra: " + c.getFecha());
                System.out.println("Cliente: " + (c.getCliente() != null ? c.getCliente().getNombre() : "No asignado"));
                System.out.println("Dependiente: " + (c.getDependiente() != null ? c.getDependiente().getNombre() : "No asignado"));
                System.out.println("Repartidor: " + (c.getRepartidor() != null ? c.getRepartidor().getNombre() : "No asignado"));
                System.out.println("Total: " + c.getTotal());
                System.out.println("---");
            }
        }
    }

    /**
     * Crea una nueva compra, solicitando datos al usuario.
     *
     * @param scanner Objeto Scanner para la entrada de datos.
     * @param compraDAO DAO de compras para insertar la nueva compra.
     * @param lineaDAO DAO de líneas de ticket para registrar productos.
     * @throws SQLException Si ocurre un error al insertar en la base de datos.
     */
    private static void crearNuevaCompra(Scanner scanner, CompraDAO compraDAO, LineaDeTicketDAO lineaDAO) throws SQLException {
        Compra compra = new Compra();

        System.out.print("Ingresa el ID del cliente: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingresa un número de cliente válido.");
            scanner.next();
        }
        int clienteId = scanner.nextInt();
        scanner.nextLine();

        ClienteDAO clienteDAO = ClienteDAO.getInstance();
        Cliente cliente = clienteDAO.getClienteById(clienteId);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Ingresa el DNI del dependiente: ");
        String dependienteDni = scanner.nextLine();

        DependienteDAO dependienteDAO = DependienteDAO.getInstance();
        Dependiente dependiente = dependienteDAO.getDependienteByDni(dependienteDni);
        if (dependiente == null) {
            System.out.println("Dependiente no encontrado.");
            return;
        }

        compra.setCliente(cliente);
        compra.setDependiente(dependiente);

        boolean agregarMasProductos = true;
        ArrayList<LineaDeTicket> lineasCompra = new ArrayList<>();

        while (agregarMasProductos) {
            System.out.print("Ingresa el ID del producto: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingresa un número de producto válido.");
                scanner.next();
            }
            int productoId = scanner.nextInt();
            scanner.nextLine();

            Producto producto = PropioDAO.getInstance().getPropioByCodigo(productoId);
            if (producto == null) {
                producto = AjenoDAO.getInstance().getAjenoByCodigo(productoId);
            }

            if (producto != null) {
                System.out.print("Ingresa la cantidad del producto: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Por favor, ingresa una cantidad válida.");
                    scanner.next();
                }
                int cantidad = scanner.nextInt();
                scanner.nextLine();

                LineaDeTicket linea = new LineaDeTicket(compra, producto, cantidad, compra.getNumLineasActuales() + 1);
                lineasCompra.add(linea);
                System.out.println("Producto agregado a la compra.");
            } else {
                System.out.println("Producto no encontrado.");
            }

            System.out.print("¿Quieres agregar otro producto? (sí/no): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("sí") && !respuesta.equalsIgnoreCase("si")) {
                agregarMasProductos = false;

                int numCompra = compraDAO.insertCompra(compra);
                compra.setNumCompra(numCompra);

                for (LineaDeTicket linea : lineasCompra) {
                    lineaDAO.insertLineaDeTicket(linea);
                }
                System.out.println("Compra registrada con éxito.");
            }
        }
    }

    /**
     * Muestra los detalles de una compra específica.
     *
     * @param scanner Objeto Scanner para la entrada de datos.
     * @param compraDAO DAO de compras.
     * @param lineaDAO DAO de líneas de ticket.
     * @throws SQLException Si ocurre un error al consultar la base de datos.
     */
    private static void verDetallesCompra(Scanner scanner, CompraDAO compraDAO, LineaDeTicketDAO lineaDAO) throws SQLException {
        System.out.print("Ingresa el número de la compra: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingresa un número válido.");
            scanner.next();
        }
        int numCompraDetalles = scanner.nextInt();
        scanner.nextLine();

        Compra compraDetalles = compraDAO.getCompraByNumCompra(numCompraDetalles);
        if (compraDetalles != null) {
            System.out.println("\nDetalles de la compra:");
            System.out.println("Fecha: " + compraDetalles.getFecha());
            System.out.println("Cliente: " + (compraDetalles.getCliente() != null ? compraDetalles.getCliente().getNombre() : "No asignado"));
            System.out.println("Dependiente: " + (compraDetalles.getDependiente() != null ? compraDetalles.getDependiente().getNombre() : "No asignado"));

            List<LineaDeTicket> lineas = lineaDAO.getAllLineasDeTicketByNumCompra(numCompraDetalles);
            for (LineaDeTicket linea : lineas) {
                System.out.println("Línea: " + linea.getNumLinea() + ", Producto: " + linea.getProducto().getNombre() +
                        ", Cantidad: " + linea.getCantidad() + ", Precio: " + linea.getPrecio());
            }
        } else {
            System.out.println("Compra no encontrada.");
        }
    }

    /**
     * Elimina una compra y todas sus líneas asociadas.
     *
     * @param scanner Objeto Scanner para la entrada de datos.
     * @param lineaDAO DAO de líneas de ticket.
     * @throws SQLException Si ocurre un error al eliminar los datos.
     */
    private static void eliminarCompra(Scanner scanner, LineaDeTicketDAO lineaDAO) throws SQLException {
        System.out.print("Ingresa el número de la compra que deseas eliminar: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingresa un número válido.");
            scanner.next();
        }
        int numCompraEliminar = scanner.nextInt();
        scanner.nextLine();

        lineaDAO.deleteAllLineasDeCompra(numCompraEliminar);
        System.out.println("Compra eliminada.");
    }

    /**
     * Permite modificar las líneas de una compra existente.
     *
     * @param scanner Objeto Scanner para la entrada de datos.
     * @param compraDAO DAO de compras.
     * @param lineaDAO DAO de líneas de ticket.
     * @throws SQLException Si ocurre un error al actualizar datos.
     */
    private static void modificarCompra(Scanner scanner, CompraDAO compraDAO, LineaDeTicketDAO lineaDAO) throws SQLException {
        System.out.print("Ingresa el número de la compra que deseas modificar: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingresa un número válido.");
            scanner.next();
        }
        int numCompraModificar = scanner.nextInt();
        scanner.nextLine();

        Compra compraModificar = compraDAO.getCompraByNumCompra(numCompraModificar);
        if (compraModificar != null) {
            List<LineaDeTicket> lineasModificar = lineaDAO.getAllLineasDeTicketByNumCompra(numCompraModificar);

            if (lineasModificar.isEmpty()) {
                System.out.println("Esta compra no tiene líneas para modificar.");
                return;
            }

            System.out.println("\n--- Líneas actuales de la compra ---");
            for (LineaDeTicket linea : lineasModificar) {
                System.out.println("Línea: " + linea.getNumLinea() + ", Producto: " + linea.getProducto().getNombre() + ", Cantidad: " + linea.getCantidad());
            }

            System.out.print("Número de línea a modificar (0 para cancelar): ");
            int numLinea = scanner.nextInt();
            scanner.nextLine();

            if (numLinea == 0) {
                System.out.println("Modificación cancelada.");
                return;
            }

            LineaDeTicket lineaSeleccionada = null;
            for (LineaDeTicket l : lineasModificar) {
                if (l.getNumLinea() == numLinea) {
                    lineaSeleccionada = l;
                    break;
                }
            }

            if (lineaSeleccionada == null) {
                System.out.println("Número de línea no encontrado.");
                return;
            }

            System.out.print("Nueva cantidad (0 para eliminar la línea): ");
            int nuevaCantidad = scanner.nextInt();
            scanner.nextLine();

            if (nuevaCantidad == 0) {
                lineaDAO.deleteLineaDeTicket(numCompraModificar, numLinea);
            } else {
                lineaSeleccionada.setCantidad(nuevaCantidad);
                lineaDAO.updateLineaDeTicket(lineaSeleccionada);
                System.out.println("Cantidad actualizada.");
            }
        } else {
            System.out.println("Compra no encontrada.");
        }
    }
}
