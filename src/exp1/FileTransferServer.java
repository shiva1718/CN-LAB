package exp1;

import ports.Ports;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileTransferServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(Ports.FILE_TRANSFER.getPort());
        Socket accept = serverSocket.accept();
        new FileInputStream("sample.txt").transferTo(accept.getOutputStream());
        accept.close();
        serverSocket.close();
        System.out.println("File transferred successfully!");
    }
}
