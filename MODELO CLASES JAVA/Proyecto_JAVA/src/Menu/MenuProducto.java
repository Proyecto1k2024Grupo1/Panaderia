package Menu;

import DAO.AjenoDAO;
import DAO.PropioDAO;
import Model.Ajeno;
import Model.Producto;
import Model.Propio;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Clase que proporciona un menú interactivo para la gestión de productos.
 * Permite añadir, mostrar, modificar y eliminar productos propios y ajenos mediante el uso de DAOs.
 *
 * @author Vanesa, Silvia, Jessica
 * @version 1.1
 * @date 10/04/2025
 */

public class MenuProducto {


        private static PropioDAO propioDAO = PropioDAO.getInstance();
        private static AjenoDAO ajenoDAO = AjenoDAO.getInstance();

      /**
       * Método principal que lanza el menú de gestión de productos.
       * Permite al usuario seleccionar operaciones CRUD sobre productos propios o ajenos.
       *
       * @param args Argumentos de línea de comandos (no utilizados).
       * @throws SQLException Si ocurre un error durante la ejecución de las operaciones de base de datos.
        */
        public static void main(String[] args) throws SQLException {
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("********* Menú de Productos *********");
                System.out.println("1. Agregar producto propio");
                System.out.println("2. Agregar producto ajeno");
                System.out.println("3. Mostrar todos los productos");
                System.out.println("4. Modificar producto propio");
                System.out.println("5. Modificar producto ajeno");
                System.out.println("6. Eliminar producto propio");
                System.out.println("7. Eliminar producto ajeno");
                System.out.println("8. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1 -> agregarPropio(scanner);
                    case 2 -> agregarAjeno(scanner);
                    case 3 -> mostrarTodos();
                    case 4 -> modificarPropio(scanner);
                    case 5 -> modificarAjeno(scanner);
                    case 6 -> eliminarPropio(scanner);
                    case 7 -> eliminarAjeno(scanner);
                    case 8 -> System.out.println("¡Hasta luego!");
                    default -> System.out.println("Opción inválida.");
                }
            } while (opcion != 8);
        }

       /**
       * Agrega un nuevo producto propio a la base de datos.
       *
       * @param scanner Objeto Scanner para capturar entrada del usuario.
       * @throws SQLException Si ocurre un error al insertar el producto.
       */
        private static void agregarPropio(Scanner scanner) throws SQLException {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Tipo: ");
            String tipo = scanner.nextLine();
            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();


            Propio propio = new Propio(0,nombre, tipo, precio);
            propioDAO.insertPropio(propio);
            System.out.println("Producto propio agregado.");
        }

    /**
     * Agrega un nuevo producto ajeno a la base de datos.
     *
     * @param scanner Objeto Scanner para capturar entrada del usuario.
     * @throws SQLException Si ocurre un error al insertar el producto.
     */
    private static void agregarAjeno(Scanner scanner) throws SQLException {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Tipo: ");
            String tipo = scanner.nextLine();
            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();

            Ajeno ajeno = new Ajeno(0,nombre, tipo, precio);
            ajenoDAO.insertAjeno(ajeno);
            System.out.println("Producto ajeno agregado.");
        }

    /**
     * Muestra todos los productos propios y ajenos registrados en el sistema.
     * @throws SQLException Si ocurre un error al recuperar los datos.
     * @throws SQLException
     */
    private static void mostrarTodos() throws SQLException {
            System.out.println("------ Productos Propios ------");
            for (Propio p : propioDAO.getAllPropio()) {
                System.out.println(p);
            }

            System.out.println("------ Productos Ajenos ------");
            for (Ajeno a : ajenoDAO.getAllAjenos()) {
                System.out.println(a);
            }
        }

    /**
     * Modifica un producto propio identificado por su ID.
     * @param scanner Objeto Scanner para capturar entrada del usuario.
     * @throws SQLException Si ocurre un error al actualizar el producto.
     * @param scanner
     * @throws SQLException
     */
    private static void modificarPropio(Scanner scanner) throws SQLException {
            System.out.print("ID del producto propio a modificar: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Propio propio = propioDAO.getPropioByCodigo(id);
            if (propio == null) {
                System.out.println("Producto no encontrado.");
                return;
            }

            System.out.print("Nuevo nombre (actual: " + propio.getNombre() + "): ");
            String nombre = scanner.nextLine();
            if (!nombre.isEmpty()) propio.setNombre(nombre);

            System.out.print("Nuevo tipo (actual: " + propio.getTipo() + "): ");
            String tipo = scanner.nextLine();
            if (!tipo.isEmpty()) propio.setTipo(tipo);

            System.out.print("Nuevo precio (actual: " + propio.getPrecio() + "): ");
            double precio = scanner.nextDouble();
            scanner.nextLine();
            if (precio >= 0) propio.setPrecio(precio);


            propioDAO.updatePropio(propio);
            System.out.println("Producto propio modificado.");
        }

    /**
     * Modifica un producto ajeno identificado por su ID.
     *
     * @param scanner Objeto Scanner para capturar entrada del usuario.
     * @throws SQLException Si ocurre un error al actualizar el producto.
     */
    private static void modificarAjeno(Scanner scanner) throws SQLException {
            System.out.print("ID del producto ajeno a modificar: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Ajeno ajeno = ajenoDAO.getAjenoByCodigo(id);
            if (ajeno == null) {
                System.out.println("Producto no encontrado.");
                return;
            }

            System.out.print("Nuevo nombre (actual: " + ajeno.getNombre() + "): ");
            String nombre = scanner.nextLine();
            if (!nombre.isEmpty()) ajeno.setNombre(nombre);

            System.out.print("Nuevo tipo (actual: " + ajeno.getTipo() + "): ");
            String tipo = scanner.nextLine();
            if (!tipo.isEmpty()) ajeno.setTipo(tipo);

            System.out.print("Nuevo precio (actual: " + ajeno.getPrecio() + "): ");
            double precio = scanner.nextDouble();
            scanner.nextLine();
            if (precio >= 0) ajeno.setPrecio(precio);

            ajenoDAO.updateAjeno(ajeno);
            System.out.println("Producto ajeno modificado.");
        }

    /**
     * Elimina un producto propio de la base de datos a partir de su ID.
     *
     * @param scanner Objeto Scanner para capturar entrada del usuario.
     * @throws SQLException Si ocurre un error al eliminar el producto.
     */
    private static void eliminarPropio(Scanner scanner) throws SQLException {
            System.out.print("ID del producto propio a eliminar: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Propio propio = propioDAO.getPropioByCodigo(id);
            if (propio == null) {
                System.out.println("Producto no encontrado.");
                return;
            }

            propioDAO.deletePropioByCodigo(id);
            System.out.println("Producto propio eliminado.");
        }

    /**
     * Elimina un producto ajeno de la base de datos a partir de su ID.
     *
     * @param scanner Objeto Scanner para capturar entrada del usuario.
     * @throws SQLException Si ocurre un error al eliminar el producto.
     */
    private static void eliminarAjeno(Scanner scanner) throws SQLException {
            System.out.print("ID del producto ajeno a eliminar: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Ajeno ajeno = ajenoDAO.getAjenoByCodigo(id);
            if (ajeno == null) {
                System.out.println("Producto no encontrado.");
                return;
            }

            ajenoDAO.deleteAjenoByCodigo(id);
            System.out.println("Producto ajeno eliminado.");
        }

}
