package exp1;

import java.io.*;
import java.net.*;
import java.util.*;
import java.time.*;

public class DateTimeServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1024);
        while (true) {
            Socket accept = serverSocket.accept();
            System.out.println("Client connected: " + accept.getInetAddress());
            accept.getOutputStream().write(LocalDateTime.now().toString().getBytes());
            accept.close();
        }
    }
}
