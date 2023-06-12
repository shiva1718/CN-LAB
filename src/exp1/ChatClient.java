package exp1;

import ports.Ports;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Socket socket = new Socket("localhost", Ports.CHAT.getPort());
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("Enter your message: ");
            String message = sc.nextLine();
            outputStream.write(message.getBytes());
            outputStream.close();
            socket = new Socket("localhost", Ports.CHAT.getPort());
            InputStream inputStream = socket.getInputStream();
            System.out.println("Reply:");
            String reply = new String(inputStream.readAllBytes());
            System.out.println(reply);
            if (message.equalsIgnoreCase("bye") || message.equalsIgnoreCase("quit")) {
                socket.close();
                break;
            }
            inputStream.close();
        }
    }
}
