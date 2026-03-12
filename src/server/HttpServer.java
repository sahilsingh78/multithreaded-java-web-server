package server;

import utils.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {

    private static final int PORT = 8080;
    private static final int THREAD_POOL_SIZE = 10;

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            Logger.log("Server started on port " + PORT);

            while (true) {

                Socket clientSocket = serverSocket.accept();

                Logger.log("New connection from " + clientSocket.getInetAddress());

                threadPool.execute(new ClientHandler(clientSocket));

            }

        } catch (IOException e) {

            Logger.log("Server error: " + e.getMessage());
        }
    }
}