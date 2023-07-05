package exp1;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1025);
        Scanner sc = new Scanner(System.in);
        while (true) {
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
//            System.out.println("Client connected: " + accept.getInetAddress());
            String message = new String(inputStream.readAllBytes());
            System.out.println("Client message:");
            System.out.println(message);
            accept.close();
            accept = serverSocket.accept();
            OutputStream outputStream = accept.getOutputStream();
            System.out.println("Enter your message: ");
            String reply = sc.nextLine();
            outputStream.write(reply.getBytes());
            System.out.println();
            accept.close();
            if (message.equalsIgnoreCase("bye") || message.equalsIgnoreCase("quit") ||
                    reply.equalsIgnoreCase("bye") || reply.equalsIgnoreCase("quit")) {
                serverSocket.close();
                break;
            }
        }

    }
}
