package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class HttpRequest {

    private String method;
    private String path;
    private String protocol;
    private Map<String, String> headers;

    public HttpRequest(String method, String path, String protocol, Map<String, String> headers) {
        this.method = method;
        this.path = path;
        this.protocol = protocol;
        this.headers = headers;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getProtocol() {
        return protocol;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}

public class HttpParser {

    public static HttpRequest parse(BufferedReader reader) throws IOException {

        String requestLine = reader.readLine();

        if (requestLine == null || requestLine.isEmpty()) {
            return null;
        }

        String[] parts = requestLine.split(" ");

        String method = parts[0];
        String path = parts[1];
        String protocol = parts[2];

        Map<String, String> headers = new HashMap<>();

        String line;

        while ((line = reader.readLine()) != null && !line.isEmpty()) {

            String[] headerParts = line.split(": ");

            if (headerParts.length == 2) {
                headers.put(headerParts[0], headerParts[1]);
            }
        }

        return new HttpRequest(method, path, protocol, headers);
    }
}