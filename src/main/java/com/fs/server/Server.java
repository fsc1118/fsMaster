package com.fs.server;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.net.InetSocketAddress;
import java.io.IOException;
import java.io.OutputStream;

class MyHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        final String requestURL = exchange.getRequestURI().toString();
        String response = null;
        if (requestURL.equals("/")) {
            // Serve as a health check
            response = "Server is running\n";
            exchange.sendResponseHeaders(200, response.length());
        } else {
            response = "404 (Not Found)\n";
            exchange.sendResponseHeaders(404, response.length());
        }
        final OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }
}

public class Server {
    private static HttpServer server = null;

    private static void initializeServer() {
        int port = 8080;
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
        } catch (IOException e) {
            System.out.println("Error creating server: " + e.getMessage());
            return;
        }
        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();
    }

    public static HttpServer getServerInstance() {
        if (server == null) {
            initializeServer();
        }
        return server;
    }
}
