import com.google.gson.JsonObject;

public class Conversion {
    public static double getExchangeRate(JsonObject rates, String from, String to) {
        // Obtener las tasas de cambio para "from" y "to"
        double fromRate = rates.get(from).getAsDouble();
        double toRate = rates.get(to).getAsDouble();

        // Calcular el tipo de cambio
        return toRate / fromRate;
    }

    public static double convert(double amount, double rate) {
        return amount * rate;
    }
}


