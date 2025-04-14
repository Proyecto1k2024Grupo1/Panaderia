package Menu;

import DAO.*;
import Model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que muestra un menú interactivo en consola para gestionar las compras.
 * Permite visualizar, crear, modificar y eliminar líneas de compra, así como ver detalles y total de compras.
 * Utiliza DAOs para interactuar con la base de datos.
 *
 * @author Vanesa
 * @author Silvia
 * @author Jessica
 * @version 1.1
 * @since 10/04/2025
 */
public class MenuCompra {

    /**
     * Método principal que lanza el menú de gestión de compras.
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

        while (!salir) {
            // Mostrar el menú
            System.out.println("\n--- Menú ---");
            System.out.println("1. Mostrar todas las compras");
            System.out.println("2. Crear nueva compra");
            System.out.println("3. Modificar línea de la compra");
            System.out.println("4. Borrar línea de la compra");
            System.out.println("5. Ver total de la compra");
            System.out.println("6. Ver detalles de la compra");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next();  // Descartar la entrada no válida
            }
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Mostrar todas las compras registradas
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
                            System.out.println("Total: " + c.calcularTotal());
                            System.out.println("---");
                        }
                    }
                    break;

                case 2:
                    // Crear una nueva compra y añadir líneas de producto
                    compra = new Compra();
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
                        System.out.println("Cliente no encontrado con el ID proporcionado.");
                        break;
                    }

                    System.out.print("Ingresa el DNI del dependiente: ");
                    while (!scanner.hasNext()) {
                        System.out.println("Por favor, ingresa un número de dependiente válido.");
                        scanner.next();
                    }
                    String dependienteDni = scanner.next();
                    scanner.nextLine();

                    DependienteDAO dependienteDAO = DependienteDAO.getInstance();
                    Dependiente dependiente = dependienteDAO.getDependienteByDni(dependienteDni);
                    if (dependiente == null) {
                        System.out.println("Dependiente no encontrado con el ID proporcionado.");
                        break;
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

                        PropioDAO productoPropioDAO = PropioDAO.getInstance();
                        Producto producto = productoPropioDAO.getPropioByCodigo(productoId);

                        if (producto == null) {
                            AjenoDAO productoAjenoDAO = AjenoDAO.getInstance();
                            producto = productoAjenoDAO.getAjenoByCodigo(productoId);
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
                            System.out.println("Línea registrada en la memoria para la compra " + compra.getNumCompra());
                        } else {
                            System.out.println("Producto no encontrado con el ID proporcionado.");
                        }

                        System.out.print("¿Quieres agregar otro producto? (sí/no): ");
                        String respuesta = scanner.nextLine();
                        if (!respuesta.equalsIgnoreCase("sí") && !respuesta.equalsIgnoreCase("si")) {
                            agregarMasProductos = false;
                            int numCompra = compraDAO.insertCompra(compra);
                            compra.setNumCompra(numCompra);
                            LineaDeTicketDAO linead = LineaDeTicketDAO.getInstance();
                            try {
                                for (LineaDeTicket linea : lineasCompra) {
                                    linead.insertLineaDeTicket(linea);
                                }
                                System.out.println("Compra registrada con éxito.");
                            } catch (Exception e) {
                                System.out.println("Error al registrar la compra: " + e.getMessage());
                            }
                        }
                    }
                    break;

                case 3:
                    // Modificar una línea de una compra existente
                    System.out.print("Ingresa el número de la compra: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingresa un número de compra válido.");
                        scanner.next();
                    }
                    int numCompraModificar = scanner.nextInt();
                    scanner.nextLine();
                    Compra compraModificar = compraDAO.getCompraByNumCompra(numCompraModificar);
                    if (compraModificar != null) {
                        System.out.print("Ingresa el número de la línea que deseas modificar (1 a " + lineaDAO.getAllLineasDeTicketByNumCompra(numCompraModificar).size() + "): ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Por favor, ingresa un número válido para la línea.");
                            scanner.next();
                        }
                        int lineaModificar = scanner.nextInt();
                        scanner.nextLine();
                        if (lineaModificar >= 0 && lineaModificar < lineaDAO.getAllLineasDeTicketByNumCompra(numCompraModificar).size()) {
                            LineaDeTicket linea = lineaDAO.getAllLineasDeTicketByNumCompra(numCompraModificar).get(lineaModificar);
                            System.out.println("Línea actual: Producto: " + linea.getProducto().getNombre() + ", Cantidad: " + linea.getCantidad() + ", Precio: " + linea.getPrecio());
                            System.out.print("Nuevo nombre del producto (deja en blanco para no cambiarlo): ");
                            String nuevoNombre = scanner.nextLine();
                            if (!nuevoNombre.isEmpty()) {
                                linea.getProducto().setNombre(nuevoNombre);
                            }
                            System.out.print("Nueva cantidad (deja en blanco para no cambiarla): ");
                            String cantidadInput = scanner.nextLine();
                            if (!cantidadInput.isEmpty()) {
                                int nuevaCantidad = Integer.parseInt(cantidadInput);
                                linea.setCantidad(nuevaCantidad);
                            }
                            lineaDAO.updateLineaDeTicket(linea);
                            System.out.println("Línea modificada con éxito.");
                        } else {
                            System.out.println("Número de línea inválido.");
                        }
                    } else {
                        System.out.println("Compra no encontrada.");
                    }
                    break;

                case 4:
                    // Eliminar una línea de una compra existente
                    System.out.print("Ingresa el número de la compra: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingresa un número de compra válido.");
                        scanner.next();
                    }
                    int numCompraBorrar = scanner.nextInt();
                    scanner.nextLine();
                    Compra compraBorrar = compraDAO.getCompraByNumCompra(numCompraBorrar);
                    if (compraBorrar != null) {
                        System.out.print("Ingresa el número de la línea que deseas borrar (1 a " + lineaDAO.getAllLineasDeTicketByNumCompra(numCompraBorrar).size() + "): ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Por favor, ingresa un número válido para la línea.");
                            scanner.next();
                        }
                        int lineaBorrar = scanner.nextInt();
                        scanner.nextLine();
                        if (lineaBorrar >= 0 && lineaBorrar < lineaDAO.getAllLineasDeTicketByNumCompra(numCompraBorrar).size()) {
                            LineaDeTicket linea = lineaDAO.getAllLineasDeTicketByNumCompra(numCompraBorrar).get(lineaBorrar);
                            lineaDAO.deleteLineaDeTicket(linea.getNumCompra(), linea.getNumLinea());
                            System.out.println("Línea eliminada con éxito.");
                        } else {
                            System.out.println("Número de línea inválido.");
                        }
                    } else {
                        System.out.println("Compra no encontrada.");
                    }
                    break;

                case 5:
                    // Mostrar el total de una compra específica
                    System.out.print("Ingresa el número de la compra: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingresa un número de compra válido.");
                        scanner.next();
                    }
                    int numCompraTotal = scanner.nextInt();
                    scanner.nextLine();
                    Compra compraTotal = compraDAO.getCompraByNumCompra(numCompraTotal);
                    if (compraTotal != null) {
                        System.out.println("El total de la compra es: " + compraTotal.calcularTotal());
                    } else {
                        System.out.println("Compra no encontrada.");
                    }
                    break;

                case 6:
                    // Ver detalles completos de una compra
                    System.out.print("Ingresa el número de la compra: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingresa un número de compra válido.");
                        scanner.next();
                    }
                    int numCompraDetalles = scanner.nextInt();
                    scanner.nextLine();
                    Compra compraDetalles = compraDAO.getCompraByNumCompra(numCompraDetalles);
                    if (compraDetalles != null) {
                        System.out.println("Detalles de la compra:");
                        System.out.println("Fecha de compra: " + compraDetalles.getFecha());
                        System.out.println("Cliente: " + (compraDetalles.getCliente() != null ? compraDetalles.getCliente().getNombre() : "No asignado"));
                        System.out.println("Dependiente: " + (compraDetalles.getDependiente() != null ? compraDetalles.getDependiente().getNombre() : "No asignado"));
                        List<LineaDeTicket> lineasCompraDetalles = lineaDAO.getAllLineasDeTicketByNumCompra(numCompraDetalles);
                        for (LineaDeTicket linea : lineasCompraDetalles) {
                            System.out.println("Producto: " + linea.getProducto().getNombre() + ", Cantidad: " + linea.getCantidad() + ", Precio: " + linea.getPrecio());
                        }
                    } else {
                        System.out.println("Compra no encontrada.");
                    }
                    break;

                case 7:
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
}
