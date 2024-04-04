import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CarritoDeCompras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> carrito = new ArrayList<>();
        double total = 0;

        Map<Integer, String> productos = new LinkedHashMap<>();
        productos.put(1, "Producto1 - Precio: $10");
        productos.put(2, "Producto2 - Precio: $15");
        productos.put(3, "Producto3 - Precio: $20");
        productos.put(4, "Producto4 - Precio: $25");
        productos.put(5, "Producto5 - Precio: $30");

        System.out.println("Lista de productos disponibles:");
        for (Map.Entry<Integer, String> producto : productos.entrySet()) {
            System.out.println(producto.getKey() + ". " + producto.getValue());
        }

        while (true) {
            System.out.print("Ingrese el número del producto que desea agregar al carrito (0 para terminar): ");
            int entrada = scanner.nextInt();

            if (entrada == 0) {
                break;
            }

            if (productos.containsKey(entrada)) {
                carrito.add(productos.get(entrada));
                total += obtenerPrecio(productos.get(entrada));
                System.out.println("Producto agregado al carrito.");
            } else {
                System.out.println("Producto no encontrado.");
            }
        }

        System.out.println("Carrito finalizado. Total: $" + total);
        System.out.print("¿Desea pagar? (sí/no): ");
        String pagar = scanner.next();

        if (pagar.equalsIgnoreCase("si")) {
            System.out.println("Pago realizado con éxito. Gracias por su compra.");
        } else {
            System.out.println("Pago Rechazado");
        }

        scanner.close();
    }

    private static double obtenerPrecio(String producto) {
        String[] partes = producto.split(" ");
        String precioStr = partes[partes.length - 1].substring(1);
        return Double.parseDouble(precioStr);
    }
}
