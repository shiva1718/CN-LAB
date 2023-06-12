package exp1;

import ports.Ports;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(Ports.CHAT.getPort());
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
            if (message.equalsIgnoreCase("bye") || message.equalsIgnoreCase("quit")) {
                serverSocket.close();
                break;
            }
            accept.close();
        }

    }
}
