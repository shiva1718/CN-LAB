package exp1;

import ports.Ports;

import java.io.IOException;
import java.net.Socket;

public class FileTransferClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", Ports.FILE_TRANSFER.getPort());
        socket.getInputStream().transferTo(System.out);
        socket.close();
    }
}
