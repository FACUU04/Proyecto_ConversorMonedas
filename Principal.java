import com.google.gson.JsonObject;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            try {
                // Obtener cotizaciones desde la API
                JsonObject rates = Cotizacion.CurrencyAPI.fetchExchangeRates();

                // Interacción con el usuario
                System.out.println("Ingrese la moneda de origen (ej: USD): ");
                String from = scanner.nextLine().toUpperCase();
                System.out.println("Ingrese la moneda de destino (ej: EUR): ");
                String to = scanner.nextLine().toUpperCase();
                System.out.println("Ingrese el monto a convertir: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer de entrada

                // Calcular tipo de cambio y realizar conversión
                double rate = Conversion.getExchangeRate(rates, from, to);
                double result = Conversion.convert(amount, rate);

                // Mostrar el resultado
                System.out.printf("%.2f %s equivalen a %.2f %s%n", amount, from, result, to + " segun el tipo de cambio oficial");

                // Preguntar si desea continuar
                System.out.println("\n¿Desea hacer otra consulta? Presione 1 para continuar o 0 para salir:");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada

                if (opcion == 0) {
                    System.out.println("Gracias por usar nuestros servicios. ¡Hasta la próxima!");
                    continuar = false;
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
                continuar = false; // Salir si ocurre un error inesperado
            }
        }

        scanner.close(); // Cerrar el escáner
    }
}

