package exp1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class DateTimeServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        while (true) {
            Socket accept = serverSocket.accept();
            System.out.println("Client connected: " + accept.getInetAddress());
            String timeString = LocalDateTime.now().toString();
            accept.getOutputStream().write(timeString.getBytes());
            accept.close();
        }
    }
}
