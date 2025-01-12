import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/2a1905e68b4fbc49f516fe0e/pair/";
    private final HttpClient httpClient;
    private final Gson gson;

    public ConsultaMoneda() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public Monedas buscarMoneda(String monedaBase, String monedaTarget) {
        validarParametros(monedaBase, monedaTarget);

        URI uri = URI.create(API_BASE_URL + monedaBase + "/" + monedaTarget + "/");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return gson.fromJson(response.body(), Monedas.class);
            } else {
                throw new RuntimeException("Error al consultar la API. Código de respuesta: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt(); // Restablecer el estado de interrupción si fue interrumpido
            throw new RuntimeException("Error al realizar la solicitud: " + e.getMessage(), e);
        }
    }

    private void validarParametros(String monedaBase, String monedaTarget) {
        if (monedaBase == null || monedaBase.isBlank()) {
            throw new IllegalArgumentException("La moneda base no puede ser nula o vacía.");
        }
        if (monedaTarget == null || monedaTarget.isBlank()) {
            throw new IllegalArgumentException("La moneda objetivo no puede ser nula o vacía.");
        }
    }
}
