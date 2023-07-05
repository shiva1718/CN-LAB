package exp1;

import java.io.*;
import java.net.*;
import java.util.*;

public class FileTransferServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1026);
        Socket accept = serverSocket.accept();
        accept.getOutputStream().write(new FileInputStream("sample.txt").readAllBytes());
        accept.close();
        serverSocket.close();
        System.out.println("File transferred successfully!");
    }
}
