package exp1;

import java.io.*;
import java.net.*;
import java.util.*;

public class DateTimeClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1024);
        String timeString = new String(socket.getInputStream().readAllBytes());
        System.out.println("Server time: " + timeString);
        socket.close();
    }
}
