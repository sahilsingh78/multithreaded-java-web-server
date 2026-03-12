package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger {

    private static final String LOG_FILE = "server.log";

    public static void log(String message) {

        String logMessage =
                "[" + LocalDateTime.now() + "] " + message;

        System.out.println(logMessage);

        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {

            writer.println(logMessage);

        } catch (IOException e) {

            System.out.println("Logging failed: " + e.getMessage());
        }
    }
}