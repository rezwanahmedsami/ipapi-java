package ipapi.java;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Ipapi {

    private static final String BASE_URL = "https://api.ipquery.io/";

    private static final HttpClient client = HttpClient.newHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Fetches the IP information for a given IP address
    public static IPInfo queryIp(String ip) throws IOException, InterruptedException {
        String url = BASE_URL + ip;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), IPInfo.class);
    }

    // Fetches information for multiple IP addresses
    public static List<IPInfo> queryBulk(List<String> ips) throws IOException, InterruptedException {
        String ipList = String.join(",", ips);
        String url = BASE_URL + ipList;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        IPInfo[] ipInfos = objectMapper.readValue(response.body(), IPInfo[].class);
        return Arrays.asList(ipInfos);
    }

    // Fetches the IP address of the current machine
    public static String queryOwnIp() throws IOException, InterruptedException {
        String url = BASE_URL;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
