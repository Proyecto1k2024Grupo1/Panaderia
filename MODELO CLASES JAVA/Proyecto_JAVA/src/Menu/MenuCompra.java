package Menu;

import DAO.*;
import Model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Vanesa, Silvia, Jessica
 * @version 1.1
 * @date 10/04/2025
 */
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
                    // Mostrar todas las compras
                    List<Compra> compras = compraDAO.getAllCompras();  // Obtener todas las compras desde la base de datos
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

                case 3:
                    // Modificar una línea en la compra
                    System.out.print("Ingresa el número de la compra: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingresa un número de compra válido.");
                        scanner.next();  // Descartar la entrada no válida
                    }
                    int numCompraModificar = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    Compra compraModificar = compraDAO.getCompraByNumCompra(numCompraModificar);
                    if (compraModificar != null) {
                        System.out.print("Ingresa el número de la línea que deseas modificar (1 a " + lineaDAO.getAllLineasDeTicketByNumCompra(numCompraModificar).size() + "): ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Por favor, ingresa un número válido para la línea.");
                            scanner.next();  // Descartar la entrada no válida
                        }
                        int lineaModificar = scanner.nextInt();  // Restamos 1 para usar el índice
                        scanner.nextLine();  // Consumir el salto de línea
                        if (lineaModificar >= 0 && lineaModificar < lineaDAO.getAllLineasDeTicketByNumCompra(numCompraModificar).size()) {
                            LineaDeTicket linea = lineaDAO.getAllLineasDeTicketByNumCompra(numCompraModificar).get(lineaModificar);

                            System.out.println("Línea actual: Producto: " + linea.getProducto().getNombre() + ", Cantidad: " + linea.getCantidad() + ", Precio: " + linea.getPrecio());
                            System.out.print("Nuevo nombre del producto (deja en blanco para no cambiarlo): ");
                            String nuevoNombre = scanner.nextLine();
                            if (!nuevoNombre.isEmpty()) {
                                linea.getProducto().setNombre(nuevoNombre);  // Cambiar el nombre del producto
                            }

                            System.out.print("Nueva cantidad (deja en blanco para no cambiarla): ");
                            String cantidadInput = scanner.nextLine();
                            if (!cantidadInput.isEmpty()) {
                                int nuevaCantidad = Integer.parseInt(cantidadInput);
                                linea.setCantidad(nuevaCantidad);  // Cambiar la cantidad
                            }

                            // Guardar los cambios en la base de datos
                            lineaDAO.updateLineaDeTicket(linea);  // Actualizar la línea
                            System.out.println("Línea modificada con éxito.");
                        } else {
                            System.out.println("Número de línea inválido.");
                        }
                    } else {
                        System.out.println("Compra no encontrada.");
                    }
                    break;


                case 4:
                    // Borrar una línea de la compra
                    System.out.print("Ingresa el número de la compra: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingresa un número de compra válido.");
                        scanner.next();  // Descartar la entrada no válida
                    }
                    int numCompraBorrar = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    Compra compraBorrar = compraDAO.getCompraByNumCompra(numCompraBorrar);
                    if (compraBorrar != null) {
                        System.out.print("Ingresa el número de la línea que deseas borrar (1 a " + lineaDAO.getAllLineasDeTicketByNumCompra(numCompraBorrar).size() + "): ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Por favor, ingresa un número válido para la línea.");
                            scanner.next();  // Descartar la entrada no válida
                        }
                        int lineaBorrar = scanner.nextInt();  // Restamos 1 para usar el índice
                        scanner.nextLine();  // Consumir el salto de línea
                        if (lineaBorrar >= 0 && lineaBorrar < lineaDAO.getAllLineasDeTicketByNumCompra(numCompraBorrar).size()) {
                            LineaDeTicket linea = lineaDAO.getAllLineasDeTicketByNumCompra(numCompraBorrar).get(lineaBorrar);
                            lineaDAO.deleteLineaDeTicket(linea.getNumCompra(), linea.getNumLinea());  // Eliminar la línea
                            System.out.println("Línea eliminada con éxito.");
                        } else {
                            System.out.println("Número de línea inválido.");
                        }
                    } else {
                        System.out.println("Compra no encontrada.");
                    }
                    break;
                case 5:
                    // Ver total de la compra
                    System.out.print("Ingresa el número de la compra: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingresa un número de compra válido.");
                        scanner.next();  // Descartar la entrada no válida
                    }
                    int numCompraTotal = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    Compra compraTotal = compraDAO.getCompraByNumCompra(numCompraTotal);
                    if (compraTotal != null) {
                        System.out.println("El total de la compra es: " + compraTotal.calcularTotal());
                    } else {
                        System.out.println("Compra no encontrada.");
                    }
                    break;

                case 6:
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
