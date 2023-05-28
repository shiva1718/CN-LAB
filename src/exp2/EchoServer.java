package exp2;

import ports.Ports;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(Ports.ECHO.getPort());
        while (true) {
            Socket accept = serverSocket.accept();
//            System.out.println("Client connected: " + accept.getInetAddress());
            DataInputStream inputStream = new DataInputStream(accept.getInputStream());
            byte[] bytes = inputStream.readAllBytes();
            String clientMessage = new String(bytes);
            System.out.println("Message from client...");
            System.out.println(clientMessage);
            System.out.println();
        }
    }
}
