package exp1;

import ports.Ports;

import java.io.IOException;
import java.net.Socket;

public class DateTimeClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", Ports.DATE_TIME.getPort());
        String timeString = new String(socket.getInputStream().readAllBytes());
        System.out.println("Server time: " + timeString);
        socket.close();
        //abcddse
    }
}
