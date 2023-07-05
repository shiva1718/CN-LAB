package exp2;

import java.io.*;
import java.net.*;
import java.util.*;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Socket socket = new Socket("localhost", 1027);
            System.out.println("Enter your message");
            String message = sc.nextLine();
            System.out.println("the echoed message");
            System.out.println(message);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(message.getBytes());
            outputStream.close();
            System.out.println();
            if (message.isEmpty()) {
                break;
            }
        }
    }
}
