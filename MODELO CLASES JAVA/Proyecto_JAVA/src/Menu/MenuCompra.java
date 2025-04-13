package Menu;

import DAO.CompraDAO;
import DAO.LineaDeTicketDAO;
import Model.Compra;
import Model.LineaDeTicket;
import Model.Producto;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuCompra {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        CompraDAO compraDAO = new CompraDAO();
        LineaDeTicketDAO lineaDAO = new LineaDeTicketDAO();
        int opcion;
        Compra compra = new Compra();

        while (!salir) {
            // Mostrar el menú
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear nueva compra");
            System.out.println("2. Registrar línea en la compra");
            System.out.println("3. Modificar línea de la compra");
            System.out.println("4. Borrar línea de la compra");
            System.out.println("5. Ver total de la compra");
            System.out.println("6. Ver detalles de la compra");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Crear una nueva compra
                    System.out.print("Ingresa el número de la compra: ");
                    int numCompra = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    compra = new Compra(numCompra);
                    compraDAO.insertCompra(compra);
                    System.out.println("Compra creada con éxito.");
                    break;

                case 2:
                    // Registrar una línea en la compra
                    System.out.print("Ingresa el número de la compra: ");
                    int numCompraLinea = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    Compra compraExistente = compraDAO.obtenerCompraPorNumCompra(numCompraLinea);
                    if (compraExistente != null) {
                        System.out.print("Ingresa el nombre del producto: ");
                        String nombreProducto = scanner.nextLine();
                        System.out.print("Ingresa la cantidad del producto: ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine();  // Consumir el salto de línea
                        LineaDeTicket linea = new LineaDeTicket(compra, new Producto(nombreProducto), cantidad, compra.getNumLineasActuales()+1);
                        lineaDAO.insertLineaDeTicket(linea);
                        System.out.println("Línea registrada con éxito.");

                    } else {
                        System.out.println("Compra no encontrada.");
                    }
                    break;

                case 3:
                    // Modificar una línea en la compra
                    System.out.print("Ingresa el número de la compra: ");
                    int numCompraModificar = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    Compra compraModificar = compraDAO.obtenerCompraPorNumCompra(numCompraModificar);
                    if (compraModificar != null) {
                        System.out.print("Ingresa el número de la línea que deseas modificar (1 a " + lineaDAO.getAllLineasDeTicket().size() + "): ");
                        int lineaModificar = scanner.nextInt() - 1;  // Restamos 1 para usar el índice
                        scanner.nextLine();  // Consumir el salto de línea
                        if (lineaModificar >= 0 && lineaModificar < lineaDAO.getAllLineasDeTicket().size()) {
                            LineaDeTicket linea = lineaDAO.getAllLineasDeTicket().get(lineaModificar);

                            System.out.println("Línea actual: " + linea.getProducto().getNombre() + ", Cantidad: " + linea.getCantidad() + ", Precio: " + linea.getPrecio());
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
                    // Borrar una línea en la compra
                    System.out.print("Ingresa el número de la compra: ");
                    int numCompraBorrar = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    Compra compraBorrar = compraDAO.obtenerCompraPorNumCompra(numCompraBorrar);
                    if (compraBorrar != null) {
                        System.out.print("Ingresa el número de la línea que deseas borrar (1 a " + lineaDAO.getAllLineasDeTicket().size() + "): ");
                        int lineaBorrar = scanner.nextInt() - 1;  // Restamos 1 para usar el índice
                        scanner.nextLine();  // Consumir el salto de línea
                        if (lineaBorrar >= 0 && lineaBorrar < lineaDAO.getAllLineasDeTicket().size()) {
                            lineaDAO.deleteLineaDeTicket(numCompraBorrar,lineaBorrar);
                            System.out.println("Línea borrada con éxito.");
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
                    int numCompraTotal = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    Compra compraTotal = compraDAO.obtenerCompraPorNumCompra(numCompraTotal);
                    if (compraTotal != null) {
                        double total = compraTotal.calcularTotal();
                        System.out.println("El total de la compra es: " + total);
                    } else {
                        System.out.println("Compra no encontrada.");
                    }
                    break;

                case 6:
                    // Ver detalles de la compra
                    System.out.print("Ingresa el número de la compra: ");
                    int numCompraDetalles = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    Compra compraDetalles = compraDAO.obtenerCompraPorNumCompra(numCompraDetalles);
                    if (compraDetalles != null) {
                        System.out.println("\nDetalles de la compra:");
                        System.out.println("Número de compra: " + compraDetalles.getNumCompra());
                        System.out.println("Fecha de la compra: " + compraDetalles.getFecha());
                        System.out.println("Cliente: " + (compraDetalles.getCliente() != null ? compraDetalles.getCliente().getNombre() : "No asignado"));
                        System.out.println("Dependiente: " + (compraDetalles.getDependiente() != null ? compraDetalles.getDependiente().getNombre() : "No asignado"));
                        System.out.println("Repartidor: " + (compraDetalles.getRepartidor() != null ? compraDetalles.getRepartidor().getNombre() : "No asignado"));
                        System.out.println("Líneas de la compra:");
                        for (LineaDeTicket linea : lineaDAO.getAllLineasDeTicket()) {
                            System.out.println("Producto: " + linea.getProducto().getNombre() + ", Cantidad: " + linea.getCantidad() + ", Precio: " + linea.getPrecio());
                        }
                    } else {
                        System.out.println("Compra no encontrada.");
                    }
                    break;

                case 7:
                    // Salir
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}
