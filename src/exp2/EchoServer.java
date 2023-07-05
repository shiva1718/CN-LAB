package exp2;

import java.io.*;
import java.net.*;
import java.util.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1027);
        while (true) {
            Socket accept = serverSocket.accept();
//            System.out.println("Client connected: " + accept.getInetAddress());
            InputStream inputStream = accept.getInputStream();
            String clientMessage = new String(inputStream.readAllBytes());
            System.out.println("Message from client...");
            System.out.println(clientMessage);
            System.out.println();
        }
    }
}
