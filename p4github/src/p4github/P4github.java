
package p4github;

import java.util.ArrayList;
import java.util.Scanner;

class Producto {
    String nombre;
    double precio;
    int cantidadEnStock;

    public Producto(String nombre, double precio, int cantidadEnStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
    }
}

public class P4github {
    public static void main(String[] args) {
        ArrayList<Producto> inventario = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n======= GESTIÓN DE INVENTARIO =======");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Actualizar Inventario");
            System.out.println("3. Buscar Producto");
            System.out.println("4. Mostrar Inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    agregarProducto(inventario, scanner);
                    break;
                case 2:
                    actualizarInventario(inventario, scanner);
                    break;
                case 3:
                    buscarProducto(inventario, scanner);
                    break;
                case 4:
                    mostrarInventario(inventario);
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static void agregarProducto(ArrayList<Producto> inventario, Scanner scanner) {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio del producto: ");
        double precio = scanner.nextDouble();

        System.out.print("Cantidad en stock: ");
        int cantidad = scanner.nextInt();

        Producto nuevoProducto = new Producto(nombre, precio, cantidad);
        inventario.add(nuevoProducto);

        System.out.println("Producto agregado con éxito.");
    }

    private static void actualizarInventario(ArrayList<Producto> inventario, Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a actualizar: ");
        String nombreProducto = scanner.nextLine();

        for (Producto producto : inventario) {
            if (producto.nombre.equals(nombreProducto)) {
                System.out.print("Ingrese la nueva cantidad en stock: ");
                int nuevaCantidad = scanner.nextInt();
                producto.cantidadEnStock = nuevaCantidad;
                System.out.println("Inventario actualizado para " + nombreProducto);
                return;
            }
        }

        System.out.println("Producto no encontrado en el inventario.");
    }

    private static void buscarProducto(ArrayList<Producto> inventario, Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String nombreProducto = scanner.nextLine();

        for (Producto producto : inventario) {
            if (producto.nombre.equals(nombreProducto)) {
                System.out.println("Detalles del Producto:");
                System.out.println("Nombre: " + producto.nombre);
                System.out.println("Precio: " + producto.precio);
                System.out.println("Cantidad en stock: " + producto.cantidadEnStock);
                return;
            }
        }

        System.out.println("Producto no encontrado en el inventario.");
    }

    private static void mostrarInventario(ArrayList<Producto> inventario) {
        System.out.println("\nInventario Actual:");
        for (Producto producto : inventario) {
            System.out.println("Nombre: " + producto.nombre);
            System.out.println("Precio: <" + producto.precio);
            System.out.println("Cantidad en stock: " + producto.cantidadEnStock);
            System.out.println("-------------------------");
        }
    }
}
