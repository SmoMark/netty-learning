package com.smomark.jdk.bio.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BioSocketServer {
    public static void main(String[] args) throws IOException {
        int port = 8899;
        ServerSocket serverSocket = new ServerSocket(port);
        //阻塞直到建立连接
        Socket socket = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        String request, response;
        while ((request = bufferedReader.readLine()) != null) {
            if ("Done".equals(request)) {
                break;
            }
            response = "Receive request " + request;
            writer.println(response);
        }
    }
}
