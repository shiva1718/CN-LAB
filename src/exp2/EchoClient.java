package exp2;

import ports.Ports;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Socket socket = new Socket("localhost", Ports.ECHO.getPort());
            System.out.println("Enter your message");
            String message = sc.nextLine();
            System.out.println("the echoed message");
            System.out.println(message);
            OutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.write(message.getBytes());
            outputStream.close();
            System.out.println();
            if (message.isEmpty()) {
                break;
            }
        }
    }
}
