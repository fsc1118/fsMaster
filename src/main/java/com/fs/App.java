package com.fs;

import com.fs.server.Server;
import com.sun.net.httpserver.HttpServer;

public class App {
    public static void main(String[] args) {
        final HttpServer server = Server.getServerInstance();
    }
}
