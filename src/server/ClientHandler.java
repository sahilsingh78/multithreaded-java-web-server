package server;

import utils.Logger;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

                OutputStream output = socket.getOutputStream()

        ) {

            HttpRequest request = HttpParser.parse(reader);

            if (request == null) {
                return;
            }

            Logger.log("Request: " + request.getMethod() + " " + request.getPath());

            String filePath = "public" + request.getPath();

            if (request.getPath().equals("/")) {
                filePath = "public/index.html";
            }

            File file = new File(filePath);

            if (file.exists() && !file.isDirectory()) {

                byte[] fileData = readFile(file);

                String contentType = getContentType(filePath);

                String header =
                        "HTTP/1.1 200 OK\r\n" +
                        "Content-Length: " + fileData.length + "\r\n" +
                        "Content-Type: " + contentType + "\r\n\r\n";

                output.write(header.getBytes());
                output.write(fileData);

            } else {

                String response =
                        "HTTP/1.1 404 Not Found\r\n" +
                        "Content-Type: text/html\r\n\r\n" +
                        "<h1>404 Not Found</h1>";

                output.write(response.getBytes());
            }

            output.flush();

        } catch (Exception e) {

            Logger.log("Client error: " + e.getMessage());

        } finally {

            try {
                socket.close();
            } catch (IOException ignored) {}
        }
    }

    private byte[] readFile(File file) throws IOException {

        FileInputStream fis = new FileInputStream(file);

        byte[] data = fis.readAllBytes();

        fis.close();

        return data;
    }

    private String getContentType(String path) {

        if (path.endsWith(".html")) return "text/html";
        if (path.endsWith(".css")) return "text/css";
        if (path.endsWith(".js")) return "application/javascript";
        if (path.endsWith(".png")) return "image/png";
        if (path.endsWith(".jpg")) return "image/jpeg";

        return "text/plain";
    }
}