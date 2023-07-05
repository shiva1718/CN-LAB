package exp1;

import java.io.*;
import java.net.*;


// Another Chat-Server program, also works
public class ChatServer2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(2000);
        Socket sk = ss.accept();
        BufferedReader cin = new BufferedReader(new InputStreamReader(sk.getInputStream()));
        PrintStream cout = new PrintStream(sk.getOutputStream());
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = cin.readLine().trim();
            if (s.equalsIgnoreCase("END") || s.equalsIgnoreCase("Bye")) {
                cout.println("BYE");
                break;
            }
            System.out.println("Client : " + s);
            System.out.print("Server : ");
            s = stdin.readLine();
            cout.println(s);
        }
        ss.close();
    }
}
