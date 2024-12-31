import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class Cotizacion {
    public static class CurrencyAPI {
        private static final String API_URL = "https://v6.exchangerate-api.com/v6/8b6110860f0d1b526eb89242/latest/USD";

        public static JsonObject fetchExchangeRates() throws Exception {
            // Crear cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear solicitud
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .GET()
                    .build();

            // Enviar solicitud y obtener respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Convertir JSON a objeto y retornar el objeto "conversion_rates"
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
            return jsonResponse.getAsJsonObject("conversion_rates");
        }
    }
}
