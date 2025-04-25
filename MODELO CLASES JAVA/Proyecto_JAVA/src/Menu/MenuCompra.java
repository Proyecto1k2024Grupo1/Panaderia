package Menu;

import DAO.*;
import Model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuCompra {

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
            System.out.println("1. Crear nueva compra");
            System.out.println("2. Ver detalles de la compra");
            System.out.println("3. Borrar compra");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next();  // Descartar la entrada no válida
            }
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Crear una nueva compra
                    compra = new Compra();

                    // Solicitar el cliente
                    System.out.print("Ingresa el ID del cliente: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingresa un número de cliente válido.");
                        scanner.next();  // Descartar la entrada no válida
                    }
                    int clienteId = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea

                    // Obtener el cliente por el ID
                    ClienteDAO clienteDAO = ClienteDAO.getInstance();
                    Cliente cliente = clienteDAO.getClienteById(clienteId);
                    if (cliente == null) {
                        System.out.println("Cliente no encontrado con el ID proporcionado.");
                        break;
                    }

                    // Solicitar el dependiente
                    System.out.print("Ingresa el DNI del dependiente: ");
                    while (!scanner.hasNext()) {
                        System.out.println("Por favor, ingresa un número de dependiente válido.");
                        scanner.next();  // Descartar la entrada no válida
                    }
                    String dependienteDni = scanner.next();
                    scanner.nextLine();  // Consumir el salto de línea

                    // Obtener el dependiente por el ID
                    DependienteDAO dependienteDAO = DependienteDAO.getInstance();
                    Dependiente dependiente = dependienteDAO.getDependienteByDni(dependienteDni);
                    if (dependiente == null) {
                        System.out.println("Dependiente no encontrado con el ID proporcionado.");
                        break;
                    }

                    // Asociar el cliente y el dependiente a la compra
                    compra.setCliente(cliente);
                    compra.setDependiente(dependiente);

                    boolean agregarMasProductos = true;
                    ArrayList<LineaDeTicket> lineasCompra = new ArrayList<>(); // Lista para almacenar las líneas

                    while (agregarMasProductos) {
                        // Solicitar el ID del producto
                        System.out.print("Ingresa el ID del producto: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Por favor, ingresa un número de producto válido.");
                            scanner.next();  // Descartar la entrada no válida
                        }
                        int productoId = scanner.nextInt();
                        scanner.nextLine();  // Consumir el salto de línea

                        // Intentar obtener el producto en ProductoPropioDAO
                        PropioDAO productoPropioDAO = PropioDAO.getInstance();
                        Producto producto = productoPropioDAO.getPropioByCodigo(productoId);

                        // Si no se encontró, buscar en ProductoAjenoDAO
                        if (producto == null) {
                            AjenoDAO productoAjenoDAO = AjenoDAO.getInstance();
                            producto = productoAjenoDAO.getAjenoByCodigo(productoId);
                        }

                        if (producto != null) {
                            // Si se encuentra el producto, pedir la cantidad y registrar la línea de compra
                            System.out.print("Ingresa la cantidad del producto: ");
                            while (!scanner.hasNextInt()) {
                                System.out.println("Por favor, ingresa una cantidad válida.");
                                scanner.next();  // Descartar la entrada no válida
                            }
                            int cantidad = scanner.nextInt();
                            scanner.nextLine();  // Consumir el salto de línea

                            // Crear la línea de ticket pero no insertarla aún
                            LineaDeTicket linea = new LineaDeTicket(compra, producto, cantidad, compra.getNumLineasActuales() + 1);

                            // Agregar la línea al ArrayList
                            lineasCompra.add(linea);
                            System.out.println("Línea registrada en la memoria para la compra " + compra.getNumCompra());
                        } else {
                            // Si el producto no se encuentra en ninguno de los DAOs
                            System.out.println("Producto no encontrado con el ID proporcionado.");
                        }

                        // Preguntar si el usuario quiere agregar otra línea
                        System.out.print("¿Quieres agregar otro producto? (sí/no): ");
                        String respuesta = scanner.nextLine();
                        if (!respuesta.equalsIgnoreCase("sí") && !respuesta.equalsIgnoreCase("si")) {
                            agregarMasProductos = false;

                            // Ahora insertar todas las líneas de la compra al final
                            int numCompra = compraDAO.insertCompra(compra);
                            compra.setNumCompra(numCompra);
                            LineaDeTicketDAO linead = LineaDeTicketDAO.getInstance();
                            try {
                                // Iniciar una transacción para la inserción de todas las líneas
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

                case 2:
                    // Ver detalles de la compra
                    System.out.print("Ingresa el número de la compra: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingresa un número de compra válido.");
                        scanner.next();  // Descartar la entrada no válida
                    }
                    int numCompraDetalles = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
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
                case 3:
                    // Borrar una compra
                    System.out.print("Ingresa el número de la compra que deseas eliminar: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingresa un número de compra válido.");
                        scanner.next();  // Descartar entrada no válida
                    }
                    int numCompraEliminar = scanner.nextInt();
                    scanner.nextLine();  // Consumir salto de línea

                    // Confirmación
                    System.out.print("¿Estás seguro que deseas eliminar la compra y todas sus líneas asociadas? (sí/no): ");
                    String confirmacion = scanner.nextLine();

                    if (confirmacion.equalsIgnoreCase("sí") || confirmacion.equalsIgnoreCase("si")) {
                        try {
                            compraDAO.deleteCompra(numCompraEliminar);
                            System.out.println("Compra y sus líneas asociadas eliminadas correctamente.");
                        } catch (SQLException e) {
                            System.out.println("Error al eliminar la compra: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Eliminación cancelada.");
                    }
                    break;

                case 4:
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
