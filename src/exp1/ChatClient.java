package exp1;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Socket socket = new Socket("localhost", 1025);
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("Enter your message: ");
            String message = sc.nextLine();
            outputStream.write(message.getBytes());
            outputStream.close();
            socket = new Socket("localhost", 1025);
            InputStream inputStream = socket.getInputStream();
            System.out.println("Reply:");
            String reply = new String(inputStream.readAllBytes());
            System.out.println(reply);
            if (message.equalsIgnoreCase("bye") || message.equalsIgnoreCase("quit") ||
                    reply.equalsIgnoreCase("bye") || reply.equalsIgnoreCase("quit")) {
                socket.close();
                break;
            }
            inputStream.close();
        }
    }
}
