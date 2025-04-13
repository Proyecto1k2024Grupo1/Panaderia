package Menu;

import DAO.CompraDAO;
import Model.Compra;
import Model.Cliente;
import Model.Dependiente;
import Model.Repartidor;

import java.util.List;
import java.util.Scanner;

public class MenuCompra {

    private static Scanner scanner = new Scanner(System.in);
    private static CompraDAO compraDAO = CompraDAO.getInstance();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\nMenú de Compras");
            System.out.println("1. Insertar nueva compra");
            System.out.println("2. Mostrar todas las compras");
            System.out.println("3. Actualizar cliente de una compra");
            System.out.println("4. Actualizar dependiente de una compra");
            System.out.println("5. Actualizar repartidor de una compra");
            System.out.println("6. Eliminar compra");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    insertarCompra();
                    break;
                case 2:
                    mostrarCompras();
                    break;
                case 3:
                    actualizarClienteCompra();
                    break;
                case 4:
                    actualizarDependienteCompra();
                    break;
                case 5:
                    actualizarRepartidorCompra();
                    break;
                case 6:
                    eliminarCompra();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 7);
    }

    private static void insertarCompra() {
        System.out.println("Ingrese el ID del cliente:");
        int idCliente = scanner.nextInt();
        // Crear el objeto compra y asignar los detalles
        Compra compra = new Compra();
        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);
        compra.setCliente(cliente);

        try {
            compraDAO.insertCompra(compra);
            System.out.println("Compra insertada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar la compra: " + e.getMessage());
        }
    }

    private static void mostrarCompras() {
        try {
            List<Compra> compras = compraDAO.getAllCompra();
            for (Compra compra : compras) {
                System.out.println("Compra ID: " + compra.getNumCompra() + ", Cliente ID: " + compra.getCliente().getIdCliente());
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar las compras: " + e.getMessage());
        }
    }

    private static void actualizarClienteCompra() {
        System.out.println("Ingrese el número de compra a actualizar:");
        int numCompra = scanner.nextInt();
        System.out.println("Ingrese el nuevo ID de cliente:");
        int idCliente = scanner.nextInt();

        try {
            compraDAO.updateCompraCliente(numCompra, idCliente);
            System.out.println("Cliente actualizado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
        }
    }

    private static void actualizarDependienteCompra() {
        System.out.println("Ingrese el número de compra a actualizar:");
        int numCompra = scanner.nextInt();
        System.out.println("Ingrese el DNI del dependiente:");
        String dniDependiente = scanner.next();
        System.out.println("Ingrese el descuento del dependiente:");
        double descuento = scanner.nextDouble();

        try {
            compraDAO.updateCompraDependiente(numCompra, dniDependiente, descuento);
            System.out.println("Dependiente actualizado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar el dependiente: " + e.getMessage());
        }
    }

    private static void actualizarRepartidorCompra() {
        System.out.println("Ingrese el número de compra a actualizar:");
        int numCompra = scanner.nextInt();
        System.out.println("Ingrese el DNI del repartidor:");
        String dniRepartidor = scanner.next();

        try {
            compraDAO.updateCompraRepartidor(numCompra, dniRepartidor);
            System.out.println("Repartidor actualizado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar el repartidor: " + e.getMessage());
        }
    }

    private static void eliminarCompra() {
        System.out.println("Ingrese el número de compra a eliminar:");
        int numCompra = scanner.nextInt();

        try {
            compraDAO.deleteCompraByNum(numCompra);
            System.out.println("Compra eliminada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar la compra: " + e.getMessage());
        }
    }
}