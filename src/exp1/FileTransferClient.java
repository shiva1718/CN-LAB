package exp1;

import java.io.*;
import java.net.*;
import java.util.*;

public class FileTransferClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1026);
        new FileOutputStream("received.txt").write(socket.getInputStream().readAllBytes());
        socket.close();
    }
}
